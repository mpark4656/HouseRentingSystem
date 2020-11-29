package com.app.servlets;

import com.app.entities.Role;
import com.app.entities.User;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet(urlPatterns = {"/login"})
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username != null && password != null &&
                username.equals("mpark") && password.equals("password")
        ) {
            Set<Role> roleSet = new HashSet<>();
            roleSet.add(Role.ADMINISTRATOR);
            roleSet.add(Role.CUSTOMER);
            roleSet.add(Role.OWNER);

            User user = new User(username, password, roleSet, "Michael", "Park");
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);

            response.sendRedirect("home");
        } else {
            response.sendRedirect("login-error.jsp");
        }
    }
}
