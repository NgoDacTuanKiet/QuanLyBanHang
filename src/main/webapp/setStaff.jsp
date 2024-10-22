<%-- 
    Document   : setStaff
    Created on : Oct 21, 2024, 5:37:22 PM
    Author     : Ngô Đắc Tuấn Kiệt
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.NhanVien" %>
<%@ page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cập Nhật Thông Tin Nhân Viên</title>
    <link rel="stylesheet" href="style1.css"/>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .profile-container {
            max-width: 600px;
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
        label {
            display: block;
            margin: 10px 0 5px;
        }
        input[type="text"],
        input[type="date"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box; /* Tính toán padding và border trong tổng chiều rộng */
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
        
        a {
            display: inline-block;
            margin-top: 10px;
            color: #007BFF; /* Màu xanh */
            text-decoration: none; /* Xóa gạch chân */
        }
        a:hover {
            text-decoration: underline; /* Gạch chân khi di chuột */
        }
        /* */
        header {
            background-color: #007bff;
            color: white;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 20px;
            position: relative;
            z-index: 1000;
        }
        nav ul li ul {
            position: absolute;
            top: 100%;
            left: 0;
            background-color: #0056b3;
            display: none;
            list-style: none;
            padding: 0;
            margin: 0;
            min-width: 200px;
        }

        nav ul li ul li a {
            padding: 10px;
            display: block;
            color: white;
        }

        nav ul li ul li a:hover {
            background-color: #003d80;
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
    
    <h2>Cập Nhật Thông Tin Nhân Viên</h2>
    
    <div class="profile-container">
        <form action="setstaff" method="post">
            <input type="hidden" name="maNhanVien" value="${nhanVien.maNhanVien}">
            
            <div>
                <label for="hoTen"><strong>Họ Tên:</strong></label>
                <input type="text" id="hoTen" name="hoTen" value="${nhanVien.hoTen}" required>
            </div>
            <div>
                <label for="gioiTinh"><strong>Giới Tính:</strong></label>
                <select id="gioiTinh" name="gioiTinh">
                    <option value="Nam" <c:if test="${nhanVien.gioiTinh == 'Nam'}"></c:if>Nam</option>
                    <option value="Nữ" <c:if test="${nhanVien.gioiTinh == 'Nữ'}"></c:if>Nữ</option>
                </select>
            </div>
            <div>
                <label for="soDienThoai"><strong>Số Điện Thoại:</strong></label>
                <input type="text" id="soDienThoai" name="soDienThoai" value="${nhanVien.soDienThoai}" required>
            </div>
            <div>
                <label for="diaChi"><strong>Địa Chỉ:</strong></label>
                <input type="text" id="diaChi" name="diaChi" value="${nhanVien.diaChi}" required>
            </div>
            <div>
                <label for="ngaySinh"><strong>Ngày Sinh:</strong></label>
                <input type="date" id="ngaySinh" name="ngaySinh" value="nhanVien.ngaySinh" required>
            </div>
            <div>
                <label for="chucVu"><strong>Chức Vụ:</strong></label>
                <input type="text" id="chucVu" name="chucVu" value="${nhanVien.chucVu}" required>
            </div>
            <div>
                <label for="ngayBatDau"><strong>Ngày Bắt Đầu:</strong></label>
                <input type="date" id="ngayBatDau" name="ngayBatDau" value="nhanVien.ngayBatDau" required>
            </div>
            
            <input type="submit" value="Cập nhật">
        </form>
    </div>
</body>
</html>

