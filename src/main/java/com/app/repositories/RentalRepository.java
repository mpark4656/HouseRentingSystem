package com.app.repositories;

import com.app.entities.Rental;

import java.util.List;

public class RentalRepository extends Repository {
    public Rental createRental(Rental rental) {
        entityManager.persist(rental);
        return rental;
    }

    public Rental updateRental(Rental rental) {
        entityManager.merge(rental);
        return rental;
    }

    public Rental deleteRental(Rental rental) {
        entityManager.remove(rental);
        return rental;
    }

    public Rental deleteRentalById(int id) {
        return deleteRental(findRentalById(id));
    }

    public Rental findRentalById(int id) {
        return entityManager.find(Rental.class, id);
    }

    public List<Rental> getAllRentals() {
        return entityManager.createQuery("SELECT r FROM rentals r", Rental.class).getResultList();
    }
}
