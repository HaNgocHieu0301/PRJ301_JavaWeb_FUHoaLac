/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.MyConnection;
import Models.Account;
import Models.OrderItem;
import Models.PaymentSeller;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ADMIN
 */
public class Payment extends HttpServlet {

    MyConnection myCon;

    @Override
    public void init() throws ServletException {
        myCon = new MyConnection();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String shopName = request.getParameter("shopName");
        HttpSession session = request.getSession();
        HashMap<String, ArrayList<OrderItem>> cart = (HashMap<String, ArrayList<OrderItem>>) session.getAttribute("orderItemHM");
        ArrayList<OrderItem> orderItemList = cart.get(shopName);
        ArrayList<PaymentSeller> paymentList = myCon.getPaymentSellerList(shopName);
        String payment_name = paymentList.get(1).getPayment_name();
        request.setAttribute("paymentList", paymentList);
        request.setAttribute("orderItemList", orderItemList);
        request.getRequestDispatcher("./Views/Users/Payment.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Account acc = (Account) request.getSession().getAttribute("acc");
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        if (acc.getType_id() == 2) {
            String username = acc.getUsername();
            String shipping = request.getParameter("shipping");
            int payment = Integer.parseInt(request.getParameter("payment"));
            String address = request.getParameter("address");
            String note = request.getParameter("note");
            myCon.updateOrder(order_id, address, shipping, note, payment, username, "Processing");
            //request.getRequestDispatcher(request.getContextPath()+"/Views/Users/Successful.jsp").forward(request, response);
            response.sendRedirect(request.getContextPath() + "/User");
        } else {
            String order_status = request.getParameter("action");
            if (order_status.equals("Complete")) {
                ArrayList<OrderItem> lst = myCon.getOrderItemList(order_id);
                for(OrderItem x: lst){
                    myCon.updateItem(x.getItem().getItem_id(), x.getItem().getItem_quantity()-x.getQuantity());
                }
            }
            myCon.updateOrderStatus(order_id, order_status);
            response.sendRedirect("OrderManagement");
        }
    }
}
