<%-- 
    Document   : importGoods
    Created on : Oct 22, 2024, 12:41:17 PM
    Author     : Ngô Đắc Tuấn Kiệt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Nhập hàng</title>
    <link rel="stylesheet" href="style1.css"/>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .import-container {
            max-width: 1000px;
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
        .button-container {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }
        .back-link, input[type="submit"] {
            display: inline-block;
            padding: 10px 15px;
            background-color: #FFA500;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            text-align: center;
            transition: background-color 0.3s ease;
            cursor: pointer;
            border: none;
        }
        .back-link:hover, input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .error-message {
            color: red;
            text-align: center;
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

    <div class="import-container">
        <h2>Nhập hàng</h2>
        <form action="importgoods" method="post">
            <table>
                <thead>
                    <tr>
                        <th>Chọn</th>
                        <th>Mã Sản Phẩm</th>
                        <th>Tên Sản Phẩm</th>
                        <th>Loại Sản Phẩm</th>
                        <th>Kích Cỡ</th>
                        <th>Màu Sắc</th>
                        <th>Giá Mua</th>
                        <th>Giá Bán</th>
                        <th>Số Lượng Tồn Kho</th>
                        <th>Số Lượng Đặt Mua</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="sanPham" items="${listGoods}">
                        <tr>
                            <td><input type="checkbox" name="selectedProducts" value="${sanPham.maSanPham}"/></td>
                            <td>${sanPham.maSanPham}</td>
                            <td>${sanPham.tenSanPham}</td>
                            <td>${sanPham.loaiSanPham}</td>
                            <td>${sanPham.kichCo}</td>
                            <td>${sanPham.mauSac}</td>
                            <td>${sanPham.giaMua}</td>
                            <td>${sanPham.giaBan}</td>
                            <td>${sanPham.soLuongTonKho}</td>
                            <td><input type="number" name="soLuong${sanPham.maSanPham}" value="0"></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <c:if test="${not empty error}">
                <p class="error-message">${error}</p>
            </c:if>

            <div class="button-container">
                <a href="home.jsp" class="back-link">Quay lại</a>
                <input type="submit" value="Đặt hàng"/>
            </div>
        </form>
    </div>
</body>
</html>