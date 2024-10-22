<%-- 
    Document   : invoiceDetail
    Created on : Oct 22, 2024, 2:16:24 PM
    Author     : Ngô Đắc Tuấn Kiệt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Chi tiết đơn hàng</title>
    <link rel="stylesheet" href="style1.css"/>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .order-container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
            background-color: #fff;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        h3 {
            text-align: right;
            color: #333;
        }
        .back-link {
            display: inline-block;
            padding: 10px 15px;
            background-color: #FFA500;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            text-align: center;
            margin-top: 20px;
            transition: background-color 0.3s ease;
        }
        .back-link:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <header>
        <nav>
            <ul>
                <li><a href="home.jsp">Tổng quan</a></li>
                <li>
                    <a href="#">Hàng hóa</a>
                    <ul>
                        <li><a href="listgoods">Danh mục</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">Giao dịch</a>
                    <ul>
                        <li><a href="listinvoice">Hóa Đơn</a></li>
                        <li><a href="importgoods">Nhập hàng</a></li>
                        <li><a href="#">Lịch sử giao dịch</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">Khách hàng</a>
                    <ul>
                        <li><a href="listcustomer">Danh sách khách hàng</a></li>
                    </ul>
                </li>
            </ul>
        </nav>

        <div class="account">
            <a href="#">Tài khoản</a>
            <ul class="account-dropdown">
                <li><a href="profile">Thông tin</a></li>
                <li><a href="login">Đăng xuất</a></li>
            </ul>
        </div>
    </header>

    <div class="order-container">
        <h2>Chi tiết đơn hàng</h2>

        <c:if test="${not empty danhSachSanPham}">
            <table>
                <thead>
                    <tr>
                        <th>Mã Sản Phẩm</th>
                        <th>Tên Sản Phẩm</th>
                        <th>Số Lượng</th>
                        <th>Giá Nhập</th>
                        <th>Thành Tiền</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="sanPhamOrder" items="${danhSachSanPham}" varStatus="status">
                        <tr>
                            <td>${sanPhamOrder.sanPham.maSanPham}</td>
                            <td>${sanPhamOrder.sanPham.tenSanPham}</td>
                            <td>${sanPhamOrder.soLuongNhap}</td>
                            <td>${sanPhamOrder.sanPham.giaMua}</td>
                            <td>${sanPhamOrder.thanhTien}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <h3>Tổng tiền: ${tongTien}</h3>
        </c:if>

        <a href="listinvoice" class="back-link">Quay lại</a>
    </div>
</body>
</html>
