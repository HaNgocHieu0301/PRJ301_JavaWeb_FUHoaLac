/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.MyConnection;
import Models.Account;
import Models.Order;
import Models.OrderItem;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ADMIN
 */
public class OrderManagement extends HttpServlet {

    MyConnection myCon;

    @Override
    public void init() throws ServletException {
        myCon = new MyConnection();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Account acc = (Account) request.getSession().getAttribute("acc");
        ArrayList<OrderItem> order_list = null;
        //ArrayList<Order> oList = myCon.getOrderList(username);
        if (acc.getType_id() == 1) {
            order_list = myCon.getOrderListForShop(acc.getUsername());
        } else if (acc.getType_id() == 0) {
            order_list = myCon.getOrderListForAdmin();
        } else if (acc.getType_id() == 2) {
            order_list = myCon.getOrderListForUser(acc.getUsername());
            if (!order_list.isEmpty()) {
                for (int i = 0; i < order_list.size(); i++) {
                    if (order_list.get(i).getOrder().getOrder_status().equals("wait")) {
                        order_list.remove(i);
                        i--;
                    }
                }
            }
        }
        HashMap<Integer, ArrayList<OrderItem>> orderitemHM = new HashMap<>();
        float total = 0;
        Set<Integer> complete = new HashSet<>();
        Set<Integer> cancel = new HashSet<>();
        if (!order_list.isEmpty()) {
            for (OrderItem x : order_list) {
                total += x.realPrice();
                if (x.getOrder().getOrder_status().equals("Complete")) {
                    complete.add(x.getOrder().getOrder_id());
                }
                if (x.getOrder().getOrder_status().equals("Cancel")) {
                    complete.add(x.getOrder().getOrder_id());
                }
                int order_id = x.getOrder().getOrder_id();
                if (orderitemHM.containsKey(order_id)) {
                    orderitemHM.get(order_id).add(x);
                } else {
                    ArrayList<OrderItem> arr = new ArrayList<>();
                    arr.add(x);
                    orderitemHM.put(order_id, arr);
                }
            }
        }
        request.setAttribute("orderitemHM", orderitemHM);
        if (acc.getType_id() == 1 || acc.getType_id() == 0) {
            request.setAttribute("Complete", complete.size());
            request.setAttribute("Cancel", cancel.size());
            request.setAttribute("All", orderitemHM.keySet().size());
            request.setAttribute("totalAll", total);
            request.getRequestDispatcher("./Views/Shops/Dashboard.jsp").forward(request, response);
        } else if (acc.getType_id() == 2) {
            request.getRequestDispatcher("/Views/Users/UserOrdersManagement.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
