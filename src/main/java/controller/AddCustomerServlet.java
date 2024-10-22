/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.KhachHangDAO;
import java.io.IOException;
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
public class AddCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("addCustomer.jsp").forward(request, response);
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


        // Tạo đối tượng Customer và thêm vào danh sách
        KhachHang khachhang = new KhachHang(maKhachHang, hoTen, gioiTinh, soDienThoai, diaChi, ngaySinh);
        KhachHangDAO.getInstance().insert(khachhang);
        response.sendRedirect(request.getContextPath() + "/listcustomer");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
