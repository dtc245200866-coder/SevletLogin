<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- FRONTEND — view hiển thị form đăng nhập. Không chứa logic nghiệp vụ. --%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="login-card">
        <h1>Đăng nhập</h1>
        <p class="subtitle">Hệ thống Servlet Login</p>

        <form action="login" method="post">
            <div class="form-group">
                <label for="username">Tên đăng nhập</label>
                <input type="text" id="username" name="username" required
                       placeholder="Nhập tên đăng nhập">
            </div>

            <div class="form-group">
                <label for="password">Mật khẩu</label>
                <input type="password" id="password" name="password" required
                       placeholder="Nhập mật khẩu">
            </div>

            <button type="submit" class="btn">Đăng nhập</button>
        </form>

        <p class="hint">Gợi ý: admin / admin</p>
    </div>
</body>
</html>
