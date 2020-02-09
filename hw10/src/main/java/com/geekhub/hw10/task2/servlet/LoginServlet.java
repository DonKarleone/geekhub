package com.geekhub.hw10.task2.servlet;

import com.geekhub.hw10.task2.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        if (userName != null && !userName.isEmpty() && password != null && !password.isEmpty()) {
            String user = UserService.findUser(userName, password);
            if (user != null) {
                request.getSession().setAttribute("userName", user);
                response.sendRedirect(request.getContextPath() + "/feedback");
                return;
            }
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
}