package com.codegym;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet xử lý request POST từ form đăng nhập (/login).
 * Nếu username và password đều là "admin" -> in "Welcome admin to website".
 * Ngược lại -> in "Login Error".
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html; charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"vi\">");
            out.println("<head>");
            out.println("    <meta charset=\"UTF-8\">");
            out.println("    <title>Kết quả đăng nhập</title>");
            out.println("</head>");
            out.println("<body>");

            if ("admin".equals(username) && "admin".equals(password)) {
                out.println("    <h1>Welcome admin to website</h1>");
            } else {
                out.println("    <h1>Login Error</h1>");
            }

            out.println("    <p><a href=\"index.jsp\">← Về trang đăng nhập</a></p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
