/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.DBContext;
import DAO.MyConnection;
import Models.Account;
import Models.SendEmail;
import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author ADMIN
 */
public class CreateAccount extends HttpServlet {

    Connection con;
    SendEmail sendEmail;
    MyConnection myCon;

    @Override
    public void init() throws ServletException {
        try {
            con = new DBContext().getConnection();
            sendEmail = new SendEmail();
            myCon = new MyConnection();
        } catch (Exception e) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("./Views/Signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String re_password = request.getParameter("re_password");
        String email = request.getParameter("email");
        int type_id = Integer.parseInt(request.getParameter("type_id"));

        if (myCon.getAccountByEmail(email) != null) {
            request.setAttribute("message", "Email exists");
            doGet(request, response);
            return;
        }
        if (myCon.getAccountByUsername(username) != null) {
            request.setAttribute("message", "Username exists");
            doGet(request, response);
        } else {
            insertAccount(username, password, email, type_id, 0);
            Account acc = new Account(username, password, email, type_id, -1, false);
            String text = "Registered successfully.\n"
                    + "Please verify your account using this code: ";
            String verifyCode = sendEmail.sendCode(email, text);
            session.setAttribute("verifyCode", verifyCode);
            session.setAttribute("newAcc", acc);
            request.getRequestDispatcher("./Views/VerifyAccount.jsp").forward(request, response);
        }
    }

    public void insertAccount(String username, String password, String email, int type_id, int status) {
        String sql = "INSERT INTO Account(username,password,type_id,status,email)\n"
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setInt(3, type_id);
            ps.setInt(4, status);
            ps.setString(5, email);
            ps.execute();
        } catch (Exception e) {
        }
    }
//    public static void main(String[] args) throws ServletException {
//        CreateAccount ca = new CreateAccount();
//        ca.init();
//        ca.insertAccount("hangochieu", "123", "hangochieu6a", 2, 0);
//    }
}
