/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DangNhapDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DangNhap;

/**
 *
 * @author Ngô Đắc Tuấn Kiệt
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String taiKhoan = request.getParameter("taiKhoan");
        String matKhau = request.getParameter("matKhau");

        DangNhap dn = new DangNhap(taiKhoan, matKhau, null);
        DangNhapDAO dangNhapDAO = DangNhapDAO.getInstance();
        DangNhap user = dangNhapDAO.selectById(dn.getTaiKhoan());

        if (user != null && user.getMatKhau().equals(matKhau)) {
            HttpSession session = request.getSession();
            session.setAttribute("taiKhoan", user);

            // Chuyển hướng tới trang chính trong thư mục views
            response.sendRedirect("home.jsp");
        } else {
            // Đăng nhập thất bại, gửi lại thông báo lỗi và trở về trang login.jsp trong thư mục views
            request.setAttribute("errorMessage", "Tài khoản hoặc mật khẩu không chính xác!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
