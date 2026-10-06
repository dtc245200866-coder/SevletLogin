package com.codegym;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * BACKEND — Controller xử lý nghiệp vụ đăng nhập (/login).
 *
 * Servlet chỉ làm nhiệm vụ backend:
 *   1. Nhận username/password từ request.
 *   2. Kiểm tra thông tin đăng nhập (qua UserStore).
 *   3. Đặt kết quả vào request scope và forward sang JSP (frontend) để hiển thị.
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (UserStore.check(username, password)) {
            request.setAttribute("status", "success");
            request.setAttribute("message", "Welcome " + username + " to website");
            request.setAttribute("backLabel", "Về trang đăng nhập");
            request.setAttribute("backUrl", "index.jsp");
        } else {
            request.setAttribute("status", "error");
            request.setAttribute("message", "Login Error");
            request.setAttribute("backLabel", "Thử lại");
            request.setAttribute("backUrl", "index.jsp");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
        dispatcher.forward(request, response);
    }
}
