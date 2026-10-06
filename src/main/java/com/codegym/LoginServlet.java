package com.codegym;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * BACKEND — Controller xử lý nghiệp vụ đăng nhập.
 *
 * Servlet chỉ làm nhiệm vụ backend:
 *   1. Nhận username/password từ request.
 *   2. Kiểm tra thông tin đăng nhập (nghiệp vụ).
 *   3. Đặt kết quả vào request scope và forward sang JSP (frontend) để hiển thị.
 *
 * Servlet KHÔNG tự sinh HTML nữa — phần giao diện nằm hoàn toàn ở frontend.
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Nghiệp vụ: kiểm tra thông tin đăng nhập
        boolean success = USERNAME.equals(username) && PASSWORD.equals(password);

        // Đặt kết quả vào request scope để frontend (result.jsp) hiển thị
        if (success) {
            request.setAttribute("status", "success");
            request.setAttribute("message", "Welcome admin to website");
        } else {
            request.setAttribute("status", "error");
            request.setAttribute("message", "Login Error");
        }

        // Forward sang view — backend không tự in HTML
        RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
        dispatcher.forward(request, response);
    }
}
