package com.app.repositories;

import com.app.entities.Rental;
import com.app.entities.User;
import java.util.List;

public class RentalRepository extends Repository<Rental> {
    @Override
    public Rental find(int id) {
        return entityManager.find(Rental.class, id);
    }

    @Override
    public List<Rental> list() {
        return entityManager.createQuery("SELECT r FROM rentals r", Rental.class).getResultList();
    }

    public List<Rental> getRentalsByUser(User user) {
        if(user != null) {
            return entityManager.createQuery(
                    "SELECT r FROM rentals r WHERE r.house IN (SELECT h FROM houses h WHERE h.owner = :user)",
                    Rental.class).setParameter("user", user).getResultList();
        } else return null;
    }

    public List<Rental> getAllAvailableRentals() {
        return entityManager.createQuery(
            "SELECT r FROM rentals r WHERE r.customer IS NULL",
                Rental.class
        ).getResultList();
    }
}
