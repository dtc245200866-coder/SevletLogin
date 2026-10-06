package com.codegym;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * BACKEND — Controller xử lý quên mật khẩu (/forgot-password).
 * Demo: chỉ kiểm tra tài khoản có tồn tại và trả thông báo tương ứng.
 */
@WebServlet(name = "ForgotPasswordServlet", urlPatterns = {"/forgot-password"})
public class ForgotPasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String trimmed = username == null ? "" : username.trim();

        if (trimmed.isEmpty()) {
            request.setAttribute("status", "error");
            request.setAttribute("message", "Vui lòng nhập tên đăng nhập");
            request.setAttribute("backLabel", "Thử lại");
            request.setAttribute("backUrl", "forgot-password.jsp");
        } else if (UserStore.exists(trimmed)) {
            request.setAttribute("status", "success");
            request.setAttribute("message", "Đã gửi hướng dẫn đặt lại mật khẩu (demo). Vui lòng kiểm tra email.");
            request.setAttribute("backLabel", "Về trang đăng nhập");
            request.setAttribute("backUrl", "index.jsp");
        } else {
            request.setAttribute("status", "error");
            request.setAttribute("message", "Không tìm thấy tài khoản với tên đăng nhập này");
            request.setAttribute("backLabel", "Thử lại");
            request.setAttribute("backUrl", "forgot-password.jsp");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
        dispatcher.forward(request, response);
    }
}
