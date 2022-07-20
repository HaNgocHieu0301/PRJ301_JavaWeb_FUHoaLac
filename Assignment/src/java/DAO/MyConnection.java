package DAO;

import Models.*;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author ADMIN
 */
public class MyConnection {
    
    Connection con;
    HttpServletResponse res;
    
    public MyConnection() {
        try {
            con = new DBContext().getConnection();
        } catch (Exception e) {
            
        }
    }
    
    public void updateStatusAccount(int status, String username) {
        String sql = "Update Account_HE163048 SET [status] = ? WHERE [username] =?";
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, status);
            ps.setString(2, username);
            ps.execute();
        } catch (Exception e) {
        }
    }
    
    public void updateItem(int updatedItem, String item_name, float item_price, String item_img, int item_quantity, String item_description, int tag_id, int discount, String username) {
        String sql = "UPDATE Item_HE163048 \n"
                + "SET item_name=?, item_price=?, item_img=?, item_quantity=?, item_description=?, tag_id=?, discount=? \n"
                + "WHERE item_id = ?";
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, item_name);
            ps.setFloat(2, item_price);
            ps.setString(3, item_img);
            ps.setInt(4, item_quantity);
            ps.setString(5, item_description);
            ps.setInt(6, tag_id);
            ps.setInt(7, discount);
            ps.setInt(8, updatedItem);
            
            ps.execute();
        } catch (Exception e) {
        }
    }
    
    public void updateItem(int updatedItem, int item_quantity) {
        String sql = "UPDATE Item_HE163048 \n"
                + "SET item_quantity=?\n"
                + "WHERE item_id = ?";
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, item_quantity);
            ps.setInt(2, updatedItem);
            
            ps.execute();
        } catch (Exception e) {
        }
    }
    
    public void insertItem(String item_name, float item_price, String item_img, int item_quantity, String item_description, int tag_id, int discount, String username) {
        String sql = "INSERT INTO Item_HE163048 VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareCall(sql);
            
            ps.setString(1, item_name);
            ps.setFloat(2, item_price);
            ps.setInt(3, item_quantity);
            ps.setString(4, item_img);
            ps.setString(5, item_description);
            ps.setInt(6, tag_id);
            ps.setInt(7, discount);
            ps.setString(8, username);
            
            ps.execute();
        } catch (Exception e) {
        }
    }
    
    public ArrayList<Item> getItem() {
            String sql = "SELECT item_id, item_name, item_price, item_quantity, item_img, item_description, Tag_HE163048.tag_name, discount, username\n"
                    + "FROM Item_HE163048, Tag_HE163048\n"
                    + "WHERE Item_HE163048.tag_id = Tag_HE163048.tag_id";
        ArrayList<Item> item_list = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int item_id = rs.getInt("item_id");
                String item_name = rs.getString("item_name");
                float item_price = rs.getFloat("item_price");
                int item_quantity = rs.getInt("item_quantity");
                String item_img = rs.getString("item_img");
                String item_description = rs.getString("item_description");
                String tag_name = rs.getString("tag_name");
                int discount = rs.getInt("discount");
                String username = rs.getString("username");
                item_list.add(new Item(item_id, item_name, item_price, item_quantity, item_description, tag_name, discount, username, item_img));
            }
            return item_list;
        } catch (Exception e) {
        }
        return null;
    }
    
    public ArrayList<Item> getItem(String username) {
        String sql = "SELECT item_id, item_name, item_price, item_quantity, item_img, item_description, Tag_HE163048.tag_name, discount, username\n"
                + "FROM Item_HE163048, Tag_HE163048\n"
                + "WHERE Item_HE163048.tag_id = Tag_HE163048.tag_id\n"
                + "AND Item_HE163048.username = ?";
        ArrayList<Item> item_list = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int item_id = rs.getInt("item_id");
                String item_name = rs.getString("item_name");
                float item_price = rs.getFloat("item_price");
                int item_quantity = rs.getInt("item_quantity");
                String item_img = rs.getString("item_img");
                String item_description = rs.getString("item_description");
                String tag_name = rs.getString("tag_name");
                int discount = rs.getInt("discount");
                item_list.add(new Item(item_id, item_name, item_price, item_quantity, item_description, tag_name, discount, username, item_img));
            }
            return item_list;
        } catch (Exception e) {
        }
        return null;
    }
    
    public Item loadItem(int item_id) {
        String sql = "select item_id, item_name, item_price, item_quantity, item_img, item_description, Tag_HE163048.tag_name, discount, username\n"
                + "from Item_HE163048, Tag_HE163048\n"
                + "Where Item_HE163048.tag_id = Tag_HE163048.tag_id\n"
                + "AND item_id = ?";
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, item_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("item_id");
                String item_name = rs.getString("item_name");
                float item_price = rs.getFloat("item_price");
                int item_quantity = rs.getInt("item_quantity");
                String item_img = rs.getString("item_img");
                String item_description = rs.getString("item_description");
                String tag_name = rs.getString("tag_name");
                int discount = rs.getInt("discount");
                String username = rs.getString("username");
                return new Item(id, item_name, item_price, item_quantity, item_description, tag_name, discount, username, item_img);
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public ArrayList<Comment> loadComment(int item_id) {
        String sql = "Select c.comment_id, c.comment_time, c.comment_date, c.comment_content, c.item_id, ui.userinfo_id\n"
                + "FROM Comment_HE163048 c, UserInfo_HE163048 ui, Account_HE163048 a\n"
                + "WHERE item_id = ? \n"
                + "AND c.username = a.username\n"
                + "AND a.userinfo_id = ui.userinfo_id\n"
                + "ORDER BY comment_date DESC,comment_time DESC;";
        ArrayList<Comment> cmt_list = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, item_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int comment_id = rs.getInt("comment_id");
                String comment_date = rs.getDate(("comment_date")).toString();
                String comment_time = rs.getTime(("comment_time")).toString();
                String comment_content = rs.getString("comment_content");
                int userinfo_id = rs.getInt("userinfo_id");
                UserInfo userinfo = getUserInfo(userinfo_id);
                cmt_list.add(new Comment(comment_id, comment_time, comment_date, comment_content, userinfo, item_id));
            }
            return cmt_list;
        } catch (Exception e) {
        }
        return null;
    }
    
    public void insertComment(String cmt_content, Date date, Time time, String username, int item_id) {
        String sql = "INSERT INTO Comment_HE163048 \n"
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setTime(1, time);
            ps.setDate(2, date);
            ps.setString(3, cmt_content);
            ps.setString(4, username);
            ps.setInt(5, item_id);
            ps.execute();
        } catch (Exception e) {
        }
    }
    
    public Comment getComment(int cmt_id) {
        String sql = "Select c.comment_id, c.comment_time, c.comment_date, c.comment_content, c.item_id, ui.userinfo_id\n"
                + "FROM Comment_HE163048 c, UserInfo_HE163048 ui, Account a\n"
                + "WHERE c.comment_id = ? \n"
                + "AND c.username = a.username\n"
                + "AND a.userinfo_id = ui.userinfo_id";
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, cmt_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String comment_date = rs.getDate(("comment_date")).toString();
                String comment_time = rs.getTime(("comment_time")).toString();
                String comment_content = rs.getString("comment_content");
                int item_id = rs.getInt("item_id");
                int userinfo_id = rs.getInt("userinfo_id");
                UserInfo userinfo = getUserInfo(userinfo_id);
                return new Comment(cmt_id, comment_time, comment_date, comment_content, userinfo, item_id);
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public void deleteComment(int cmt_id) {
        String sql = "DELETE FROM Comment_HE163048 WHERE comment_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cmt_id);
            ps.execute();
        } catch (Exception e) {
        }
    }
    
    public void updateComment(int cmt_id, String newContent) {
        String sql = "UPDATE Comment_HE163048 SET comment_content =?  WHERE comment_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, newContent);
            ps.setInt(2, cmt_id);
            ps.execute();
        } catch (Exception e) {
        }
    }
    
    public HashMap<Integer, String> getTag() {
        String sql = "select * from Tag_HE163048";
        HashMap<Integer, String> tag_list = new HashMap<>();
        //ArrayList<Tag> tag_list = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //tag_list.add(new Tag(rs.getInt(1), rs.getString(2)));
                tag_list.put(rs.getInt(1), rs.getString(2));
            }
            return tag_list;
        } catch (Exception e) {
        }
        return null;
    }
    
    public Post getPost(int post_id, String username) {
        String sql = "SELECT p.post_id, p.post_img, p.post_content, pa.post_date, pa.post_time, pa.username \n"
                + "FROM Post_HE163048 p, Post_Acc_HE163048 pa\n"
                + "WHERE pa.post_id = ?\n"
                + "AND pa.username = ?\n"
                + "AND p.post_id = pa.post_id ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, post_id);
            ps.setString(2, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String post_img = rs.getString("post_img");
                String post_content = rs.getString("post_content");
                String post_date = rs.getDate("post_date").toString();
                String post_time = rs.getTime("post_time").toString();
                return new Post(post_id, post_img, post_content, post_date, post_time, username);
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public void updatePost(int post_id, String img, String content) {
        String sql = "UPDATE Post_HE163048 \n"
                + "SET post_img = ?, post_content = ? \n"
                + "WHERE post_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, img);
            ps.setString(2, content);
            ps.setInt(3, post_id);
            ps.execute();
        } catch (Exception e) {
        }
    }
    
    public Tag loadTag(int tag_id) {
        String sql = "Select * FROM Tag_HE163048 WHERE tag_id = ?;";
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, tag_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tag_name = rs.getString("tag_name");
                return new Tag(tag_id, tag_name);
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public UserInfo getUserInfo(int userinfo_id) {
        String sql = "SELECT * FROM UserInfo_HE163048 WHERE [userinfo_id] = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userinfo_id);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String dob = rs.getDate("dob").toString();
                String avatar = rs.getString("avatar");
                String studentID = rs.getString("studentID");
                String phoneNumber = rs.getString("phoneNumber");
                String address = rs.getString("address");
                String job = rs.getString("job");
                String citizenID = rs.getString("citizenID");
                
                return new UserInfo(userinfo_id, name, gender, dob, avatar, studentID, phoneNumber, address, job, citizenID);
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public UserInfo getUserInfo(String username) {
        String sql = "SELECT * \n"
                + "FROM [UserInfo_HE163048] ui, Account_HE163048 a\n"
                + "WHERE a.userinfo_id = ui.userinfo_id\n"
                + "AND a.username = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int userinfo_id = rs.getInt("userinfo_id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String dob = rs.getDate("dob").toString();
                String avatar = rs.getString("avatar");
                String studentID = rs.getString("studentID");
                String phoneNumber = rs.getString("phoneNumber");
                String address = rs.getString("address");
                String job = rs.getString("job");
                String citizenID = rs.getString("citizenID");
                
                return new UserInfo(userinfo_id, name, gender, dob, avatar, studentID, phoneNumber, address, job, citizenID);
            }
        } catch (Exception e) {
        }
        return null;
    }

    //lay ra cac order
    public Order getOrder(String username, String shopName, String order_status) {
        String sql = "SELECT * FROM [Order_HE163048] WHERE [username] = ?  AND  [order_status]  =  ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, order_status);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int order_id = rs.getInt("order_id");
                String delivery_address = rs.getString("delivery_address");
                String delivery_transport = rs.getString("delivery_transport");
                String order_note = rs.getString("delivery_note");
                int payment_id = rs.getInt("payment_id");
                
                return new Order(order_id, delivery_address, delivery_transport, order_note, payment_id, username, order_status);
            }
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * @para: order_id
     * @return a Order object
     * @purpose: get Order object from order_id
     */
    public Order getOrder(int order_id) {
        String sql = "SELECT * FROM [Order_HE163048] WHERE [order_id] = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, order_id);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                String delivery_address = rs.getString("delivery_address");
                String delivery_transport = rs.getString("delivery_transport");
                String order_note = rs.getString("delivery_note");
                int payment_id = rs.getInt("payment_id");
                String username = rs.getString("username");
                String order_status = rs.getString("order_status");;
                return new Order(order_id, delivery_address, delivery_transport, order_note, payment_id, username, order_status);
            }
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * @param: username
     * @return: a ArrayList of OrderItem lay ra cac orderitem trong order co
     * trang thai la x
     */
    public ArrayList<OrderItem> getOrderList(String username, String order_status) {
        String sql = "select oi.order_id, oi.item_id, oi.quantity\n"
                + "from [Order_HE163048] o, Order_Item oi\n"
                + "where o.order_status = ?\n"
                + "and o.username = ?\n"
                + "and oi.order_id = o.order_id";
        ArrayList<OrderItem> orderList = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(2, username);
            ps.setString(1, order_status);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int order_id = rs.getInt("order_id");
                int item_id = rs.getInt("item_id");
                int quantity = rs.getInt("quantity");
                Order order = getOrder(order_id);
                Item item = loadItem(item_id);
                orderList.add(new OrderItem(order, quantity, item));
            }
        } catch (Exception e) {
        }
        return orderList;
    }
    
    public ArrayList<OrderItem> getOrderListForAdmin() {
        String sql = "SELECT oi.order_id, oi.item_id, oi.quantity\n"
                + "FROM Item_HE163048 i , Order_Item_HE163048 oi, [Order_HE163048] o\n"
                + "WHERE \n"
                + "i.item_id = oi.item_id\n"
                + "AND o.order_id = oi.order_id\n"
                + "ORDER BY oi.order_id DESC";
        ArrayList<OrderItem> orderList = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int order_id = rs.getInt("order_id");
                int item_id = rs.getInt("item_id");
                int quantity = rs.getInt("quantity");
                Order order = getOrder(order_id);
                Item item = loadItem(item_id);
                orderList.add(new OrderItem(order, quantity, item));
            }
        } catch (Exception e) {
        }
        return orderList;
    }

    //lay ra cac order cua mot nguoi ban 
    public ArrayList<OrderItem> getOrderListForShop(String username) {
        String sql = "SELECT oi.order_id, oi.item_id, oi.quantity\n"
                + "FROM Item_HE163048 i , Order_Item_HE163048 oi, [Order_HE163048] o\n"
                + "WHERE i.username = ?\n"
                + "AND i.item_id = oi.item_id\n"
                + "AND o.order_id = oi.order_id\n"
                + "ORDER BY oi.order_id DESC";
        ArrayList<OrderItem> orderList = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int order_id = rs.getInt("order_id");
                int item_id = rs.getInt("item_id");
                int quantity = rs.getInt("quantity");
                Order order = getOrder(order_id);
                Item item = loadItem(item_id);
                orderList.add(new OrderItem(order, quantity, item));
            }
        } catch (Exception e) {
        }
        return orderList;
    }
    
    public ArrayList<OrderItem> getOrderListForUser(String username) {
        String sql = "SELECT oi.order_id, oi.item_id, oi.quantity\n"
                + "FROM Item_HE163048 i , Order_Item_HE163048 oi, [Order_HE163048] o\n"
                + "WHERE o.username = ?\n"
                + "AND i.item_id = oi.item_id\n"
                + "AND o.order_id = oi.order_id\n"
                + "ORDER BY oi.order_id DESC";
        ArrayList<OrderItem> orderList = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int order_id = rs.getInt("order_id");
                int item_id = rs.getInt("item_id");
                int quantity = rs.getInt("quantity");
                Order order = getOrder(order_id);
                Item item = loadItem(item_id);
                orderList.add(new OrderItem(order, quantity, item));
            }
        } catch (Exception e) {
        }
        return orderList;
    }
    
    public int insertOrder(String delivery_address, String delivery_transport, String note, int payment_id, String username, String order_status) {
        String sql = "INSERT INTO [Order_HE163048]\n"
                + "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, delivery_address);
            ps.setString(2, delivery_transport);
            ps.setString(3, note);
            ps.setInt(4, payment_id);
            ps.setString(5, username);
            ps.setString(6, order_status);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return -1;
    }
    
    public void updateOrder(int order_id, String delivery_address, String delivery_transport, String note, int payment_id, String username, String order_status) {
        String sql = "UPDATE [Order_HE163048]\n"
                + "SET delivery_address = ?, delivery_transport = ?, delivery_note = ?, payment_id = ?, username = ?, order_status = ?\n"
                + "WHERE order_id = ?";
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, delivery_address);
            ps.setString(2, delivery_transport);
            ps.setString(3, note);
            ps.setInt(4, payment_id);
            ps.setString(5, username);
            ps.setString(6, order_status);
            ps.setInt(7, order_id);
            
            ps.execute();
        } catch (Exception e) {
        }
    }
    
    public void updateOrderStatus(int order_id, String order_status) {
        String sql = "UPDATE [Order_HE163048]\n"
                + "SET order_status = ?\n"
                + "WHERE order_id = ?";
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, order_status);
            ps.setInt(2, order_id);
            
            ps.execute();
        } catch (Exception e) {
        }
    }
    
    public void deleteOrder(int order_id) {
        String sql = "DELETE FROM [Order_HE163048] WHERE  [Order_HE163048].order_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, order_id);
            ps.execute();
        } catch (Exception e) {
        }
    }

    /**
     * them mot san pham moi vao order
     */
    public void insertOrderItem(int item_id, int quantity, int order_id) {
        String sql = "INSERT INTO Order_Item_HE163048\n"
                + "VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, quantity);
            ps.setInt(2, order_id);
            ps.setInt(3, item_id);
            ps.execute();
        } catch (Exception e) {
        }
    }
    
    public void deleteOrderItem(int item_id, int order_id) {
        String sql = "DELETE FROM Order_Item_HE163048 \n"
                + "WHERE order_id = ? \n"
                + "AND item_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, order_id);
            ps.setInt(2, item_id);
            ps.execute();
        } catch (Exception e) {
        }
    }
    
    public void updateOrderItem(int item_id, int quantity, int order_id) {
        String sql = "UPDATE Order_Item_HE163048\n"
                + "SET quantity = ?\n"
                + "WHERE order_id = ? AND item_id = ?";
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, quantity);
            ps.setInt(2, order_id);
            ps.setInt(3, item_id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<OrderItem> getOrderItemList(int order_id) {
        String sql = "SELECT oi.order_id, oi.item_id, oi.quantity\n"
                + "FROM Order_Item_HE163048 oi, [Order_HE163048] o\n"
                + "where o.order_id = ?\n"
                + "and oi.order_id = o.order_id";
        ArrayList<OrderItem> orderList = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, order_id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int item_id = rs.getInt("item_id");
                int quantity = rs.getInt("quantity");
                Order order = getOrder(order_id);
                Item item = loadItem(item_id);
                orderList.add(new OrderItem(order, quantity, item));
            }
        } catch (Exception e) {
        }
        return orderList;
    }
    
    public ArrayList<PaymentSeller> getPaymentList(String shopName) {
        String sql = "SELECT sp.payment_id, payment_note, payment_name\n"
                + "FROM Seller_Payment_HE163048 sp, Payment_HE163048 p\n"
                + "WHERE sp.payment_id = p.payment_id\n"
                + "AND sp.username = ?";
        ArrayList<PaymentSeller> paymentList = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, shopName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int payment_id = rs.getInt("payment_id");
                String payment_name = rs.getString("payment_name");
                String payment_note = rs.getString("payment_note");
                paymentList.add(new PaymentSeller(payment_id, payment_name, payment_note, shopName));
            }
            return paymentList;
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * lay ra Account tu tham so username truyen vao
     */
    public Account getAccountByUsername(String username) {
        String sql = "SELECT * FROM Account_HE163048 where username = ?";
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String password = rs.getString("password");
                int userinfo_id = rs.getInt("userinfo_id");
                int type_id = rs.getInt("type_id");
                boolean status = rs.getBoolean("status");
                String email = rs.getString("email");
                return new Account(username, password, email, type_id, userinfo_id, status);
            }
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * lay ra Account tu tham so email truyen vao
     */
    public Account getAccountByEmail(String email) {
        String sql = "SELECT * FROM Account_HE163048 WHERE email = ?";
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                int userinfo_id = rs.getInt("userinfo_id");
                int type_id = rs.getInt("type_id");
                boolean status = rs.getBoolean("status");
                return new Account(username, password, email, type_id, userinfo_id, status);
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public boolean checkPassword(String username, String oldPassword) {
        String sql = "SELECT *  \n"
                + "FROM Account_HE163048 \n"
                + "WHERE [username] =? AND [password] = ?";
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, username);
            ps.setString(2, oldPassword);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            
        }
        return false;
    }
    
    public void changePassword(String username, String newPassword) {
        String sql = "Update Account_HE163048 SET [password] = ? WHERE [username] =?";
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setString(1, newPassword);
            ps.setString(2, username);
            ps.execute();
        } catch (Exception e) {
            
        }
    }
    
    public static void main(String[] args) {
        MyConnection myCon = new MyConnection();
        System.out.println(myCon.getItem("duongtt").size());
        //System.out.println(myCon.getPost(1, "hieuhn0301").getPost_content());
        //myCon.updateComment(2, "test update");
        //myCon.updatePaymentSeller(1, "doanhien", "test update");
//        ArrayList<PaymentSeller> lst = myCon.getPaymentSellerList("hieuhn0301");
//        for(PaymentSeller x: lst){
//            System.out.println(x.getPayment_name());
//        }
        myCon.insertItem("salad", 50000, "xx", 30, "xx", 1, 0, "hieuhn0301");
    }
    
    public Account getAccount(String username) {
        String sql = "SELECT * FROM Account_HE163048 WHERE username = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String email = rs.getString("email");
                String password = rs.getString("password");
                int type_id = rs.getInt("type_id");
                boolean status = rs.getBoolean("status");
                int userinfo_id = rs.getInt("userinfo_id");
                return new Account(username, "", email, type_id, userinfo_id, status);
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public ArrayList<PaymentSeller> getPaymentSellerList(String username) {
        String sql = "SELECT p.payment_id, sp.username, p.payment_name, sp.payment_note\n"
                + "FROM Payment_HE163048 p, Seller_Payment_HE163048 sp\n"
                + "WHERE p.payment_id = sp.payment_id\n"
                + "AND sp.username = ?";
        ArrayList<PaymentSeller> lst = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int payment_id = rs.getInt("payment_id");
                String payment_name = rs.getString("payment_name");
                String payment_note = rs.getString("payment_note");
                lst.add(new PaymentSeller(payment_id, payment_name, payment_note, username));
            }
            return lst;
        } catch (Exception e) {
        }
        return null;
    }
    
    public void updatePaymentSeller(int payment_id, String username, String payment_note) {
        String sql = "UPDATE Seller_Payment_HE163048 SET payment_note = ? where payment_id = ? AND username = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, payment_note);
            ps.setInt(2, payment_id);
            ps.setString(3, username);
            ps.execute();
        } catch (Exception e) {
        }
    }
    
    public void insertCredit(String username, int i, String string) {
        String sql = "INSERT INTO Seller_Payment_HE163048 \n"
                + "VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setInt(i, 2);
            ps.setString(3, string);
            ps.execute();
        } catch (Exception e) {
        }
    }
}
