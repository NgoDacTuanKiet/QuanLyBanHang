<%-- 
    Document   : listGoods
    Created on : Oct 20, 2024, 11:08:18 PM
    Author     : Ngô Đắc Tuấn Kiệt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh Sách Sản Phẩm</title>
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
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        /* CSS cho nút thêm sản phẩm */
        .add-goods-link {
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
                        <li><a href="#">Danh mục</a></li>
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

<h2>Danh Sách Sản Phẩm</h2>

<!-- Liên kết để chuyển đến trang thêm sản phẩm -->
<a class="add-goods-link" href="addgoods">Thêm Sản Phẩm</a>

<table>
    <thead>
        <tr>
            <th>Mã Sản Phẩm</th>
            <th>Tên Sản Phẩm</th>
            <th>Loại Sản Phẩm</th>
            <th>Kích Cỡ</th>
            <th>Màu Sắc</th>
            <th>Giá Mua</th>
            <th>Giá Bán</th>
            <th>Số Lượng Tồn Kho</th>
            <th>Thao tác</th> <!-- Cột mới để chứa nút Sửa -->
        </tr>
    </thead>
    <tbody>
        <c:forEach var="goods" items="${listGoods}">
            <tr>
                <td>${goods.maSanPham}</td>
                <td>${goods.tenSanPham}</td>
                <td>${goods.loaiSanPham}</td>
                <td>${goods.kichCo}</td>
                <td>${goods.mauSac}</td>
                <td>${goods.giaMua}</td>
                <td>${goods.giaBan}</td>
                <td>${goods.soLuongTonKho}</td>
                <td>
                    <!-- Nút sửa thông tin sản phẩm -->
                    <a class="edit-link" href="setgoods?maSanPham=${goods.maSanPham}">Sửa</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>

