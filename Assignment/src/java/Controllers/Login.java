/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.DBContext;
import DAO.MyConnection;
import Models.*;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ADMIN
 */
//@WebServlet({"/", "/index.html"})
public class Login extends HttpServlet {

    Connection con;
    MyConnection myCon;
    public String error = "oke";

    @Override
    public void init() throws ServletException {
        try {
            con = new DBContext().getConnection();
            myCon = new MyConnection();
        } catch (Exception e) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("./Views/Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        Account acc = checkAccount(username, password);
        if (acc == null) {
            request.setAttribute("message", "Tên đăng nhập hoặc mật khẩu không đúng!");
            request.getRequestDispatcher("./Views/Login.jsp").forward(request, response);
        } else {
            if (!acc.isStatus()) {
                request.setAttribute("message", "Tài khoản của bạn chưa được kích hoạt!");
                request.getRequestDispatcher("./Views/Login.jsp").forward(request, response);
            }
            UserInfo infor = myCon.getUserInfo(acc.getUserinfo_id());
            Cookie user = new Cookie("user", username);
            Cookie pass = new Cookie("pass", password);
            if (remember != null) {
                user.setMaxAge(60 * 60 * 24);
                pass.setMaxAge(60 * 60 * 24);
            } else {
                user.setMaxAge(0);
                pass.setMaxAge(0);
            }
            response.addCookie(user);
            response.addCookie(pass);
            Post mainPost = myCon.getPost(1, "hieuhn0301");
            HttpSession session = request.getSession();
            session.setAttribute("acc", acc);
            session.setAttribute("userinfo", infor);
            session.setAttribute("post", mainPost);
            if (acc.getType_id() == 0) {
                request.getRequestDispatcher("./Views/Admins/AdminHome.jsp").forward(request, response);
            } else if (acc.getType_id() == 1) {
                response.sendRedirect("./LoadItems");
                //request.getRequestDispatcher("./LoadItems").forward(request, response);
            } else if (acc.getType_id() == 2) {
                response.sendRedirect("./User");
                //request.getRequestDispatcher("./User").forward(request, response);
            }
        }
    }

    private Account checkAccount(String username, String password) {
        String sql = "SELECT * \n"
                + " FROM Account_HE163048 \n"
                + " WHERE username = ? AND [password] = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String email = rs.getString("email");
                int type_id = rs.getInt("type_id");
                int userinfo_id = rs.getInt("userinfo_id");
                boolean status = rs.getBoolean("status");
                return new Account(username, password, email, type_id, userinfo_id, status);
            }
        } catch (Exception e) {
            error = "Loi check account tu db " + e.getMessage();
        }
        return null;
    }
}
