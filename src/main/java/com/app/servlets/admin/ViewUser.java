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
import java.util.List;

@WebServlet(urlPatterns = {"/admin/view-user"})
public class ViewUser extends HttpServlet {
    @Inject
    UserRepository userRepository;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<User> users = userRepository.list();
        request.setAttribute("users", users);
        request.getRequestDispatcher("/admin/view-user.jsp").forward(request, response);
    }
}
