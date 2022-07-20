/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.MyConnection;
import Models.Account;
import Models.Comment;
import Models.ControlPage;
import Models.Item;
import Models.UserInfo;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class ModifyCmt extends HttpServlet {

    MyConnection myCon;

    @Override
    public void init() throws ServletException {
        myCon = new MyConnection();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rawCmt_id = request.getParameter("cmt_id");
        String rawAction = request.getParameter("action");
        String rawId = request.getParameter("id");
        if (rawAction != null && rawCmt_id != null && rawId != null) {
            int action = Integer.parseInt(rawAction);
            int cmt_id = Integer.parseInt(rawCmt_id);
            int id = Integer.parseInt(rawId);
            if (action == 0) {
                Comment cmt = myCon.getComment(cmt_id);
                Item item = myCon.loadItem(id);
                ArrayList<Comment> cmt_list = myCon.loadComment(id);
                request.setAttribute("cmt_list", cmt_list);
                request.setAttribute("item", item);
                request.setAttribute("cmt_content", cmt.getComment_content());
                request.getRequestDispatcher("./Views/ItemDetail.jsp").forward(request, response);
                //response.sendRedirect("ItemDetail?id=" + item_id);
            } else if (action == 1) {
                myCon.deleteComment(cmt_id);
                response.sendRedirect("ItemDetail?id=" + id);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        int item_id = Integer.parseInt(request.getParameter("item_id"));
        String rawCmt_id = request.getParameter("cmt_id");
        String cmt_content = request.getParameter("content");

        if (rawCmt_id != null && rawCmt_id.trim().length() > 0) {
            //String cmt_content = request.getParameter("content");
            int cmt_id = Integer.parseInt(rawCmt_id);
            if (action.equals("insert")) {
                myCon.updateComment(cmt_id, cmt_content);
            }
            if (action.equals("update")) {
                ArrayList<Comment> cmt_list = myCon.loadComment(item_id);
                Item item = myCon.loadItem(item_id);

                int nrpp = 2; //update later
                HttpSession ses = request.getSession();
                if (ses.getAttribute("nrppCmt") == null) {
                    ses.setAttribute("nrppCmt", nrpp);
                }
                nrpp = Integer.parseInt(ses.getAttribute("nrppItem") + "");
                int size = cmt_list.size();
                int cp = 0;
                ControlPage controlPage = new ControlPage(nrpp, cp, size);
                controlPage.calc();

                request.setAttribute("CP", controlPage);
                request.setAttribute("updatedCmt_id", cmt_id);
                request.setAttribute("updatedCmt_content", cmt_content);
                request.setAttribute("cmt_list", cmt_list);
                request.setAttribute("item", item);
                request.getRequestDispatcher("./Views/ItemDetail.jsp").forward(request, response);
            }
            if (action.equals("delete")) {
                myCon.deleteComment(cmt_id);
            }
        } else if (action.equals("insert") && cmt_content.trim().length() > 0) {
            Date date = Date.valueOf(LocalDate.now());
            Time time = Time.valueOf(LocalTime.now());
            String username = ((Account) request.getSession().getAttribute("acc")).getUsername();
            myCon.insertComment(cmt_content, date, time, username, item_id);
        }
        response.sendRedirect("ItemDetail?id=" + item_id);
    }
}
