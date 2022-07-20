/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.MyConnection;
import Models.ControlPage;
import Models.Discount;
import Models.Item;
import Models.Tag;
import java.io.IOException;
import java.io.PrintWriter;
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
public class User extends HttpServlet {

    MyConnection myCon;
    ArrayList<Item> item_list;
    ArrayList<Discount> discount_list;
    HashMap<Integer, String> tag_list;

    @Override
    public void init() throws ServletException {
        myCon = new MyConnection();
//        item_list = myCon.getItem();
//        tag_list = myCon.getTag();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String search = request.getParameter("search");
        String type = request.getParameter("type");
        item_list = myCon.getItem();
        if (search != null && search.trim().length() > 0) {
            item_list = searchByName(item_list, search);
        }

        int nrpp = 2; //update later
        HttpSession ses = request.getSession();
        if (type != null && type.trim().length() > 0) {
            item_list = filterItem(item_list, type);
        }
        if (ses.getAttribute("nrppItem") == null) {
            ses.setAttribute("nrppItem", nrpp);
        }
        nrpp = Integer.parseInt(ses.getAttribute("nrppItem") + "");
        int size = item_list.size();
        int cp = 0;
        ControlPage controlPage = new ControlPage(nrpp, cp, size);
        controlPage.calc();
        request.setAttribute("CP", controlPage);
        request.setAttribute("item_list", item_list);
        request.setAttribute("tag_list", tag_list);
        request.setAttribute("discount_list", discount_list);
        request.getRequestDispatcher("./Views/Users/UserHome.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        item_list = myCon.getItem();
        int nrpp = 2;
        if (request.getParameter("nrppItem") != null) {
            try {
                nrpp = Integer.parseInt(request.getParameter("nrpp"));
                nrpp = (nrpp) < 1 ? 1 : nrpp;
            } catch (Exception e) {
            }
        }
        HttpSession ses = request.getSession();
        ses.setAttribute("nrppItem", nrpp);
        String tmp = request.getParameter("cp");
        int cp = Integer.parseInt(tmp);
        if (request.getParameter("home") != null) {
            cp = 0;
        }
        if (request.getParameter("pre") != null) {
            cp = cp - 1;
        }
        if (request.getParameter("next") != null) {
            cp = cp + 1;
        }
        ControlPage controlPage = new ControlPage(nrpp, cp, item_list.size());
        controlPage.calc();
        if (request.getParameter("end") != null) {
            cp = controlPage.getTp() - 1;
        }
        for (int i = 0; i < controlPage.getTp(); i++) {
            if (request.getParameter("btn" + i) != null) {
                cp = i;
            }
        }
        controlPage.setCp(cp);
        controlPage.calc();
        request.setAttribute("item_list", item_list);
        request.setAttribute("tag_list", tag_list);
        request.setAttribute("discount_list", discount_list);
        request.setAttribute("CP", controlPage);
        request.getRequestDispatcher("./Views/Users/UserHome.jsp").forward(request, response);
    }

    public ArrayList<Item> filterItem(ArrayList<Item> list, String type) {
        ArrayList<Item> items_lst = new ArrayList<>();
        for (Item x : list) {
            if (x.getTag_name().equals(type)) {
                items_lst.add(x);
            }
        }
        return items_lst;
    }

    public ArrayList<Item> searchByName(ArrayList<Item> list, String text) {
        ArrayList<Item> items_lst = new ArrayList<>();
        for (Item item : list) {
            if (item.getItem_description().toLowerCase().contains(text.toLowerCase())) {
                items_lst.add(item);
            }
        }
        return items_lst;
    }
    
}
