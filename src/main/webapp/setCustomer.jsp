<%-- 
    Document   : setCustomer
    Created on : Oct 20, 2024, 10:09:54 PM
    Author     : Ngô Đắc Tuấn Kiệt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sửa thông tin khách hàng</title>
    <link rel="stylesheet" href="style1.css"/>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        form {
            max-width: 600px;
            margin: auto;
            background: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #555;
        }
        input[type="text"],
        input[type="date"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"] {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 10px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
        }
        input[type="submit"]:hover {
            background-color: #218838;
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
    
    <h1>Sửa thông tin khách hàng</h1>
    <form action="setcustomer" method="post">
        <input type="hidden" name="maKhachHang" value="${khachHang.maKhachHang}" />

        <label for="hoTen">Họ tên:</label>
        <input type="text" id="hoTen" name="hoTen" value="${khachHang.hoTen}" required>

        <label for="gioiTinh">Giới Tính:</label>
        <select id="gioiTinh" name="gioiTinh" required>
            <option value="Nam">Nam</option>
            <option value="Nữ">Nữ</option>
        </select>

        <label for="soDienThoai">Số điện thoại:</label>
        <input type="text" id="soDienThoai" name="soDienThoai" value="${khachHang.soDienThoai}" required>

        <label for="diaChi">Địa chỉ:</label>
        <input type="text" id="diaChi" name="diaChi" value="${khachHang.diaChi}" required>

        <label for="ngaySinh">Ngày sinh:</label>
        <input type="date" id="ngaySinh" name="ngaySinh" value="${khachHang.ngaySinh}">

        <input type="submit" value="Cập nhật">
    </form>
</body>
</html>


