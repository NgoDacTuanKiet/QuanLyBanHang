<%@page import="model.DangNhap"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cửa Hàng Đơn Giản</title>
    <link rel="stylesheet" href="style1.css">
</head>
<body>
    <header>
            <%
              // Lấy thông tin taiKhoan từ session
                DangNhap taiKhoan = (DangNhap) session.getAttribute("taiKhoan");
       
                if (taiKhoan != null) {
            %>
            <nav>
                <ul>
                    <li><a href="#">Tổng quan</a></li>
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
                <!-- Hiển thị thông tin tài khoản và link tới trang profile -->
                <a href="#">Tài khoản</a>
                <ul class="account-dropdown">
                    <li><a href="profile">Thông tin</a></li>
                    <li><a href="login">Đăng xuất</a></li>
                </ul>
            </div>
            <%
                } else {
            %>
            <nav>
                <ul>
                    <li><a href="#">Tổng quan</a></li>
                    <li>
                        <a href="#">Hàng hóa</a>
                        <ul>
                            <li><a href="login">Danh mục</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">Giao dịch</a>
                        <ul>
                            <li><a href="login">Hóa Đơn</a></li>
                            <li><a href="login">Nhập hàng</a></li>
                            <li><a href="login">Lịch sử giao dịch</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">Khách hàng</a>
                        <ul>
                            <li><a href="login">Danh sách khách hàng</a></li>
                        </ul>
                    </li>

                </ul>
            </nav>
            <div class="account">
                <!-- Nếu người dùng chưa đăng nhập, hiển thị link đăng nhập -->
                <a href="login.jsp">Đăng nhập</a>
                <a href="signup">Đăng ký</a>
            </div>
            <%
                }
            %>
    </header>

    <div class="container">
        <h1>Trang chủ</h1>
        <!-- Nội dung trang ở đây -->
    </div>
</body>
</html>
