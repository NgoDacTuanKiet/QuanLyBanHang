<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@ page import="model.NhanVien" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <!-- Thêm thẻ fmt để định dạng ngày -->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Thông Tin Nhân Viên</title>
    <link rel="stylesheet" href="style1.css">
    <style>
        .profile-container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
            background-color: #f9f9f9;
        }

        .profile-actions {
            margin-top: 20px;
        }

        .edit-button {
            background-color: #4CAF50; /* Màu nền xanh */
            color: white; /* Màu chữ trắng */
            padding: 10px 15px; /* Khoảng cách bên trong */
            text-decoration: none; /* Xóa gạch chân */
            border-radius: 5px; /* Bo tròn góc */
        }

        .edit-button:hover {
            background-color: #45a049; /* Màu nền khi di chuột vào */
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
        /* Show dropdown on hover */
        nav ul li:hover ul {
            display: block;
        }
        
        /* Icon before each dropdown item */
        nav ul li ul li a:before {
            content: "📦"; /* Biểu tượng mẫu (có thể thay đổi tùy nhu cầu) */
            margin-right: 10px;
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
                        <li><a href="#">Đơn hàng</a></li>
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

        
    </header>
    <h2>Thông Tin Nhân Viên</h2>
    
    <div class="profile-container">
        <h3>Thông Tin Cá Nhân</h3>
        <p><strong>Mã Nhân Viên:</strong> ${nhanVien.maNhanVien}</p>
        <p><strong>Họ Tên:</strong> ${nhanVien.hoTen}</p>
        <p><strong>Giới Tính:</strong> ${nhanVien.gioiTinh}</p>
        <p><strong>Số Điện Thoại:</strong> ${nhanVien.soDienThoai}</p>
        <p><strong>Địa Chỉ:</strong> ${nhanVien.diaChi}</p>
        <p><strong>Ngày Sinh:</strong>
            <c:if test="${not empty nhanVien.ngaySinh}">
                <fmt:formatDate value="${nhanVien.ngaySinh}" pattern="dd/MM/yyyy"/>
            </c:if>
        <p><strong>Chức Vụ:</strong> ${nhanVien.chucVu}</p>
        <p><strong>Ngày Bắt Đầu:</strong>
            <c:if test="${not empty nhanVien.ngayBatDau}">
                <fmt:formatDate value="${nhanVien.ngayBatDau}" pattern="dd/MM/yyyy"/>
            </c:if>
        
        <div class="profile-actions">
            <a href="setstaff?maNhanVien=${nhanVien.maNhanVien}" class="edit-button">Cập Nhật Thông Tin</a>
        </div>
    </div>
</body>
</html>
