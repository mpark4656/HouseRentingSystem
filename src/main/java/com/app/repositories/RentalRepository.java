package com.app.repositories;

import com.app.entities.Rental;
import java.util.List;

public class RentalRepository extends Repository<Rental> {
    public Rental find(int id) {
        return entityManager.find(Rental.class, id);
    }

    public List<Rental> list() {
        return entityManager.createQuery("SELECT r FROM rentals r", Rental.class).getResultList();
    }
}
