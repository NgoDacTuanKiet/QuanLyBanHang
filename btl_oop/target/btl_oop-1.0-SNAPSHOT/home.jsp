<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cửa Hàng Đơn Giản</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            display: flex;
            min-height: 100vh;
            flex-direction: column;
        }
        header {
            background-color: #333;
            color: #fff;
            width: 250px;
            height: 100vh;
            position: fixed;
            top: 0;
            left: 0;
            padding-top: 20px;
        }
        header h1 {
            text-align: center;
            margin-bottom: 20px;
        }
        nav ul {
            list-style: none;
            padding: 0;
        }
        nav ul li {
            margin: 20px 0;
            text-align: center;
        }
        nav ul li a {
            color: #fff;
            text-decoration: none;
            padding: 10px 0;
            display: block;
        }
        nav ul li a:hover {
            background-color: #555;
        }
        .container {
            margin-left: 250px;
            padding: 20px;
            flex-grow: 1;
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
        }
        .product {
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
            margin: 10px;
            width: calc(30% - 20px); /* Tính toán để đảm bảo 3 sản phẩm trên mỗi hàng */
            padding: 15px;
            text-align: center;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .product img {
            max-width: 100%;
            height: auto;
        }
        .product h3 {
            font-size: 18px;
            margin: 10px 0;
        }
        .product p {
            color: #f00;
            font-size: 16px;
            margin: 5px 0;
        }
        .product button {
            background-color: #28a745;
            color: white;
            padding: 10px 15px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }
        .product button:hover {
            background-color: #218838;
        }
        footer {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 10px;
            margin-top: auto;
            width: 100%;
        }
    </style>
</head>
<body>
    <header>
        <h1>Cửa Hàng</h1>
        <nav>
            <ul>
                <li><a href="#">Quản lý sản phẩm</a></li>
                <li><a href="#">Quản lý đơn hàng</a></li>
                <li><a href="#">Quản lý khách hàng</a></li>
                <li><a href="#">Quản lý thanh toán</a></li>
                <li><a href="#">Doanh số</a></li>
                <li><a href="#">Đăng xuất</a></li>
            </ul>
        </nav>
    </header>

    <div class="container">
        <!-- Sản phẩm 1 -->
        <div class="product">
            <img src="https://via.placeholder.com/200" alt="Sản phẩm 1">
            <h3>Sản phẩm 1</h3>
            <p>Giá: 500,000 VND</p>
            <button>Mua ngay</button>
        </div>

        <!-- Sản phẩm 2 -->
        <div class="product">
            <img src="https://via.placeholder.com/200" alt="Sản phẩm 2">
            <h3>Sản phẩm 2</h3>
            <p>Giá: 300,000 VND</p>
            <button>Mua ngay</button>
        </div>

        <!-- Sản phẩm 3 -->
        <div class="product">
            <img src="https://via.placeholder.com/200" alt="Sản phẩm 3">
            <h3>Sản phẩm 3</h3>
            <p>Giá: 250,000 VND</p>
            <button>Mua ngay</button>
        </div>

        <!-- Sản phẩm 4 -->
        <div class="product">
            <img src="https://via.placeholder.com/200" alt="Sản phẩm 4">
            <h3>Sản phẩm 4</h3>
            <p>Giá: 450,000 VND</p>
            <button>Mua ngay</button>
        </div>

        <!-- Sản phẩm 5 -->
        <div class="product">
            <img src="https://via.placeholder.com/200" alt="Sản phẩm 5">
            <h3>Sản phẩm 5</h3>
            <p>Giá: 350,000 VND</p>
            <button>Mua ngay</button>
        </div>

        <!-- Sản phẩm 6 -->
        <div class="product">
            <img src="https://via.placeholder.com/200" alt="Sản phẩm 6">
            <h3>Sản phẩm 6</h3>
            <p>Giá: 400,000 VND</p>
            <button>Mua ngay</button>
        </div>
    </div>

    <footer>
        <p>&copy; 2024 Cửa Hàng Đơn Giản. Mọi quyền được bảo lưu.</p>
    </footer>
</body>
</html>
