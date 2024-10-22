<%-- 
    Document   : listInvoice
    Created on : Oct 22, 2024, 2:01:55 PM
    Author     : Ngô Đắc Tuấn Kiệt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <!-- Thêm thẻ fmt để định dạng ngày -->
<html>
<head>
    <title>Danh Sách Đơn Hàng</title>
    <link rel="stylesheet" href="style1.css">
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
            color: white;
            background-color: #4CAF50;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        /* CSS cho nút chi tiết */
        .detail-link {
            text-decoration: none;
            color: white;
            background-color: #FFA500;
            padding: 5px 10px;
            border-radius: 5px;
        }

        /* CSS cho tiêu đề trang */
        h2 {
            margin: 20px 0;
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
<h2>Danh Sách Đơn Hàng</h2>

<table>
    <thead>
        <tr>
            <th>Mã Đơn Hàng</th>
            <th>Mã Nhân Viên</th>
            <th>Ngày Đặt Hàng</th>
            <th>Tổng Tiền</th>
            <th>Trạng Thái</th>
            <th>Thao tác</th> <!-- Cột chứa nút Chi Tiết -->
        </tr>
    </thead>
    <tbody>
        <c:forEach var="donHang" items="${listDonHang}">
            <tr>
                <td>${donHang.maDonHang}</td>
                <td>${donHang.maNhanVien}</td>
                <td>${donHang.ngayDatHang}</td>
                <td>${donHang.tongTien}</td>
                <td>${donHang.trangThai}</td>
                <td>
                    <!-- Nút để xem chi tiết đơn hàng -->
                    <a class="detail-link" href="invoicedetail?maDonHang=${donHang.maDonHang}">Chi Tiết</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>

