<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- FRONTEND — view hiển thị form đăng ký. Không chứa logic nghiệp vụ. --%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng ký</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="login-card">
        <h1>Đăng ký</h1>
        <p class="subtitle">Tạo tài khoản mới</p>

        <form action="register" method="post">
            <div class="form-group">
                <label for="username">Tên đăng nhập</label>
                <input type="text" id="username" name="username" required
                       placeholder="Nhập tên đăng nhập">
            </div>

            <div class="form-group">
                <label for="password">Mật khẩu</label>
                <input type="password" id="password" name="password" required
                       placeholder="Ít nhất 6 ký tự">
            </div>

            <div class="form-group">
                <label for="confirmPassword">Nhập lại mật khẩu</label>
                <input type="password" id="confirmPassword" name="confirmPassword" required
                       placeholder="Nhập lại mật khẩu">
            </div>

            <button type="submit" class="btn">Đăng ký</button>
        </form>

        <p class="auth-link">Đã có tài khoản? <a href="index.jsp">Đăng nhập</a></p>
    </div>
</body>
</html>
