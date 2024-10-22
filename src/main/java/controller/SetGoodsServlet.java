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
public class SetGoodsServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         // Lấy ID của sản phẩm từ request
        String maSanPham = request.getParameter("maSanPham");
        
        // Lấy thông tin sản phẩm từ DB theo mã sản phẩm
        SanPham sanPham = SanPhamDAO.getInstance().selectById(maSanPham);
        
        // Đưa thông tin sản phẩm lên form sửa (setGoods.jsp)
        request.setAttribute("sanPham", sanPham);
        request.getRequestDispatcher("setGoods.jsp").forward(request, response);
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

        // Tạo đối tượng SanPham mới với thông tin cập nhật
        SanPham sanPham = new SanPham(maSanPham, tenSanPham, loaiSanPham, kichCo, mauSac, giaMua, giaBan, soLuongTonKho);

        // Gọi DAO để cập nhật sản phẩm trong DB
        SanPhamDAO.getInstance().update(sanPham);

        // Chuyển hướng về trang danh sách sản phẩm sau khi cập nhật
        response.sendRedirect(request.getContextPath() + "/listgoods");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
