/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.DBContext;
import DAO.MyConnection;
import Models.*;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class ItemDetail extends HttpServlet {

    Connection con;
    MyConnection myCon;
    ArrayList<Comment> cmt_list;
    Item item;

    @Override

    public void init() throws ServletException {
        try {
            con = new DBContext().getConnection();
            myCon = new MyConnection();
            cmt_list = new ArrayList<>();
            item = new Item();
        } catch (Exception e) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int item_id = Integer.parseInt(request.getParameter("id"));
            item = myCon.loadItem(item_id);
            cmt_list = myCon.loadComment(item_id);

            int nrpp = 2; //update later
            HttpSession ses = request.getSession();
            if (ses.getAttribute("nrppCmt") == null) {
                ses.setAttribute("nrppCmt", nrpp);
            }
            //nrpp = Integer.parseInt(ses.getAttribute("nrppItem") + "");
            int size = cmt_list.size();
            int cp = 0;
            ControlPage controlPage = new ControlPage(nrpp, cp, size);
            controlPage.calc();

            request.setAttribute("CP", controlPage);
            request.setAttribute("cmt_list", cmt_list);
            request.setAttribute("item", item);
            request.getRequestDispatcher("./Views/ItemDetail.jsp").forward(request, response);
        } catch (Exception e) {
            String x = e.getMessage();
            response.sendRedirect("./Views/ErrorPage.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nrpp = 2;
        if (request.getParameter("nrppItem") != null) {
            try {
                nrpp = Integer.parseInt(request.getParameter("nrpp"));
                nrpp = (nrpp) < 1 ? 1 : nrpp;
            } catch (Exception e) {
            }
        }
        HttpSession ses = request.getSession();
        ses.setAttribute("nrppCmt", nrpp);
        String tmp = request.getParameter("cp");
        int cp = 0;
        if (tmp != null) {
            cp = Integer.parseInt(tmp);
        }
        if (request.getParameter("home") != null) {
            cp = 0;
        }
        if (request.getParameter("pre") != null) {
            cp = cp - 1;
        }
        if (request.getParameter("next") != null) {
            cp = cp + 1;
        }
        ControlPage controlPage = new ControlPage(nrpp, cp, cmt_list.size());
        controlPage.calc();
        if (request.getParameter("end") != null) {
            cp = controlPage.getTp() - 1;
        }
        for (int i = 0; i < controlPage.getTp(); i++) {
            if (request.getParameter("btn" + i) != null) {
                cp = i;
            }
        }
        request.setAttribute("CP", controlPage);
        controlPage.setCp(cp);
        controlPage.calc();
        request.setAttribute("cmt_list", cmt_list);
        //int item_id = item.getItem_id();
        request.setAttribute("item", item);
        request.getRequestDispatcher("./Views/ItemDetail.jsp").forward(request, response);
    }
}
