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
import java.io.PrintWriter;

@WebServlet(urlPatterns={"/owner/delete-rental"})
public class DeleteRental extends HttpServlet {
    @Inject
    RentalRepository rentalRepository;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            User user = (User) request.getSession(false).getAttribute("user");

            if(!user.isOwner()) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("You must be the owner to delete this rental posting");
            } else {
                int rentalId = Integer.parseInt(request.getParameter("rental-id"));
                Rental rental = rentalRepository.find(rentalId);

                if(rental == null) {
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    response.getWriter().write("Invalid Rental ID");
                    return;
                }

                User owner = rental.getHouse().getOwner();

                if(!owner.equals(user)) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.getWriter().write("You must be the owner of this rental posting to delete it");
                    return;
                }

                Rental removedRental = rentalRepository.delete(rental);

                // TODO get a proper json
                PrintWriter out = response.getWriter();
                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");
                out.print(removedRental.getId());

                response.setStatus(HttpServletResponse.SC_OK);
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write(e.getMessage());
        }
    }
}
