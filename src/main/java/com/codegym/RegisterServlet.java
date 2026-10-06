package com.codegym;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * BACKEND — Controller xử lý đăng ký tài khoản (/register).
 * Chỉ làm nghiệp vụ, forward kết quả sang view (result.jsp).
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = trim(request.getParameter("username"));
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirmPassword");

        if (username.isEmpty()) {
            error(request, "Tên đăng nhập không được để trống");
        } else if (password == null || password.length() < 6) {
            error(request, "Mật khẩu phải có ít nhất 6 ký tự");
        } else if (!password.equals(confirm)) {
            error(request, "Mật khẩu nhập lại không khớp");
        } else if (UserStore.exists(username)) {
            error(request, "Tên đăng nhập đã tồn tại");
        } else if (UserStore.register(username, password)) {
            request.setAttribute("status", "success");
            request.setAttribute("message", "Đăng ký thành công! Hãy đăng nhập.");
            request.setAttribute("backLabel", "Về trang đăng nhập");
            request.setAttribute("backUrl", "index.jsp");
        } else {
            error(request, "Đăng ký thất bại, vui lòng thử lại");
        }

        forward(request, response, "/result.jsp");
    }

    private void error(HttpServletRequest request, String message) {
        request.setAttribute("status", "error");
        request.setAttribute("message", message);
        request.setAttribute("backLabel", "Thử lại");
        request.setAttribute("backUrl", "register.jsp");
    }

    private String trim(String value) {
        return value == null ? "" : value.trim();
    }

    private void forward(HttpServletRequest request, HttpServletResponse response, String path)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }
}
