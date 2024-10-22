/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.SanPhamDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.SanPham;

/**
 *
 * @author Ngô Đắc Tuấn Kiệt
 */
public class PaymentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy tổng số sản phẩm từ request
        int totalItems = Integer.parseInt(request.getParameter("totalItems"));

        // Lặp qua các sản phẩm đã được gửi trong request
        for (int i = 0; i < totalItems; i++) {
            // Lấy thông tin từng sản phẩm
            String maSanPham = request.getParameter("maSanPham_" + i);
            String tenSanPham = request.getParameter("tenSanPham_" + i);
            int soLuongNhap = Integer.parseInt(request.getParameter("soLuongNhap_" + i));
            
            SanPham sanPham = SanPhamDAO.getInstance().selectById(maSanPham);
            SanPham tmp = new SanPham(maSanPham, tenSanPham, sanPham.getLoaiSanPham(), sanPham.getKichCo(),
                    sanPham.getMauSac(), sanPham.getGiaMua(), sanPham.getGiaBan(), sanPham.getSoLuongTonKho() + soLuongNhap);
            SanPhamDAO.getInstance().update(tmp);
        }
        response.sendRedirect(request.getContextPath() + "/listinvoice");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
