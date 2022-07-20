/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.MyConnection;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class ModifyPayment extends HttpServlet {

    MyConnection myCon;

    @Override
    public void init() throws ServletException {
        myCon = new MyConnection();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String payment_username = request.getParameter("payment_username");
        String payment_note = request.getParameter("payment_note");
        int payment_id = Integer.parseInt(request.getParameter("payment_id"));
        if (action.equals("update")) {
            request.setAttribute("payment_content", payment_note);
            request.setAttribute("payment_id", payment_id);
            request.setAttribute("payment_username", payment_username);
            //request.
        }
    }
}
