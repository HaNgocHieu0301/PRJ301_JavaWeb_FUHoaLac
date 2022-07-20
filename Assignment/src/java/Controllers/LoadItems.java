/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.DBContext;
import DAO.MyConnection;
import Models.Account;
import Models.Item;
import Models.PaymentSeller;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ADMIN
 */
public class LoadItems extends HttpServlet {

    MyConnection myCon;
    Connection con;

    @Override
    public void init() throws ServletException {
        myCon = new MyConnection();
        try {
            con = new DBContext().getConnection();
        } catch (Exception e) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Account acc = (Account) request.getSession().getAttribute("acc");
        String username = acc.getUsername();
        HashMap<Integer, String> tag_list = myCon.getTag();
        ArrayList<PaymentSeller> paymentList = myCon.getPaymentSellerList(username);
        ArrayList<Item> item_list;
        if (acc.getType_id() == 0) {
            item_list = myCon.getItem();
        } else {
            item_list = myCon.getItem(username);
        }
        request.setAttribute("item_list", item_list);
        request.setAttribute("paymentList", paymentList);
        request.getRequestDispatcher("./Views/Shops/Product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
