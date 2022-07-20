/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.DBContext;
import DAO.MyConnection;
import Models.Account;
import Models.Item;
import Models.Order;
import Models.OrderItem;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.util.*;

/**
 *
 * @author ADMIN
 */
public class Cart extends HttpServlet {

    MyConnection myCon;
    Connection con;

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
        String mess = "";
        String username = ((Account) request.getSession().getAttribute("acc")).getUsername();
        ArrayList<OrderItem> order_list = myCon.getOrderList(username, "wait");
        HashMap<String, ArrayList<OrderItem>> cart = new HashMap<>();
        String rawItemID = request.getParameter("item_id");
        String rawOrderID = request.getParameter("order_id");
        String rawQty = request.getParameter("qty");
        String rawAction = request.getParameter("action");
        if (rawItemID != null) {
            int item_id = Integer.parseInt(rawItemID);
            if ("del".equals(rawAction)) {
                //neu click vao nut x de xoa 1 san pham khoi gio hang thi xoa no
                //khoi db
                int order_id = Integer.parseInt(rawOrderID);
                myCon.deleteOrderItem(item_id, order_id);
                //kiem tra xem gio hang co san pham nao k, neu k thi xoa khoi db
                ArrayList<OrderItem> check_orderList = myCon.getOrderItemList(order_id);
                if (myCon.getOrderItemList(order_id).isEmpty()) {
                    myCon.deleteOrder(order_id);
                }
            } else if (rawOrderID != null && rawQty != null) {
                //update so luong san pham 
                int order_id = Integer.parseInt(rawOrderID);
                int qty = Integer.parseInt(rawQty);
                //check so luong san pham trong db
                if (qty < 0) {
                    qty = 0;
                }
                int maxQty = myCon.loadItem(item_id).getItem_quantity();
                if(qty > maxQty){
                    qty = maxQty;
                }
                myCon.updateOrderItem(item_id, qty, order_id);
            } else {
                //kiem tra xem san pham duoc them vao gio co nam trong shop hay 
                //order nao k
                Item item = myCon.loadItem(item_id);
                int checkShop = -1;
                int checkOrder = -1;
                int currentQty = -1;
                if (!order_list.isEmpty()) {
                    for (OrderItem x : order_list) {
                        if (x.getItem().getUsername().equals(item.getUsername())) {
                            checkShop = x.getOrder().getOrder_id();
                            if (x.getItem().getItem_id() == item_id) {
                                currentQty = x.getQuantity();
                                checkOrder = checkShop;
                            }
                        }
                    }
                }

                if (checkOrder != -1 && checkShop != -1) {
                    myCon.updateOrderItem(item_id, currentQty + 1, checkOrder);
                } else if (checkShop != -1) {
                    myCon.insertOrderItem(item_id, 1, checkShop);
                } else {
                    int _order_id = myCon.insertOrder("", "", "", 6, username, "wait");
                    myCon.insertOrderItem(item_id, 1, _order_id);
                }
            }
        }
        order_list = myCon.getOrderList(username, "wait");
        /**
         * Phan loai order theo ten shop de hien thi gio hang cho nguoi dung
         */
        if (!order_list.isEmpty()) {
            for (OrderItem x : order_list) {
                String shopName = x.getItem().getUsername();
                if (cart.containsKey(shopName)) {
                    cart.get(shopName).add(x);
                } else {
                    ArrayList<OrderItem> arr = new ArrayList<>();
                    arr.add(x);
                    cart.put(shopName, arr);
                }
            }
        }
//------------------------------------------------------------------------------------------------
        HttpSession session = request.getSession();
        session.setAttribute("orderItemHM", cart);
        request.getRequestDispatcher("./Views/Users/Cart.jsp").forward(request, response);
//-------------------------------------------------------------------------------------------------
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
