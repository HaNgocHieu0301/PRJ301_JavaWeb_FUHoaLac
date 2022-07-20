/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.DBContext;
import DAO.MyConnection;
import Models.Account;
import Models.Item;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.sql.*;
import java.util.HashMap;

/**
 *
 * @author ADMIN
 */
@MultipartConfig(
        location = "E:\\FPT_LearningCurriculum\\Coding\\Netbeans\\testuploadimgage\\web\\Views\\Images\\foods",
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1073741824,
        maxRequestSize = 1024 * 1024 * 11
)
public class ModifyItem extends HttpServlet {

    Connection con;
    boolean update = false;
    MyConnection myCon;
    String mess = "";

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            String type = request.getParameter("type");
            HashMap<Integer, String> tag_list = myCon.getTag();
            request.setAttribute("tag_list", tag_list);
            if (type != null) {
                int item_id = Integer.parseInt(request.getParameter("item_id"));
                if (type.equals("0")) {
                    update = true;
                    request.setAttribute("isUpdate", update);
                    Item item = myCon.loadItem(item_id);
                    //request.setAttribute("updatedItem_id", item_id);
                    request.setAttribute("updatedItem", item);
                    request.getRequestDispatcher("./Views/Shops/Edit-product.jsp").forward(request, response);
                } else if (type.equals("1")) {
                    deleteItem(item_id);
                    response.sendRedirect("LoadItems");
                }
            } else {
                mess = "";
                update = false;
                request.setAttribute("isUpdate", update);
                request.getRequestDispatcher("./Views/Shops/Edit-product.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String item_name = request.getParameter("item_name");
            float item_price = Float.parseFloat(request.getParameter("item_price"));
            int item_quantity = Integer.parseInt(request.getParameter("item_quantity"));
            String item_description = request.getParameter("item_description");
            int tag_id = Integer.parseInt(request.getParameter("tag_id"));
            String rawDiscount = request.getParameter("discount");
            int discount = 0;
            if (rawDiscount != null && rawDiscount.trim().length() > 0) {
                discount = Integer.parseInt(rawDiscount);
            }
            //String username = request.getParameter("username");
            String username = ((Account) request.getSession().getAttribute("acc")).getUsername();
            String img_product = request.getParameter("img-product");

            if (!update) {
                myCon.insertItem(item_name, item_price, img_product, item_quantity, item_description, tag_id, discount, username);
            } else {
                String updatedItem_id = request.getParameter("updatedItem_id");
                int old_item_id = Integer.parseInt(updatedItem_id);
                myCon.updateItem(old_item_id, item_name, item_price, img_product, item_quantity, item_description, tag_id, discount, username);
            }
        } catch (Exception e) {
            mess = "Information is invalid.";
        }
        response.sendRedirect("LoadItems");
    }

    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        if (!contentDisposition.contains("filename=")) {
            return null;
        }
        int beginIndex = contentDisposition.indexOf("filename=") + 10;
        int endIndex = contentDisposition.length() - 1;

        return contentDisposition.substring(beginIndex, endIndex);
    }

    protected void deleteItem(int item_id) {
        String sql = "DELETE FROM Item_HE163048 WHERE item_id = ?;";
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, item_id);
            ps.execute();
            mess = "Delete successful";
        } catch (Exception e) {
            mess = "Delete failed. Error: " + e.getMessage();
        }
    }

    public static void main(String[] args) throws ServletException {
        ModifyItem m = new ModifyItem();
        //String sqlt = "INSERT INTO Item \n"
        //        + "VALUES ('hieuhn1111',50000,50,'menu-image6.jpg','hieuhn',1,20,'hieuhn0301')";
        //PreparedStatement ps = con.prepareStatement(sqlt);
        //ps.execute();
        m.init();
        //m.insertItem("xxxx", 5000, "menu-image4.jpg", 20, "xxxxx", 1, 5, "hieuhn0301");
    }
}
