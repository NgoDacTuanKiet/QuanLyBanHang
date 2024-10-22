/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ChiTietDonHangDAO;
import dao.DonHangDAO;
import dao.SanPhamDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import model.ChiTietDonHang;
import model.DangNhap;
import model.DonHang;
import model.SanPham;
import model.SanPhamOrder;

/**
 *
 * @author Ngô Đắc Tuấn Kiệt
 */
public class ImportGoodsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SanPhamDAO sanphamDAO = SanPhamDAO.getInstance();
        ArrayList<SanPham> list = sanphamDAO.selectAll();
        
        // Đưa danh sách goods vào thuộc tính request
        request.setAttribute("listGoods", list);

        request.getRequestDispatcher("importGoods.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DangNhap dn = (DangNhap) session.getAttribute("taiKhoan");
        String maNhanVien = dn.getMaNhanVien();
        
        // Danh sách các mã sản phẩm được chọn
        String[] selectedProducts = request.getParameterValues("selectedProducts");
        
        // Kiểm tra xem người dùng đã chọn sản phẩm nào chưa
        if (selectedProducts == null || selectedProducts.length == 0) {
            // Nếu không chọn sản phẩm nào, chuyển hướng về trang order và thông báo lỗi
            request.setAttribute("error", "Bạn chưa chọn sản phẩm nào.");
            request.getRequestDispatcher("importGoods.jsp").forward(request, response);
            return;
        }
        Date date = new Date();
        
        int cnt1 = DonHangDAO.getInstance().soLuong();
        String maDonHang = String.format("DH%05d", cnt1);

        // List lưu các sản phẩm đã chọn và thông tin số lượng mua
        ArrayList<SanPhamOrder> danhSachImport = new ArrayList<>();
        int tongTien = 0;

        // Duyệt qua các sản phẩm đã chọn
        
        for (String maSanPham : selectedProducts) {
            // Lấy số lượng của sản phẩm này
            String soLuongParam = request.getParameter("soLuong" + maSanPham);
            int soLuongMua = Integer.parseInt(soLuongParam);

            // Lấy thông tin sản phẩm từ cơ sở dữ liệu
            SanPham sanPham = SanPhamDAO.getInstance().selectById(maSanPham);

            // Tính tổng tiền của sản phẩm này
            int thanhTien = sanPham.getGiaMua() * soLuongMua;
            tongTien += thanhTien;
            int cnt = ChiTietDonHangDAO.getInstance().soLuong();
            String maChiTiet = String.format("CT%05d", cnt);
            ChiTietDonHang tmp = new ChiTietDonHang(maChiTiet, maDonHang, maSanPham, soLuongMua, sanPham.getGiaMua());
            ChiTietDonHangDAO.getInstance().insert(tmp);

            // Thêm sản phẩm đã chọn vào danh sách order
            danhSachImport.add(new SanPhamOrder(sanPham, soLuongMua, thanhTien));
        }
        DonHang tmp_donHang = new DonHang(maDonHang, maNhanVien, date, tongTien, "Chua thanh toan");
        DonHangDAO.getInstance().insert(tmp_donHang);
        
        // Lưu danh sách order và tổng tiền vào request để chuyển tiếp đến trang xác nhận
        request.setAttribute("danhSachImport", danhSachImport);
        request.setAttribute("tongTien", tongTien);
        
        // Chuyển tiếp đến trang xác nhận đơn hàng (order-confirmation.jsp)
        request.getRequestDispatcher("importConfirm.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
