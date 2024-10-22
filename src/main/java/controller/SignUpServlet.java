/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DangNhapDAO;
import dao.NhanVienDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.DangNhap;
import model.NhanVien;

/**
 *
 * @author Ngô Đắc Tuấn Kiệt
 */
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        request.getRequestDispatcher("signUp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String taiKhoan = request.getParameter("taiKhoan");
        String matKhau = request.getParameter("matKhau");
        String xacNhan = request.getParameter("xacNhan");
        if(matKhau.equals(xacNhan)){
            boolean tmp = DangNhapDAO.getInstance().findTaiKhoan(taiKhoan, matKhau);
            if(tmp==false){
                int cnt = DangNhapDAO.getInstance().soLuongTaiKhoan();
                String maNhanVien = String.format("STAFF%03d", cnt);
                DangNhap res = new DangNhap(taiKhoan, matKhau, maNhanVien);
                DangNhapDAO.getInstance().insert(res);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = null;
                try {
                    date = formatter.parse("2024-01-01");
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                NhanVien tmp1 = new NhanVien(maNhanVien, null, null, null, null, date, null, date);
                NhanVienDAO.getInstance().insert(tmp1);
                request.setAttribute("errorMessage1", "Tài khoản được tạo thành công!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
            } else{
                request.setAttribute("errorMessage1", "Tên tài khoản đã được sử dụng!");
                request.getRequestDispatcher("signUp.jsp").forward(request, response);
                return;
            }
        } else {
            request.setAttribute("errorMessage2", "Vui lòng xác nhận lại mật khẩu!");
            request.getRequestDispatcher("signUp.jsp").forward(request, response);
            return;
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
