<%-- 
    Document   : SignUp
    Created on : Oct 18, 2024, 6:50:09 PM
    Author     : Ngô Đắc Tuấn Kiệt
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up</title>
        <style>
            body {
                font-family: 'Arial', sans-serif;
                background-color: #f7f7f7;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
            }
            form {
                background-color: white;
                padding: 30px;
                border-radius: 10px;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
                width: 350px;
            }
            h3 {
                margin-bottom: 10px;
                font-size: 16px;
                color: #333;
            }
            input[type="text"], input[type="password"] {
                width: 100%;
                padding: 12px;
                margin-bottom: 20px;
                border: 1px solid #ccc;
                border-radius: 5px;
                font-size: 14px;
                box-sizing: border-box;
                transition: all 0.3s ease;
            }
            input[type="text"]:focus, input[type="password"]:focus {
                border-color: #28a745;
                box-shadow: 0 0 5px rgba(40, 167, 69, 0.5);
                outline: none;
            }
            input[type="submit"] {
                width: 100%;
                background-color: #28a745;
                color: white;
                padding: 12px;
                border: none;
                border-radius: 5px;
                font-size: 16px;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }
            input[type="submit"]:hover {
                background-color: #218838;
            }
            a {
                text-decoration: none;
                color: #007bff;
                font-size: 14px;
                display: inline-block;
                margin-top: 10px;
                transition: color 0.3s ease;
            }
            a:hover {
                color: #0056b3;
                text-decoration: underline;
            }
            .form-title {
                text-align: center;
                font-size: 24px;
                color: #333;
                margin-bottom: 20px;
            }
        </style>
    </head>
    <body>
        <form action="signup" method="post">
            <div class="form-title">Đăng Ký</div>
            
            <h3>Tài khoản:</h3> 
            <input type="text" name="taiKhoan" placeholder="Nhập tài khoản" required><br>
            
            <h3>Mật khẩu:</h3> 
            <input type="password" name="matKhau" placeholder="Nhập mật khẩu" required><br>
            
            <h3>Xác nhận mật khẩu:</h3> 
            <input type="password" name="xacNhan" placeholder="Nhập lại mật khẩu" required><br>
            
            <c:if test="${not empty errorMessage1}">
                <p style="color: red"> ${errorMessage1}</p>
            </c:if>
            
            <c:if test="${not empty errorMessage2}">
                <p style="color: red"> ${errorMessage2}</p>
            </c:if>
            
            <input type="submit" value="Đăng Ký">
        </form>
    </body>
</html>

