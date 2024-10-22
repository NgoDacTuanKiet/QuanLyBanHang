/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ChiTietDonHangDAO;
import dao.SanPhamDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.ChiTietDonHang;
import model.SanPham;
import model.SanPhamOrder;

/**
 *
 * @author Ngô Đắc Tuấn Kiệt
 */
public class InvoiceDetailServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String maDonHang = request.getParameter("maDonHang");
        
        ArrayList<ChiTietDonHang> list = ChiTietDonHangDAO.getInstance().selectByMaHoaDon(maDonHang);
        ArrayList<SanPhamOrder> danhSachSanPham = new ArrayList<>();
        
        int tongTien = 0;
        for(ChiTietDonHang i : list){
            String maSanPham = i.getMaSanPham();
            SanPham sanPham = SanPhamDAO.getInstance().selectById(maSanPham);
            int soLuongMua = i.getSoLuong();
            int thanhTien = i.getSoLuong() * i.getDonGia();
            danhSachSanPham.add(new SanPhamOrder(sanPham, soLuongMua, thanhTien));
            tongTien += thanhTien;
        }
        
        request.setAttribute("danhSachSanPham", danhSachSanPham);
        request.setAttribute("tongTien", tongTien);
        request.getRequestDispatcher("invoiceDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
