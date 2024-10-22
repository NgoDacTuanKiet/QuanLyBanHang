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
import jakarta.servlet.http.HttpSession;
import model.DangNhap;
import model.NhanVien;

/**
 *
 * @author Ngô Đắc Tuấn Kiệt
 */
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        // Lấy ID của nhân viên từ request
//        String maNhanVien = request.getParameter("maNhanVien");
        HttpSession session = request.getSession();
        DangNhap dn = (DangNhap) session.getAttribute("taiKhoan");
        String maNhanVien = dn.getMaNhanVien();
 
        // Lấy thông tin nhân viên từ DB theo mã nhân viên
        NhanVien nhanVien = NhanVienDAO.getInstance().selectById(maNhanVien);
        
        // Đưa thông tin nhân viên lên form
        request.setAttribute("nhanVien", nhanVien);
        request.getRequestDispatcher("profile.jsp").forward(request, response);
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
