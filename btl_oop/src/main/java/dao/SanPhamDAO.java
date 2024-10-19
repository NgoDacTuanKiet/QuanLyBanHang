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
import model.SanPham;

/**
 *
 * @author admin
 */
public class SanPhamDAO implements DAOInterface<SanPham> {
    
    public static SanPhamDAO getInstance(){
        return new SanPhamDAO();
    }
    
    @Override
    public void insert(SanPham t) {
        int ketQua = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = JDBC.getConnection();
            String sql = "INSERT INTO SANPHAM(maSanPham, tenSanPham, loaiSanPham, kichCo, mauSac, giaMua, giaBan, soLuongTonKho) " +
                         "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaSanPham());
            pst.setString(2, t.getTenSanPham());
            pst.setString(3, t.getLoaiSanPham());
            pst.setString(4, t.getKichCo());
            pst.setString(5, t.getMauSac());
            pst.setInt(6, t.getGiaMua());
            pst.setInt(7, t.getGiaBan());
            pst.setInt(8, t.getSoLuongTonKho());

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
        return ;
    }

    @Override
    public void update(SanPham t) {
        int ketQua = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = JDBC.getConnection();
            String sql = "UPDATE SANPHAM SET tenSanPham=?, loaiSanPham=?, kichCo=?, mauSac=?, giaMua=?, giaBan=?, soLuongTonKho=? " +
                         "WHERE maSanPham=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, t.getTenSanPham());
            pst.setString(2, t.getLoaiSanPham());
            pst.setString(3, t.getKichCo());
            pst.setString(4, t.getMauSac());
            pst.setInt(5, t.getGiaMua());
            pst.setInt(6, t.getGiaBan());
            pst.setInt(7, t.getSoLuongTonKho());
            pst.setString(8, t.getMaSanPham());

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
    public void delete(SanPham t) {
        int ketQua = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = JDBC.getConnection();
            String sql = "DELETE FROM SANPHAM WHERE maSanPham=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaSanPham());

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
    public ArrayList<SanPham> selectAll() {
        ArrayList<SanPham> ketQua = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = JDBC.getConnection();
            String sql = "SELECT * FROM SANPHAM";
            pst = con.prepareStatement(sql);

            System.out.println("Đã thực thi: " + sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String maSanPham = rs.getString("maSanPham");
                String tenSanPham = rs.getString("tenSanPham");
                String loaiSanPham = rs.getString("loaiSanPham");
                String kichCo = rs.getString("kichCo");
                String mauSac = rs.getString("mauSac");
                int giaMua = rs.getInt("giaMua");
                int giaBan = rs.getInt("giaBan");
                int soLuongTonKho = rs.getInt("soLuongTonKho");
                SanPham sp = new SanPham(maSanPham, tenSanPham, loaiSanPham, kichCo, mauSac, giaMua, giaBan, soLuongTonKho);
                ketQua.add(sp);
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
    public SanPham selectById(SanPham t) {
        SanPham ketQua = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = JDBC.getConnection();
            String sql = "SELECT * FROM SANPHAM WHERE maSanPham=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaSanPham());

            System.out.println("Đã thực thi: " + sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                String maSanPham = rs.getString("maSanPham");
                String tenSanPham = rs.getString("tenSanPham");
                String loaiSanPham = rs.getString("loaiSanPham");
                String kichCo = rs.getString("kichCo");
                String mauSac = rs.getString("mauSac");
                int giaMua = rs.getInt("giaMua");
                int giaBan = rs.getInt("giaBan");
                int soLuongTonKho = rs.getInt("soLuongTonKho");
                ketQua = new SanPham(maSanPham, tenSanPham, loaiSanPham, kichCo, mauSac, giaMua, giaBan, soLuongTonKho);
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
    public ArrayList<SanPham> selectByCondition(String condition) {
        ArrayList<SanPham> ketQua = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = JDBC.getConnection();
            String sql = "SELECT * FROM SANPHAM WHERE " + condition;
            pst = con.prepareStatement(sql);

            System.out.println("Đã thực thi: " + sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String maSanPham = rs.getString("maSanPham");
                String tenSanPham = rs.getString("tenSanPham");
                String loaiSanPham = rs.getString("loaiSanPham");
                String kichCo = rs.getString("kichCo");
                String mauSac = rs.getString("mauSac");
                int giaMua = rs.getInt("giaMua");
                int giaBan = rs.getInt("giaBan");
                int soLuongTonKho = rs.getInt("soLuongTonKho");
                SanPham sp = new SanPham(maSanPham, tenSanPham, loaiSanPham, kichCo, mauSac, giaMua, giaBan, soLuongTonKho);
                ketQua.add(sp);
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
