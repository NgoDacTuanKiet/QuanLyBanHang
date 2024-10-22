/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.NhanVienDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.NhanVien;

/**
 *
 * @author Ngô Đắc Tuấn Kiệt
 */
public class SetStaffServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy ID của nhân viên từ request
        String maNhanVien = request.getParameter("maNhanVien");
        
        // Lấy thông tin nhân viên từ DB theo mã nhân viên
        NhanVien nhanVien = NhanVienDAO.getInstance().selectById(maNhanVien);
        
        // Đưa thông tin nhân viên lên form sửa (setStaff.jsp)
        request.setAttribute("nhanVien", nhanVien);
        request.getRequestDispatcher("setStaff.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy các tham số từ form
        String maNhanVien = request.getParameter("maNhanVien");
        String hoTen = request.getParameter("hoTen");
        String gioiTinh = request.getParameter("gioiTinh");
        String soDienThoai = request.getParameter("soDienThoai");
        String diaChi = request.getParameter("diaChi");
        String ngaySinhString = request.getParameter("ngaySinh");
        String chucVu = request.getParameter("chucVu");
        String ngayBatDauString = request.getParameter("ngayBatDau");

        Date ngaySinh = null;
        Date ngayBatDau = null;
        
        // Chuyển đổi chuỗi ngày sinh sang đối tượng Date
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            ngaySinh = formatter.parse(ngaySinhString);
            ngayBatDau = formatter.parse(ngayBatDauString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Tạo đối tượng NhanVien mới với thông tin cập nhật
        NhanVien nhanVien = new NhanVien(maNhanVien, hoTen, gioiTinh, soDienThoai, diaChi, ngaySinh, chucVu, ngayBatDau);

        // Gọi DAO để cập nhật nhân viên trong DB
        NhanVienDAO.getInstance().update(nhanVien);

        // Chuyển hướng về trang danh sách nhân viên sau khi cập nhật
        response.sendRedirect(request.getContextPath() + "/profile");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
