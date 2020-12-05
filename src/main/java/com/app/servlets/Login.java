package com.app.servlets;

import com.app.entities.User;
import com.app.security.UserAuthentication;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class Login extends HttpServlet {
    @Inject
    UserAuthentication userAuthentication;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if(session != null) {
            User user = (User) session.getAttribute("user");
            if(user != null) {
                response.sendRedirect("/home");
                return;
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userAuthentication.authenticate(username, password);

        if(user != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            response.sendRedirect("home");
        } else {
            response.sendRedirect("login?err=true");
        }
    }
}
