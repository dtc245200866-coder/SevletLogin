<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
</head>
<body>
    <h1>Đăng nhập</h1>
    <form action="login" method="post">
        <label>Username:
            <input type="text" name="username" required>
        </label>
        <br><br>
        <label>Password:
            <input type="password" name="password" required>
        </label>
        <br><br>
        <button type="submit">Đăng nhập</button>
    </form>
</body>
</html>
