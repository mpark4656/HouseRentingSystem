package com.app.servlets.customer;

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
import java.time.format.DateTimeFormatter;

@WebServlet(urlPatterns = {"/customer/browse-rental"})
public class BrowseRental extends HttpServlet {
    @Inject
    RentalRepository rentalRepository;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User loggedInUser = (User) request.getSession(false).getAttribute("user");

        if(loggedInUser.isCustomer()) {
            request.setAttribute("rentals", rentalRepository.getAllAvailableRentals());
            request.setAttribute(
                    "dateTimeFormatter",
                    DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm a"));
            request.getRequestDispatcher("/customer/browse-rental.jsp").forward(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
