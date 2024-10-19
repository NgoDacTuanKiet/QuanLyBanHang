/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DangNhap;

/**
 *
 * @author Ngô Đắc Tuấn Kiệt
 */
public class DangNhapDAO implements DAOInterface<DangNhap>{
    public static DangNhapDAO getInstance(){
        return new DangNhapDAO();
    } 
    
    @Override
    public void insert(DangNhap t) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = JDBC.getConnection();
                    
            String sql = "INSERT INTO DANGNHAP(taiKhoan, matKhau, maKhachHang) " +
                        "VALUES(?, ? ,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, t.getTaiKhoan());
            pst.setString(2, t.getMatKhau());
            pst.setString(3, t.getMaKhachHang());
            
            
            int ketQua = pst.executeUpdate();
            
            System.out.println("Ban da thuc thi: " + sql);
            System.out.println("Co " + ketQua + " dong bi thay doi");
                    
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Đóng ResultSet, PreparedStatement và Connection
            try {
                if (pst != null) {
                    pst.close(); // Đóng PreparedStatement
                }
                JDBC.closeConnection(con); // Đóng Connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return;
    }

    @Override
    public void update(DangNhap t) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = JDBC.getConnection();
                    
            String sql = "UPDATE DANGNHAP " +
                        " SET " +
                        " matKhau=?" +
                        " WHERE taiKhoan=?";
            pst = con.prepareStatement(sql);
           
            pst.setString(1, t.getMatKhau());
            pst.setString(2, t.getTaiKhoan());
            
            int ketQua = pst.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Đóng ResultSet, PreparedStatement và Connection
            try {
                if (pst != null) {
                    pst.close(); // Đóng PreparedStatement
                }
                JDBC.closeConnection(con); // Đóng Connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return;
    }

    @Override
    public void delete(DangNhap t) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = JDBC.getConnection();
                    
            String sql = "DELETE from DANGNHAP " +      
                    " WHERE maKhachHang=?";
            pst = con.prepareStatement(sql);
           
            pst.setString(1, t.getMaKhachHang());              
            
            int ketQua = pst.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Đóng ResultSet, PreparedStatement và Connection
            try {
                if (pst != null) {
                    pst.close(); // Đóng PreparedStatement
                }
                JDBC.closeConnection(con); // Đóng Connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return;
    }

    @Override
    public ArrayList<DangNhap> selectAll() {
        ArrayList<DangNhap> ketQua = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {     
            con = JDBC.getConnection();

            String sql = "SELECT * FROM DANGNHAP";            
            pst = con.prepareStatement(sql); 
           
            System.out.println("Ban da thuc thi: " + sql);
           
            rs = pst.executeQuery(); // table có nhiều dòng....
                       
            while(rs.next()){
                String taiKhoan = rs.getString("taiKhoan");
                String matKhau = rs.getString("matKhau");
                String maKhachHang = rs.getString("maKhachHang");
                DangNhap khachHang = new DangNhap(taiKhoan, matKhau, maKhachHang);
                ketQua.add(khachHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng ResultSet, PreparedStatement và Connection
            try {
                if (rs != null) {
                    rs.close(); // Đóng ResultSet
                }
                if (pst != null) {
                    pst.close(); // Đóng PreparedStatement
                }
                JDBC.closeConnection(con); // Đóng Connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } 
        return ketQua;   
    }

    @Override
    public DangNhap selectById(DangNhap t) {
        DangNhap ketQua = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {     
            con = JDBC.getConnection();

            String sql = "SELECT * FROM DANGNHAP WHERE taiKhoan=?";             
            pst = con.prepareStatement(sql); 
           
            pst.setString(1, t.getTaiKhoan());
            
            System.out.println("Ban da thuc thi: " + sql);
           
            rs = pst.executeQuery(); // table có nhiều dòng....
                       
            while(rs.next()){
                String taiKhoan = rs.getString("taiKhoan");
                String matKhau = rs.getString("matKhau");
                String maKhachHang = rs.getString("maKhachHang");
                ketQua = new DangNhap(taiKhoan, matKhau, maKhachHang);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng ResultSet, PreparedStatement và Connection
            try {
                if (rs != null) {
                    rs.close(); // Đóng ResultSet
                }
                if (pst != null) {
                    pst.close(); // Đóng PreparedStatement
                }
                JDBC.closeConnection(con); // Đóng Connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ketQua; 
    }

    @Override
    public ArrayList<DangNhap> selectByCondition(String condition) {
        ArrayList<DangNhap> ketQua = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {     
            con = JDBC.getConnection();

            String sql = "SELECT * FROM DANGNHAP WHERE ?";            
            pst = con.prepareStatement(sql); 
            
            pst.setString(1, condition);
            
            System.out.println("Ban da thuc thi: " + sql);
           
            rs = pst.executeQuery(); // table có nhiều dòng....
            while(rs.next()){
                String taiKhoan = rs.getString("taiKhoan");
                String matKhau = rs.getString("matKhau");
                String maKhachHang = rs.getString("maKhachHang");
                DangNhap khachHang = new DangNhap(taiKhoan, matKhau, maKhachHang);
                ketQua.add(khachHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng ResultSet, PreparedStatement và Connection
            try {
                if (rs != null) {
                    rs.close(); // Đóng ResultSet
                }
                if (pst != null) {
                    pst.close(); // Đóng PreparedStatement
                }
                JDBC.closeConnection(con); // Đóng Connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ketQua;  
    }
    
    public boolean findTaiKhoan(String tmp_taiKhoan, String tmp_matKhau) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = JDBC.getConnection();

            String sql = "SELECT * FROM DANGNHAP WHERE taiKhoan=?";             
            pst = con.prepareStatement(sql); 
           
            pst.setString(1, tmp_taiKhoan);
            
            System.out.println("Ban da thuc thi: " + sql);
           
            rs = pst.executeQuery(); // table có nhiều dòng....
                       
            while(rs.next()){
                return true;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng ResultSet, PreparedStatement và Connection
            try {
                if (rs != null) {
                    rs.close(); // Đóng ResultSet
                }
                if (pst != null) {
                    pst.close(); // Đóng PreparedStatement
                }
                JDBC.closeConnection(con); // Đóng Connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
    public int soLuongTaiKhoan() {
        int ketQua = 0;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null; // Khai báo ResultSet để chứa kết quả truy vấn
        try {
            con = JDBC.getConnection();

            String sql = "SELECT COUNT(*) FROM DANGNHAP";             
            pst = con.prepareStatement(sql); 

            // Thực thi truy vấn và lưu kết quả vào ResultSet
            rs = pst.executeQuery();

            // Lấy số lượng từ ResultSet
            if (rs.next()) {
                ketQua = rs.getInt(1); // Lấy giá trị đếm từ cột đầu tiên
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng ResultSet, PreparedStatement và Connection
            try {
                if (rs != null) {
                    rs.close(); // Đóng ResultSet
                }
                if (pst != null) {
                    pst.close(); // Đóng PreparedStatement
                }
                JDBC.closeConnection(con); // Đóng Connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ketQua+1; // Trả về số lượng tài khoản
    }
}
