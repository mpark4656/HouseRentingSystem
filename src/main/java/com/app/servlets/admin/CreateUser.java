package com.app.servlets.admin;

import com.app.entities.Role;
import com.app.entities.User;
import com.app.repositories.Repository;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;

@WebServlet(urlPatterns={"/admin/create-user"})
public class CreateUser extends HttpServlet {
    @Inject
    Repository<User> userRepository;

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
            userRepository.create(user);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        response.sendRedirect(request.getContextPath() + "/admin/create-user");
    }

    private User getUserParams(HttpServletRequest request) {
        String username = request.getParameter("username").toLowerCase();
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
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
