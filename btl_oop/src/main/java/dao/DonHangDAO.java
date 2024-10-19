/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DonHang;
/**
 *
 * @author admin
 */
public class DonHangDAO implements DAOInterface<DonHang> {

    public static DonHangDAO getInstance(){
        return new DonHangDAO();
    }
    
    @Override
    public void insert(DonHang t) {
        int ketQua = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = JDBC.getConnection();
            String sql = "INSERT INTO DONHANG(maDonHang, maKhachHang, ngayDatHang, tongTien, trangThai) " +
                         "VALUES(?, ?, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaDonHang());
            pst.setString(2, t.getMaKhachHang());
            pst.setDate(3, new Date(t.getNgayDatHang().getTime())); // Chuyển đổi Date thành java.sql.Date
            pst.setInt(4, t.getTongTien());
            pst.setString(5, t.getTrangThai());

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
    public void update(DonHang t) {
        int ketQua = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = JDBC.getConnection();
            String sql = "UPDATE DONHANG SET maKhachHang=?, ngayDatHang=?, tongTien=?, trangThai=? " +
                         "WHERE maDonHang=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaKhachHang());
            pst.setDate(2, new Date(t.getNgayDatHang().getTime())); // Chuyển đổi Date thành java.sql.Date
            pst.setInt(3, t.getTongTien());
            pst.setString(4, t.getTrangThai());
            pst.setString(5, t.getMaDonHang());

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
    public void delete(DonHang t) {
        int ketQua = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = JDBC.getConnection();
            String sql = "DELETE FROM DONHANG WHERE maDonHang=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaDonHang());

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
    public ArrayList<DonHang> selectAll() {
        ArrayList<DonHang> ketQua = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = JDBC.getConnection();
            String sql = "SELECT * FROM DONHANG";
            pst = con.prepareStatement(sql);

            System.out.println("Đã thực thi: " + sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String maDonHang = rs.getString("maDonHang");
                String maKhachHang = rs.getString("maKhachHang");
                Date ngayDatHang = rs.getDate("ngayDatHang");
                int tongTien = rs.getInt("tongTien");
                String trangThai = rs.getString("trangThai");
                DonHang dh = new DonHang(maDonHang, maKhachHang, ngayDatHang, tongTien, trangThai);
                ketQua.add(dh);
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
    public DonHang selectById(DonHang t) {
        DonHang ketQua = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = JDBC.getConnection();
            String sql = "SELECT * FROM DONHANG WHERE maDonHang=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaDonHang());

            System.out.println("Đã thực thi: " + sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                String maDonHang = rs.getString("maDonHang");
                String maKhachHang = rs.getString("maKhachHang");
                Date ngayDatHang = rs.getDate("ngayDatHang");
                int tongTien = rs.getInt("tongTien");
                String trangThai = rs.getString("trangThai");
                ketQua = new DonHang(maDonHang, maKhachHang, ngayDatHang, tongTien, trangThai);
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
    public ArrayList<DonHang> selectByCondition(String condition) {
        ArrayList<DonHang> ketQua = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = JDBC.getConnection();
            String sql = "SELECT * FROM DONHANG WHERE " + condition;
            pst = con.prepareStatement(sql);

            System.out.println("Đã thực thi: " + sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String maDonHang = rs.getString("maDonHang");
                String maKhachHang = rs.getString("maKhachHang");
                Date ngayDatHang = rs.getDate("ngayDatHang");
                int tongTien = rs.getInt("tongTien");
                String trangThai = rs.getString("trangThai");
                DonHang dh = new DonHang(maDonHang, maKhachHang, ngayDatHang, tongTien, trangThai);
                ketQua.add(dh);
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