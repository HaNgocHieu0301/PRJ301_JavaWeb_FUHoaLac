/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.MyConnection;
import Models.Account;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class AccountControl extends HttpServlet {

    MyConnection myCon;

    @Override
    public void init() throws ServletException {
        myCon = new MyConnection();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        try {
            Account acc = myCon.getAccount(username);
            if (acc == null) {
                request.setAttribute("mess", "Account is not exits.");
            } else {
                request.setAttribute("searchAcc", acc);
            }
            request.getRequestDispatcher("./Views/Admins/AdminHome.jsp").forward(request, response);
        } catch (Exception e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mess = "";
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        if (action.equals("unlock")) {
            myCon.updateStatusAccount(1, username);
            mess = "Tài khoản đã được mở khóa!";
        }
        if (action.equals("lock")) {
            myCon.updateStatusAccount(0, username);
            mess = "Tài khoản đã bị khóa!";
        }
        request.setAttribute("mess", mess);
        request.getRequestDispatcher("./Views/Admins/AdminHome.jsp").forward(request, response);
    }
}
