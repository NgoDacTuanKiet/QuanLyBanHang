<%-- 
    Document   : addGoods
    Created on : Oct 20, 2024, 11:20:44 PM
    Author     : Ngô Đắc Tuấn Kiệt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Sản Phẩm Mới</title>
</head>
<body>

<h2>Thêm Sản Phẩm Mới</h2>

<form action="addgoods" method="post">
    <label for="maSanPham">Mã Sản Phẩm:</label>
    <input type="text" id="maSanPham" name="maSanPham" required><br><br>

    <label for="tenSanPham">Tên Sản Phẩm:</label>
    <input type="text" id="tenSanPham" name="tenSanPham" required><br><br>

    <label for="loaiSanPham">Loại Sản Phẩm:</label>
    <input type="text" id="loaiSanPham" name="loaiSanPham" required><br><br>

    <label for="kichCo">Kích Cỡ:</label>
    <input type="text" id="kichCo" name="kichCo" required><br><br>

    <label for="mauSac">Màu Sắc:</label>
    <input type="text" id="mauSac" name="mauSac" required><br><br>

    <label for="giaMua">Giá Mua:</label>
    <input type="number" id="giaMua" name="giaMua" required><br><br>

    <label for="giaBan">Giá Bán:</label>
    <input type="number" id="giaBan" name="giaBan" required><br><br>

    <label for="soLuongTonKho">Số Lượng Tồn Kho:</label>
    <input type="number" id="soLuongTonKho" name="soLuongTonKho" required><br><br>

    <input type="submit" value="Thêm">
</form>

</body>
</html>
