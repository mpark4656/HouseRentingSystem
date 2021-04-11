package com.app.servlets.owner;

import com.app.entities.House;
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
import java.util.List;

@WebServlet(urlPatterns = {"/owner/create-rental"})
public class CreateRental extends HttpServlet {
    @Inject
    RentalRepository rentalRepository;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/owner/create-rental.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            User user = (User) request.getSession(false).getAttribute("user");

            if(!user.isAdministrator() && !user.isOwner()) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("User must be administrator or owner");
            } else {
                int numOfRooms = Integer.parseInt(request.getParameter("numOfRooms"));
                double rent = Double.parseDouble(request.getParameter("rent"));
                String locality = request.getParameter("locality");
                String description = request.getParameter("description");
                House house = new House(numOfRooms, user, locality);
                Rental rental = new Rental(rent, description, house);
                rentalRepository.create(rental);
                response.setStatus(HttpServletResponse.SC_OK);
            }
        } catch(NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Unable to parse text input to number type");
        }
    }
}
