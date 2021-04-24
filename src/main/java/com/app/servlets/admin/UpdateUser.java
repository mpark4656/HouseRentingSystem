package com.app.servlets.admin;

import com.app.entities.Role;
import com.app.entities.User;
import com.app.repositories.UserRepository;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;

@WebServlet(urlPatterns={"/admin/update-user"})
public class UpdateUser extends HttpServlet {
    @Inject
    private UserRepository userRepository;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String firstName = request.getParameter("firstName").toUpperCase();
        String lastName = request.getParameter("lastName").toUpperCase();
        String emailAddress = request.getParameter("emailAddress").toUpperCase();
        boolean isOwner = Boolean.parseBoolean(request.getParameter("owner"));
        boolean isAdmin = Boolean.parseBoolean(request.getParameter("administrator"));
        boolean isCustomer = Boolean.parseBoolean(request.getParameter("customer"));

        User user = userRepository.findByUsername(username);
        HashSet<Role> userRoles = new HashSet<>();
        if(isAdmin) userRoles.add(Role.ADMINISTRATOR);
        if(isOwner) userRoles.add(Role.OWNER);
        if(isCustomer) userRoles.add(Role.CUSTOMER);

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmailAddress(emailAddress);
        user.setRoles(userRoles);

        try {
            userRepository.update(user);
            response.setStatus(HttpServletResponse.SC_OK);
        } catch(Exception e) {
            System.err.println(e.getMessage());
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
