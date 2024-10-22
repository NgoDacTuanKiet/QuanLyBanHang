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
import model.ThanhToan;
/**
 *
 * @author admin
 */
public class ThanhToanDAO implements DAOInterface<ThanhToan> {
    
    public static ThanhToanDAO getInstance(){
        return new ThanhToanDAO();
    }
    
    @Override
    public void insert(ThanhToan t) {
        int ketQua = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = JDBC.getConnection();
            String sql = "INSERT INTO THANHTOAN(maThanhToan, maDonHang, ngayThanhToan, phuongThucThanhToan, soTien) " +
                         "VALUES(?, ?, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaThanhToan());
            pst.setString(2, t.getMaDonHang());
            pst.setDate(3, new Date(t.getNgayThanhToan().getTime())); // Chuyển đổi Date thành java.sql.Date
            pst.setString(4, t.getPhuongThucThanhToan());
            pst.setInt(5, t.getSoTien());

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
    public void update(ThanhToan t) {
        int ketQua = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = JDBC.getConnection();
            String sql = "UPDATE THANHTOAN SET maDonHang=?, ngayThanhToan=?, phuongThucThanhToan=?, soTien=? " +
                         "WHERE maThanhToan=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaDonHang());
            pst.setDate(2, new Date(t.getNgayThanhToan().getTime())); // Chuyển đổi Date thành java.sql.Date
            pst.setString(3, t.getPhuongThucThanhToan());
            pst.setInt(4, t.getSoTien());
            pst.setString(5, t.getMaThanhToan());

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
    public void delete(ThanhToan t) {
        int ketQua = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = JDBC.getConnection();
            String sql = "DELETE FROM THANHTOAN WHERE maThanhToan=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaThanhToan());

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
    public ArrayList<ThanhToan> selectAll() {
        ArrayList<ThanhToan> ketQua = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = JDBC.getConnection();
            String sql = "SELECT * FROM THANHTOAN";
            pst = con.prepareStatement(sql);

            System.out.println("Đã thực thi: " + sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String maThanhToan = rs.getString("maThanhToan");
                String maDonHang = rs.getString("maDonHang");
                Date ngayThanhToan = rs.getDate("ngayThanhToan");
                String phuongThucThanhToan = rs.getString("phuongThucThanhToan");
                int soTien = rs.getInt("soTien");
                ThanhToan tt = new ThanhToan(maThanhToan, maDonHang, ngayThanhToan, phuongThucThanhToan, soTien);
                ketQua.add(tt);
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
    public ThanhToan selectById(String t) {
        ThanhToan ketQua = null;Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = JDBC.getConnection();
            String sql = "SELECT * FROM THANHTOAN WHERE maThanhToan=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, t);

            System.out.println("Đã thực thi: " + sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                String maThanhToan = rs.getString("maThanhToan");
                String maDonHang = rs.getString("maDonHang");
                Date ngayThanhToan = rs.getDate("ngayThanhToan");
                String phuongThucThanhToan = rs.getString("phuongThucThanhToan");
                int soTien = rs.getInt("soTien");
                ketQua = new ThanhToan(maThanhToan, maDonHang, ngayThanhToan, phuongThucThanhToan, soTien);
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
    public ArrayList<ThanhToan> selectByCondition(String condition) {
        ArrayList<ThanhToan> ketQua = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = JDBC.getConnection();
            String sql = "SELECT * FROM THANHTOAN WHERE " + condition;
            pst = con.prepareStatement(sql);

            System.out.println("Đã thực thi: " + sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String maThanhToan = rs.getString("maThanhToan");
                String maDonHang = rs.getString("maDonHang");
                Date ngayThanhToan = rs.getDate("ngayThanhToan");
                String phuongThucThanhToan = rs.getString("phuongThucThanhToan");
                int soTien = rs.getInt("soTien");
                ThanhToan tt = new ThanhToan(maThanhToan, maDonHang, ngayThanhToan, phuongThucThanhToan, soTien);
                ketQua.add(tt);
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

            String sql = "SELECT COUNT(*) FROM THANHTOAN";             
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
