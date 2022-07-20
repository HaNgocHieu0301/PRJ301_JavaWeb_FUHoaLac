/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.MyConnection;
import Models.OrderItem;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class OrderDetail extends HttpServlet {

    MyConnection myCon;

    @Override
    public void init() throws ServletException {
        myCon = new MyConnection();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        ArrayList<OrderItem> orderItemList = myCon.getOrderItemList(order_id);
        request.setAttribute("orderItemList", orderItemList);
        request.getRequestDispatcher("./Views/Shops/OrderDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
