/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.KhachHangDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.KhachHang;

/**
 *
 * @author Ngô Đắc Tuấn Kiệt
 */
public class SetCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy ID của khách hàng từ request
        String maKhachHang = request.getParameter("maKhachHang");
        
        // Lấy thông tin khách hàng từ DB theo mã khách hàng
        KhachHang khachHang = KhachHangDAO.getInstance().selectById(maKhachHang);
        
        // Đưa thông tin khách hàng lên form sửa (setCustomer.jsp)
        request.setAttribute("khachHang", khachHang);
        request.getRequestDispatcher("setCustomer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy các tham số từ form
        String maKhachHang = request.getParameter("maKhachHang");
        String hoTen = request.getParameter("hoTen");
        String gioiTinh = request.getParameter("gioiTinh");
        String soDienThoai = request.getParameter("soDienThoai");
        String diaChi = request.getParameter("diaChi");
        String ngaySinhString = request.getParameter("ngaySinh");

        Date ngaySinh = null;
        // Chuyển đổi chuỗi ngày sinh sang đối tượng Date
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            ngaySinh = formatter.parse(ngaySinhString);
            
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Tạo đối tượng KhachHang mới với thông tin cập nhật
        KhachHang khachHang = new KhachHang(maKhachHang, hoTen, gioiTinh, soDienThoai, diaChi, ngaySinh);

        // Gọi DAO để cập nhật khách hàng trong DB
        KhachHangDAO.getInstance().update(khachHang);

        // Chuyển hướng về trang danh sách khách hàng sau khi cập nhật
        response.sendRedirect(request.getContextPath() + "/listcustomer");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
