<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- FRONTEND — view hiển thị kết quả đăng nhập.
     Nhận dữ liệu từ backend (LoginServlet) qua request scope bằng EL. --%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Kết quả đăng nhập</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="result-card ${status}">
        <h1>${message}</h1>
        <a href="index.jsp" class="btn btn-link">← Về trang đăng nhập</a>
    </div>
</body>
</html>
