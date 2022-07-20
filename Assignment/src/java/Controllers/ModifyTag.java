/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.DBContext;
import DAO.MyConnection;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author ADMIN
 */
public class ModifyTag extends HttpServlet {

    Connection con;
    MyConnection myCon;

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

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tag_name = request.getParameter("tag_name");
        insertItem(tag_name);
        response.sendRedirect("LoadItems");
    }

    protected void insertItem(String tag_name) {
        String sql = "INSERT INTO Tag_HE163048 \n"
                + " VALUES (?);";
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, tag_name);

            ps.execute();
        } catch (Exception e) {
        }
    }

    protected void deleteItem(String tag_id) {
        String sql = "DELETE FROM Tag_HE163048 WHERE tag_id = ?;";
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, tag_id);

            ps.execute();
        } catch (Exception e) {
        }
    }
}
