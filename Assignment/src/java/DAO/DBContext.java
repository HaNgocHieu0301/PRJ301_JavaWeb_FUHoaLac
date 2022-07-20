package DAO;


import java.sql.Connection;
import java.sql.DriverManager;


public class DBContext {
    
    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
    /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
     public Connection getConnection()throws Exception {        
        String url = "jdbc:sqlserver://"+serverName+":"+portNumber +
                ";databaseName="+dbName;//+"; integratedSecurity=true";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");         
        return DriverManager.getConnection(url, userID, password);
//        return DriverManager.getConnection(url);
    }
    //jdbc:sqlserver://localhost:8888;databaseName=PRJ301;
    /*Insert your other code right after this comment*/
   
    /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
    private final String serverName = "localhost";
    private final String dbName = "PRJ301_SE1624";
    private final String portNumber = "8888";
    private final String userID = "sa";
    private final String password = "sa123";
    
}

class Using{
    public static void main(String[] args) {
        try {
            Connection con = new DBContext().getConnection();
            System.out.println("Ket noi thanh cong");
        } catch (Exception e) {
            System.out.println("Ket noi that bai "+e.getMessage());
        }
    }
}