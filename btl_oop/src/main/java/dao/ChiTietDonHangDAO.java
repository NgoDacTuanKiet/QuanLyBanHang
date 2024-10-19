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
import model.ChiTietDonHang;
/**
 *
 * @author admin
 */
public class ChiTietDonHangDAO implements DAOInterface<ChiTietDonHang> {
    public static ChiTietDonHangDAO getInstance(){
        return new ChiTietDonHangDAO();
    } 
    
    @Override
    public void insert(ChiTietDonHang t) {
        int ketQua = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = JDBC.getConnection();
            String sql = "INSERT INTO CHITIETDONHANG(maChiTiet, maHoaDon, maSanPham, soLuong, donGia) " +
                         "VALUES(?, ?, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaChiTiet());
            pst.setString(2, t.getMaHoaDon());
            pst.setString(3, t.getMaSanPham());
            pst.setInt(4, t.getSoLuong());
            pst.setInt(5, t.getDonGia());

            ketQua = pst.executeUpdate();
            System.out.println("Đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi");
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
    public void update(ChiTietDonHang t) {
        int ketQua = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = JDBC.getConnection();
            String sql = "UPDATE CHITIETDONHANG SET maHoaDon=?, maSanPham=?, soLuong=?, donGia=? " +
                         "WHERE maChiTiet=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaHoaDon());
            pst.setString(2, t.getMaSanPham());
            pst.setInt(3, t.getSoLuong());
            pst.setInt(4, t.getDonGia());
            pst.setString(5, t.getMaChiTiet());

            ketQua = pst.executeUpdate();
            System.out.println("Đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi");

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
    public void delete(ChiTietDonHang t) {
        int ketQua = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = JDBC.getConnection();
            String sql = "DELETE FROM CHITIETDONHANG WHERE maChiTiet=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaChiTiet());

            ketQua = pst.executeUpdate();
            System.out.println("Đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi");
            
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
    public ArrayList<ChiTietDonHang> selectAll() {
        ArrayList<ChiTietDonHang> ketQua = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = JDBC.getConnection();
            String sql = "SELECT * FROM CHITIETDONHANG";
            pst = con.prepareStatement(sql);

            System.out.println("Đã thực thi: " + sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String maChiTiet = rs.getString("maChiTiet");
                String maHoaDon = rs.getString("maHoaDon");
                String maSanPham = rs.getString("maSanPham");
                int soLuong = rs.getInt("soLuong");
                int donGia = rs.getInt("donGia");
                ChiTietDonHang ct = new ChiTietDonHang(maChiTiet, maHoaDon, maSanPham, soLuong, donGia);
                ketQua.add(ct);
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
    public ChiTietDonHang selectById(ChiTietDonHang t) {
        ChiTietDonHang ketQua = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = JDBC.getConnection();
            String sql = "SELECT * FROM CHITIETDONHANG WHERE maChiTiet=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaChiTiet());

            System.out.println("Đã thực thi: " + sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                String maChiTiet = rs.getString("maChiTiet");
                String maHoaDon = rs.getString("maHoaDon");
                String maSanPham = rs.getString("maSanPham");
                int soLuong = rs.getInt("soLuong");
                int donGia = rs.getInt("donGia");
                ketQua = new ChiTietDonHang(maChiTiet, maHoaDon, maSanPham, soLuong, donGia);
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
    public ArrayList<ChiTietDonHang> selectByCondition(String condition) {
        ArrayList<ChiTietDonHang> ketQua = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = JDBC.getConnection();
            String sql = "SELECT * FROM CHITIETDONHANG WHERE " + condition;
            pst = con.prepareStatement(sql);

            System.out.println("Đã thực thi: " + sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String maChiTiet = rs.getString("maChiTiet");
                String maHoaDon = rs.getString("maHoaDon");
                String maSanPham = rs.getString("maSanPham");
                int soLuong = rs.getInt("soLuong");
                int donGia = rs.getInt("donGia");
                ChiTietDonHang ct = new ChiTietDonHang(maChiTiet, maHoaDon, maSanPham, soLuong, donGia);
                ketQua.add(ct);
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
