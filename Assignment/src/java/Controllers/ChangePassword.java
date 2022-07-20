/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.MyConnection;
import Models.Account;
import Models.SendEmail;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.PreparedStatement;

/**
 *
 * @author ADMIN
 */
public class ChangePassword extends HttpServlet {

    MyConnection myCon;
    SendEmail sendEmail;

    @Override
    public void init() throws ServletException {
        sendEmail = new SendEmail();
        myCon = new MyConnection();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("./Views/ForgetPassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String email = request.getParameter("email");
        if (email != null) {
            if (myCon.getAccountByEmail(email) == null) {
                request.setAttribute("message", "Email doesn't match with any account.");
                doGet(request, response);
                return;
            }
            String text = "You are asking for a new password.\n"
                    + "Your verify code is: ";
            String verifyCode = sendEmail.sendCode(email, text);
            Account acc = myCon.getAccountByEmail(email);
            session.setAttribute("acc", acc);
            session.setAttribute("forgetPassword", true);
            session.setAttribute("verifyCode", verifyCode);
            request.getRequestDispatcher("./Views/VerifyAccount.jsp").forward(request, response);
        } else {
            String oldPassword = request.getParameter("oldPassword");
            String newPassword = request.getParameter("newPassword");
            String re_password = request.getParameter("re_password");

            /**
             * session.getAttribute("acc") de lay ra username cua account nham
             * thuc hien cau lenh sql cho muc dich thay doi pass
             *
             * - Khi login thi acc da duoc luu vao session
             *
             * - Khi k login ma click quen pass thi acc duoc luu luc nhap email
             */
            Account acc = (Account) session.getAttribute("acc");
            if (oldPassword != null && !myCon.checkPassword(acc.getUsername(), oldPassword)) {
                request.setAttribute("message", "Password is wrong. Please enter again!");
                request.getRequestDispatcher("Views/changePassword.jsp").forward(request, response);
                return;
            }
            myCon.changePassword(acc.getUsername(), newPassword);
            response.sendRedirect("/Assignment/Views/Notice.jsp");
        }
    }
}
