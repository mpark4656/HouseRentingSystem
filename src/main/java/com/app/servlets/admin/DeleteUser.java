package com.app.servlets.admin;

import com.app.entities.User;
import com.app.repositories.UserRepository;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin/delete-user"})
public class DeleteUser extends HttpServlet {
    @Inject
    private UserRepository userRepository;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession(false).getAttribute("user");
        String username = request.getParameter("username");

        if(username.equals(user.getUsername())) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("Unable to delete your own account");
        } else if(user.isAdministrator()) {
            System.out.println(username);
            userRepository.deleteByUsername(username);
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("You are not authorized to delete an account");
        }
    }
}
