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
import java.util.ArrayList;
import model.KhachHang;

/**
 *
 * @author Ngô Đắc Tuấn Kiệt
 */
public class ListCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        KhachHangDAO khachhangDAO = KhachHangDAO.getInstance();
        ArrayList<KhachHang> list = khachhangDAO.selectAll();
        
        // Đưa danh sách khách hàng vào thuộc tính request
        request.setAttribute("listCustomer", list);
        
        // Chuyển tiếp yêu cầu tới trang JSP
        request.getRequestDispatcher("listCustomer.jsp").forward(request, response);
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
