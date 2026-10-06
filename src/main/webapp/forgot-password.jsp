<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- FRONTEND — view hiển thị form quên mật khẩu. Không chứa logic nghiệp vụ. --%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quên mật khẩu</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="login-card">
        <h1>Quên mật khẩu</h1>
        <p class="subtitle">Nhập tên đăng nhập để nhận hướng dẫn đặt lại mật khẩu</p>

        <form action="forgot-password" method="post">
            <div class="form-group">
                <label for="username">Tên đăng nhập</label>
                <input type="text" id="username" name="username" required
                       placeholder="Nhập tên đăng nhập">
            </div>

            <button type="submit" class="btn">Gửi yêu cầu</button>
        </form>

        <p class="auth-link"><a href="index.jsp">← Về trang đăng nhập</a></p>
    </div>
</body>
</html>
