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
import java.util.Date;
import model.KhachHang;

/**
 *
 * @author Ngô Đắc Tuấn Kiệt
 */
public class KhachHangDAO implements DAOInterface<KhachHang>{
    public static KhachHangDAO getInstance(){
        return new KhachHangDAO();
    } 
    
    @Override
    public void insert(KhachHang t) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = JDBC.getConnection();
                    
            String sql = "INSERT INTO KHACHHANG(maKhachHang, hoTen, gioiTinh, soDienThoai, diaChi, ngaySinh) " +
                        "VALUES(?, ? ,?, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaKhachHang());
            pst.setString(2, t.getHoTen());
            pst.setString(3, t.getGioiTinh());
            pst.setString(4, t.getSoDienThoai());
            pst.setString(5, t.getDiaChi());
            pst.setDate(6, new java.sql.Date(t.getNgaySinh().getTime()));
            
            int ketQua = pst.executeUpdate();
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
    public void update(KhachHang t) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = JDBC.getConnection();
                    
            String sql = "UPDATE KHACHHANG " +
                        " SET " +
                        " hoTen=?" +
                        ", gioiTinh=?" +
                        ", soDienThoai=?" +
                        ", diaChi=?" +
                        ", ngaySinh=?" +
                        " WHERE maKhachHang=?";
            pst = con.prepareStatement(sql);
           
            pst.setString(1, t.getHoTen());
            pst.setString(2, t.getGioiTinh());
            pst.setString(3, t.getSoDienThoai());
            pst.setString(4, t.getDiaChi());
            pst.setDate(5, new java.sql.Date(t.getNgaySinh().getTime()));
            pst.setString(6, t.getMaKhachHang());
            
            int ketQua = pst.executeUpdate();
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
    public void delete(KhachHang t) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = JDBC.getConnection();
                    
            String sql = "DELETE from KHACHHANG " +      
                    " WHERE maKhachHang=?";
            pst = con.prepareStatement(sql);
           
            pst.setString(1, t.getMaKhachHang());              
            
            int ketQua = pst.executeUpdate();
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
    public ArrayList<KhachHang> selectAll() {
        ArrayList<KhachHang> ketQua = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {     
            con = JDBC.getConnection();

            String sql = "SELECT * FROM KHACHHANG";            
            pst = con.prepareStatement(sql); 
           
            System.out.println("Ban da thuc thi: " + sql);
           
            rs = pst.executeQuery(); // table có nhiều dòng....
                       
            while(rs.next()){
                String maKhachHang = rs.getString("maKhachHang");
                String hoTen = rs.getString("hoTen");
                String gioiTinh = rs.getString("gioiTinh");
                String soDienThoai = rs.getString("soDienThoai");
                String diaChi = rs.getString("diaChi");
                Date ngaySinh = rs.getDate("ngaySinh");
                KhachHang khachHang = new KhachHang(maKhachHang, hoTen, gioiTinh, soDienThoai, diaChi, ngaySinh);
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
    public KhachHang selectById(String t) {
        KhachHang ketQua = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {     
            con = JDBC.getConnection();

            String sql = "SELECT * FROM KHACHHANG WHERE maKhachHang=?";             
            pst = con.prepareStatement(sql); 
           
            pst.setString(1, t);
            
            System.out.println("Ban da thuc thi: " + sql);
           
            rs = pst.executeQuery(); // table có nhiều dòng....
                       
            while(rs.next()){
                String maKhachHang = rs.getString("maKhachHang");
                String hoTen = rs.getString("hoTen");
                String gioiTinh = rs.getString("gioiTinh");
                String soDienThoai = rs.getString("soDienThoai");
                String diaChi = rs.getString("diaChi");
                Date ngaySinh = rs.getDate("ngaySinh");
                ketQua = new KhachHang(maKhachHang, hoTen, gioiTinh, soDienThoai, diaChi, ngaySinh);
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
    public ArrayList<KhachHang> selectByCondition(String condition) {
        ArrayList<KhachHang> ketQua = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {     
            con = JDBC.getConnection();

            String sql = "SELECT * FROM KHACHHANG WHERE ?";            
            pst = con.prepareStatement(sql); 
            
            pst.setString(1, condition);
            
            System.out.println("Ban da thuc thi: " + sql);
           
            rs = pst.executeQuery(); // table có nhiều dòng....
            while(rs.next()){
                String maKhachHang = rs.getString("maKhachHang");
                String hoTen = rs.getString("hoTen");
                String gioiTinh = rs.getString("gioiTinh");
                String soDienThoai = rs.getString("soDienThoai");
                String diaChi = rs.getString("diaChi");
                Date ngaySinh = rs.getDate("ngaySinh");
                KhachHang khachHang = new KhachHang(maKhachHang, hoTen, gioiTinh, soDienThoai, diaChi, ngaySinh);
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

    public int soLuong() {
        int ketQua = 0;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null; // Khai báo ResultSet để chứa kết quả truy vấn
        try {
            con = JDBC.getConnection();

            String sql = "SELECT COUNT(*) FROM KHACHHANG";             
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
        return ketQua+1;
    }
}
