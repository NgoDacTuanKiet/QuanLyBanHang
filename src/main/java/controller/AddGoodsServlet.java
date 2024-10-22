/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.SanPhamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.SanPham;

/**
 *
 * @author Ngô Đắc Tuấn Kiệt
 */
public class AddGoodsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("addGoods.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy các tham số từ form
        String maSanPham = request.getParameter("maSanPham");
        String tenSanPham = request.getParameter("tenSanPham");
        String loaiSanPham = request.getParameter("loaiSanPham");
        String kichCo = request.getParameter("kichCo");
        String mauSac = request.getParameter("mauSac");

        // Chuyển đổi giá mua và giá bán từ chuỗi sang số nguyên
        int giaMua = Integer.parseInt(request.getParameter("giaMua"));
        int giaBan = Integer.parseInt(request.getParameter("giaBan"));
        int soLuongTonKho = Integer.parseInt(request.getParameter("soLuongTonKho"));

        // Tạo đối tượng Sản Phẩm và thêm vào danh sách
        SanPham sanpham = new SanPham(maSanPham, tenSanPham, loaiSanPham, kichCo, mauSac, giaMua, giaBan, soLuongTonKho);
        SanPhamDAO.getInstance().insert(sanpham);
        
        // Điều hướng người dùng về danh sách sản phẩm
        response.sendRedirect(request.getContextPath() + "/listgoods");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
