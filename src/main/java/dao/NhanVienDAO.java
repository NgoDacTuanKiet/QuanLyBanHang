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
import model.NhanVien;

/**
 *
 * @author Ngô Đắc Tuấn Kiệt
 */
public class NhanVienDAO implements DAOInterface<NhanVien>{
    public static NhanVienDAO getInstance(){
        return new NhanVienDAO();
    } 
    
    @Override
    public void insert(NhanVien t) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = JDBC.getConnection();
                    
            String sql = "INSERT INTO NHANVIEN(maNhanVien, hoTen, gioiTinh, soDienThoai, diaChi, ngaySinh, chucVu, ngayBatDau) " +
                        "VALUES(?, ? ,?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaNhanVien());
            pst.setString(2, t.getHoTen());
            pst.setString(3, t.getGioiTinh());
            pst.setString(4, t.getSoDienThoai());
            pst.setString(5, t.getDiaChi());
            pst.setDate(6, new java.sql.Date(t.getNgaySinh().getTime()));
            pst.setString(7, t.getChucVu());
            pst.setDate(8, new java.sql.Date(t.getNgayBatDau().getTime()));
            
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
    public void update(NhanVien t) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = JDBC.getConnection();
                    
            String sql = "UPDATE NHANVIEN " +
                        " SET " +
                        " hoTen=?" +
                        ", gioiTinh=?" +
                        ", soDienThoai=?" +
                        ", diaChi=?" +
                        ", ngaySinh=?" +
                        ", chucVu=?" +
                        ", ngayBatDau=?" +
                        " WHERE maNhanVien=?";
            pst = con.prepareStatement(sql);
           
            pst.setString(1, t.getHoTen());
            pst.setString(2, t.getGioiTinh());
            pst.setString(3, t.getSoDienThoai());
            pst.setString(4, t.getDiaChi());
            pst.setDate(5, new java.sql.Date(t.getNgaySinh().getTime()));
            pst.setString(6, t.getChucVu());
            pst.setDate(7, new java.sql.Date(t.getNgayBatDau().getTime()));
            pst.setString(8, t.getMaNhanVien());
            
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
    public void delete(NhanVien t) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = JDBC.getConnection();
                    
            String sql = "DELETE from NHANVIEN " +      
                    " WHERE maNhanVien=?";
            pst = con.prepareStatement(sql);
           
            pst.setString(1, t.getMaNhanVien());              
            
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
    public ArrayList<NhanVien> selectAll() {
        ArrayList<NhanVien> ketQua = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {     
            con = JDBC.getConnection();

            String sql = "SELECT * FROM NHANVIEN";            
            pst = con.prepareStatement(sql); 
           
            System.out.println("Ban da thuc thi: " + sql);
           
            rs = pst.executeQuery(); // table có nhiều dòng....
                       
            while(rs.next()){
                String maNhanVien = rs.getString("maNhanVien");
                String hoTen = rs.getString("hoTen");
                String gioiTinh = rs.getString("gioiTinh");
                String soDienThoai = rs.getString("soDienThoai");
                String diaChi = rs.getString("diaChi");
                Date ngaySinh = rs.getDate("ngaySinh");
                String chucVu = rs.getString("chucVu");
                Date ngayBatDau = rs.getDate("ngayBatDau");
                NhanVien nhanVien = new NhanVien(maNhanVien, hoTen, gioiTinh, soDienThoai, diaChi, ngaySinh, chucVu, ngayBatDau);
                ketQua.add(nhanVien);
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
    public NhanVien selectById(String t) {
        NhanVien ketQua = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {     
            con = JDBC.getConnection();

            String sql = "SELECT * FROM NHANVIEN WHERE maNhanVien=?";             
            pst = con.prepareStatement(sql); 
           
            pst.setString(1, t);
            
            System.out.println("Ban da thuc thi: " + sql);
           
            rs = pst.executeQuery(); // table có nhiều dòng....
                       
            while(rs.next()){
                String maNhanVien = rs.getString("maNhanVien");
                String hoTen = rs.getString("hoTen");
                String gioiTinh = rs.getString("gioiTinh");
                String soDienThoai = rs.getString("soDienThoai");
                String diaChi = rs.getString("diaChi");
                Date ngaySinh = rs.getDate("ngaySinh");
                String chucVu = rs.getString("chucVu");
                Date ngayBatDau = rs.getDate("ngayBatDau");
                ketQua = new NhanVien(maNhanVien, hoTen, gioiTinh, soDienThoai, diaChi, ngaySinh, chucVu, ngayBatDau);
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
    public ArrayList<NhanVien> selectByCondition(String condition) {
        ArrayList<NhanVien> ketQua = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {     
            con = JDBC.getConnection();

            String sql = "SELECT * FROM NHANVIEN WHERE ?";            
            pst = con.prepareStatement(sql); 
            
            pst.setString(1, condition);
            
            System.out.println("Ban da thuc thi: " + sql);
           
            rs = pst.executeQuery(); // table có nhiều dòng....
            while(rs.next()){
                String maNhanVien = rs.getString("maNhanVien");
                String hoTen = rs.getString("hoTen");
                String gioiTinh = rs.getString("gioiTinh");
                String soDienThoai = rs.getString("soDienThoai");
                String diaChi = rs.getString("diaChi");
                Date ngaySinh = rs.getDate("ngaySinh");
                String chucVu = rs.getString("chucVu");
                Date ngayBatDau = rs.getDate("ngayBatDau");
                NhanVien nhanVien = new NhanVien(maNhanVien, hoTen, gioiTinh, soDienThoai, diaChi, ngaySinh, chucVu, ngayBatDau);
                ketQua.add(nhanVien);  
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

}
