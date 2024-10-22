/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DonHangDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.DonHang;

/**
 *
 * @author Ngô Đắc Tuấn Kiệt
 */
public class ListInvoiceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DonHangDAO donHangDAO = DonHangDAO.getInstance();
        ArrayList<DonHang> list = donHangDAO.selectAll();
        
        // Đưa danh sách khách hàng vào thuộc tính request
        request.setAttribute("listDonHang", list);
        
        // Chuyển tiếp yêu cầu tới trang JSP
        request.getRequestDispatcher("listInvoice.jsp").forward(request, response);
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
