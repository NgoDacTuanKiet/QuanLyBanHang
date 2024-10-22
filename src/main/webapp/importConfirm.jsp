<%-- 
    Document   : importConfirm
    Created on : Oct 22, 2024, 12:44:49 PM
    Author     : Ngô Đắc Tuấn Kiệt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Xác nhận đơn hàng</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            background-color: white;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 12px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        h3 {
            text-align: right;
            color: #333;
        }
        .submit-btn {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            margin-top: 20px;
        }
        .submit-btn:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <h2>Xác nhận đơn hàng</h2>

    <c:if test="${not empty danhSachImport}">
        <form action="payment" method="post">
            <table>
                <thead>
                    <tr>
                        <th>Mã Sản Phẩm</th>
                        <th>Tên Sản Phẩm</th>
                        <th>Số Lượng Mua</th>
                        <th>Thành Tiền</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="order" items="${danhSachImport}" varStatus="status">
                        <tr>
                            <td>${order.sanPham.maSanPham}</td>
                            <td>${order.sanPham.tenSanPham}</td>
                            <td>${order.soLuongNhap}</td>
                            <td>${order.thanhTien}</td>

                            <!-- Hidden fields to send data -->
                            <input type="hidden" name="maSanPham_${status.index}" value="${order.sanPham.maSanPham}"/>
                            <input type="hidden" name="tenSanPham_${status.index}" value="${order.sanPham.tenSanPham}"/>
                            <input type="hidden" name="soLuongNhap_${status.index}" value="${order.soLuongNhap}"/>
                            <input type="hidden" name="thanhTien_${status.index}" value="${order.thanhTien}"/>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <h3>Tổng tiền: ${tongTien}</h3>

            <!-- Hidden field to send total amount -->
            <input type="hidden" name="tongTien" value="${tongTien}"/>

            <!-- Hidden field to send total number of products -->
            <input type="hidden" name="totalItems" value="${fn:length(danhSachImport)}"/>

            <!-- Submit button to send data -->
            <input type="submit" class="submit-btn" value="Xác nhận"/>
        </form>
    </c:if>
</body>
</html>