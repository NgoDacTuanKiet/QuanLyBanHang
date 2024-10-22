/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ngô Đắc Tuấn Kiệt
 */
public class JDBC {
    public static Connection getConnection() throws SQLException {
    Connection c = null;
    try {
        // Đường dẫn kết nối tới SQL Server
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyBanHang;encrypt=true;trustServerCertificate=true;";
        String user = "sa";
        String password = "123456";

        // Đăng ký driver JDBC cho SQL Server
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        // Kết nối tới SQL Server
        c = DriverManager.getConnection(url, user, password);
    } catch (SQLException e) {
        // Ném lại ngoại lệ SQL để được xử lý ở nơi khác
        throw new SQLException("Không thể kết nối với cơ sở dữ liệu", e);
    } catch (ClassNotFoundException e) {
        // Nếu driver không tìm thấy
        throw new SQLException("JDBC Driver không được tìm thấy", e);
    }
    return c;
}

    
    public static void closeConnection(Connection c) throws SQLException{
        try {
            if(c!=null) c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void printInfo(Connection c){
        try {
            if(c!=null){
                DatabaseMetaData mtdt = c.getMetaData();
                System.out.println(mtdt.getDatabaseProductName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
