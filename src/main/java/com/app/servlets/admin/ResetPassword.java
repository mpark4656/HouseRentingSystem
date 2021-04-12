package com.app.servlets.admin;

import com.app.entities.User;
import com.app.repositories.UserRepository;
import com.app.security.UserAuthentication;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns={"/admin/reset-password"})
public class ResetPassword extends HttpServlet {
    @Inject
    private UserRepository userRepository;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        User loggedInUser = (User) session.getAttribute("user");
        String username = request.getParameter("username");
        String newPassword = request.getParameter("password");
        User user = userRepository.findByUsername(username);

        if(loggedInUser.isAdministrator()) {
            if(!user.getUsername().equals(UserAuthentication.ROOT_USERNAME)) {
                user.setPassword(newPassword);
                userRepository.update(user);
                response.setStatus(HttpServletResponse.SC_OK);
            } else {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                response.getWriter().write("Root account's password cannot be reset");
            }
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Not an administrator");
        }
    }
}