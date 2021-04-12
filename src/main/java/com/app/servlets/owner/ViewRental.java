package com.app.servlets.owner;

import com.app.entities.Rental;
import com.app.entities.User;
import com.app.repositories.RentalRepository;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(urlPatterns = {"/owner/view-rental"})
public class ViewRental extends HttpServlet {
    @Inject
    private RentalRepository rentalRepository;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession(false).getAttribute("user");

        if(user.isOwner()) {
            List<Rental> rentals = rentalRepository.getRentalsByUser(user);
            request.setAttribute("rentals", rentals);
            request.setAttribute(
                    "dateTimeFormatter",
                    DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm a"));
            request.getRequestDispatcher("/owner/view-rental.jsp").forward(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Must be owner to view the rentals");
        }
    }
}
