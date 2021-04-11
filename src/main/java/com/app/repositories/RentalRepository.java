package com.app.repositories;

import com.app.entities.Rental;
import com.app.entities.User;
import java.util.List;

public class RentalRepository extends Repository<Rental> {
    public Rental find(int id) {
        return entityManager.find(Rental.class, id);
    }

    public List<Rental> list() {
        return entityManager.createQuery("SELECT r FROM rentals r", Rental.class).getResultList();
    }

    public List<Rental> getRentalsByUser(User user) {
        String username = user.getUsername();
        return entityManager.createQuery(
                "SELECT r FROM rentals r WHERE r.house IN (SELECT h FROM houses h WHERE h.owner = :user)",
                Rental.class).setParameter("user", user).getResultList();
    }
}
