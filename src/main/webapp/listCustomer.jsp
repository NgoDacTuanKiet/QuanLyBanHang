<%-- 
    Document   : listCustomer
    Created on : Oct 20, 2024, 3:15:47 PM
    Author     : Ngô Đắc Tuấn Kiệt
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <!-- Thêm thẻ fmt để định dạng ngày -->
<html>
<head>
    <title>Danh Sách Khách Hàng</title>
    <<link rel="stylesheet" href="style1.css">
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        /* CSS cho nút thêm khách hàng */
        .add-customer-link {
            display: block;
            margin: 20px 0;
            text-decoration: none;
            color: white;
            background-color: #4CAF50;
            padding: 10px 20px;
            border-radius: 5px;
            width: fit-content;
        }
        
        /* CSS cho nút sửa */
        .edit-link {
            text-decoration: none;
            color: white;
            background-color: #FFA500;
            padding: 5px 10px;
            border-radius: 5px;
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
                        <li><a href="#">Danh sách khách hàng</a></li>
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

<h2>Danh Sách Khách Hàng</h2>

<!-- Liên kết để chuyển đến trang thêm khách hàng -->
<a class="add-customer-link" href="addcustomer">Thêm Khách Hàng</a>

<table>
    <thead>
        <tr>
            <th>Mã Khách Hàng</th>
            <th>Họ Tên</th>
            <th>Giới Tính</th>
            <th>Số Điện Thoại</th>
            <th>Địa Chỉ</th>
            <th>Ngày Sinh</th>
            <th>Thao tác</th> <!-- Cột mới để chứa nút Sửa -->
        </tr>
    </thead>
    <tbody>
        <c:forEach var="customer" items="${listCustomer}">
            <tr>
                <td>${customer.maKhachHang}</td>
                <td>${customer.hoTen}</td>
                <td>${customer.gioiTinh}</td>
                <td>${customer.soDienThoai}</td>
                <td>${customer.diaChi}</td>
                <td>
                    <c:if test="${not empty customer.ngaySinh}">
                        <fmt:formatDate value="${customer.ngaySinh}" pattern="dd/MM/yyyy"/>
                    </c:if>
                </td>
                <td>
                    <!-- Nút sửa thông tin khách hàng -->
                    <a class="edit-link" href="setcustomer?maKhachHang=${customer.maKhachHang}">Sửa</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>