package com.app.servlets.admin;

import com.app.entities.Rental;
import com.app.entities.User;
import com.app.repositories.RentalRepository;
import com.app.repositories.UserRepository;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/delete-user"})
public class DeleteUser extends HttpServlet {
    @Inject
    private UserRepository userRepository;

    @Inject
    private RentalRepository rentalRepository;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User loggedInUser = (User) request.getSession(false).getAttribute("user");
        String username = request.getParameter("username");

        if(username.equals(loggedInUser.getUsername())) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("Unable to delete your own account");
        } else if(loggedInUser.isAdministrator()) {
            cascadeDeleteUserRentals(username);
            userRepository.deleteByUsername(username);
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("You are not authorized to delete an account");
        }
    }

    private void cascadeDeleteUserRentals(String username) {
        User user = userRepository.findByUsername(username);
        List<Rental> rentals = rentalRepository.getRentalsByUser(user);
        for(Rental rental : rentals) {
            rentalRepository.delete(rental);
        }
    }
}
