package Controllers;

import DAO.DBContext;
import DAO.MyConnection;
import Models.Account;
import Models.UserInfo;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ADMIN
 */
@MultipartConfig(
        location = "E:\\FPT_LearningCurriculum\\Coding\\Netbeans\\Assignment\\web\\Views\\images\\avatar",
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 11
)
public class UpdateAccount extends HttpServlet {

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
        HttpSession session = request.getSession();
        String receivedCode = request.getParameter("receivedCode");
        String verifyCode = (String) session.getAttribute("verifyCode");
        Account acc = (Account) session.getAttribute("acc");

        if (acc != null) {
            UserInfo info = myCon.getUserInfo(acc.getUserinfo_id());
            session.setAttribute("userinfo", info);
            request.getRequestDispatcher("./Views/EditAccount.jsp").forward(request, response);
        } else {
            if (!verifyCode.equals(receivedCode)) {
                request.setAttribute("message", "Code is wrong. Please enter your code again");
                request.getRequestDispatcher("./Views/VerifyAccount.jsp").forward(request, response);
            } else {
                if (session.getAttribute("forgetPassword") == null) {
                    Account newAcc = (Account) session.getAttribute("newAcc");
                    newAcc.setStatus(true);
                    myCon.updateStatusAccount(1, newAcc.getUsername());
                    request.getRequestDispatcher("./Views/Signup_Detail.jsp").forward(request, response);
                } else {
                    response.sendRedirect("/Assignment/Views/changePassword.jsp");
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fullname = request.getParameter("fullname");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String studentID = request.getParameter("studentID");
        studentID = (studentID == null) ? "" : studentID;
        String phoneNumber = request.getParameter("phone");
        String job = request.getParameter("job");
        job = (job == null) ? "" : job;
        String citizenID = request.getParameter("citizenID");
        citizenID = (citizenID == null) ? "" : citizenID;
        String address = request.getParameter("address");
        String avatar = request.getParameter("avatar");
        Account acc = (Account) request.getSession().getAttribute("acc");
        if (acc != null) {
            updateUserInfo(acc.getUserinfo_id(), fullname, gender, dob, avatar, studentID, phoneNumber, address, job, citizenID);
            if (acc.getType_id() == 2) {
                response.sendRedirect("User");
            } else {
                response.sendRedirect("LoadItems");
            }
        } else {
            int userinfo_id = insertUserInfo(fullname, gender, dob, avatar, studentID, phoneNumber, address, job, citizenID);
            Account newAcc = (Account) request.getSession().getAttribute("newAcc");
            updateUserinfoAccount(userinfo_id, newAcc.getUsername());
            String credit = request.getParameter("credit");
            String bank = request.getParameter("bank");
            myCon.insertCredit(newAcc.getUsername(), 1, credit + "-" + bank);
            myCon.insertCredit(newAcc.getUsername(), 5, "");
            response.sendRedirect("/Assignment/Views/Notice.jsp");
        }
    }

    void updateUserinfoAccount(int userinfo_id, String username) {
        String sql = "Update Account_HE163048 SET [userinfo_id] = ? WHERE [username] =?";
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, userinfo_id);
            ps.setString(2, username);
            ps.execute();
        } catch (Exception e) {
        }
    }

    private int insertUserInfo(String fullname, String gender, String dob, String avatar, String studentID, String phoneNumber, String address, String job, String citizenID) {
        String sql = "Insert INTO UserInfo_HE163048 \n"
                + "VALUES (?,?,?,?,?,?,?,?,?)\n";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, fullname);
            ps.setString(2, gender);
            ps.setString(3, dob);
            ps.setString(4, avatar);
            ps.setString(5, studentID);
            ps.setString(6, phoneNumber);
            ps.setString(7, address);
            ps.setString(8, job);
            ps.setString(9, citizenID);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return -1;
    }

    private void updateUserInfo(int userinfo_id, String fullname, String gender, String dob, String avatar, String studentID, String phoneNumber, String address, String job, String citizenID) {
        String sql = "UPDATE UserInfo_HE163048 \n"
                + "SET name = ?, gender = ?, dob = ?, avatar = ?, studentID = ?, phoneNumber = ?, address = ?, job = ?, citizenID = ?\n"
                + "WHERE userinfo_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fullname);
            ps.setString(2, gender);
            ps.setString(3, dob);
            ps.setString(4, avatar);
            ps.setString(5, studentID);
            ps.setString(6, phoneNumber);
            ps.setString(7, address);
            ps.setString(8, job);
            ps.setString(9, citizenID);
            ps.setInt(10, userinfo_id);
            ps.execute();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) throws ServletException {
        UpdateAccount up = new UpdateAccount();
        up.init();
        //System.out.println(up.insertUserInfo("yyy", "male", "2002-01-03", "y", "xxx", "09333", "ss", "student", ""));
        up.updateUserInfo(24, "Ha Ngoc Hieu", "Male", "2002-01-03", "XXX", "", "0944112306", "TH", "", "");
    }
}
