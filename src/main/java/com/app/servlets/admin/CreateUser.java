package com.app.servlets.admin;

import com.app.entities.Role;
import com.app.entities.User;
import com.app.repositories.UserRepository;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;

@WebServlet(urlPatterns={"/admin/create-user"})
@MultipartConfig
public class CreateUser extends HttpServlet {
    @Inject
    UserRepository userRepository;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/admin/create-user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        try {
            User user = getUserParams(request);

            if(userRepository.usernameExists(user.getUsername())) {
                response.sendError(HttpServletResponse.SC_CONFLICT, "The username already exists");
                return;
            }

            if(userRepository.emailExists(user.getEmailAddress())) {
                response.sendError(HttpServletResponse.SC_CONFLICT, "The e-mail address already exists");
                return;
            }

            userRepository.create(user);
            response.setStatus(HttpServletResponse.SC_OK);
        } catch(Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private User getUserParams(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstname").toUpperCase();
        String lastName = request.getParameter("lastname").toUpperCase();
        String email = request.getParameter("email").toUpperCase();
        String[] selectedRoles = request.getParameterValues("user-roles");
        HashSet<Role> roles = new HashSet<>();

        for(String role : selectedRoles) {
            if(role.equals("administrator")) roles.add(Role.ADMINISTRATOR);
            if(role.equals("customer")) roles.add(Role.CUSTOMER);
            if(role.equals("owner")) roles.add(Role.OWNER);
        }
        return new User(username, password, roles, firstName, lastName, email);
    }
}
