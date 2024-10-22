<%-- 
    Document   : addCustomer
    Created on : Oct 20, 2024, 3:39:19 PM
    Author     : Ngô Đắc Tuấn Kiệt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Khách Hàng Mới</title>
</head>
<body>

<h2>Thêm Khách Hàng Mới</h2>

<form action="addcustomer" method="post">
    <label for="maKhachHang">Mã Khách Hàng:</label>
    <input type="text" id="maKhachHang" name="maKhachHang" required><br><br>

    <label for="hoTen">Họ Tên:</label>
    <input type="text" id="hoTen" name="hoTen" required><br><br>

    <label for="gioiTinh">Giới Tính:</label>
    <select id="gioiTinh" name="gioiTinh" required>
        <option value="Nam">Nam</option>
        <option value="Nữ">Nữ</option>
    </select><br><br>

    <label for="soDienThoai">Số Điện Thoại:</label>
    <input type="text" id="soDienThoai" name="soDienThoai" required><br><br>

    <label for="diaChi">Địa Chỉ:</label>
    <input type="text" id="diaChi" name="diaChi" required><br><br>

    <label for="ngaySinh">Ngày Sinh:</label>
    <input type="date" id="ngaySinh" name="ngaySinh" required><br><br>

    <input type="submit" value="Thêm">
</form>

</body>
</html>

