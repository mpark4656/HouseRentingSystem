package com.app.repositories;

import com.app.entities.House;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class HouseRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public House createHouse(House house) {
        entityManager.persist(house);
        return house;
    }

    public House updateHouse(House house) {
        entityManager.merge(house);
        return house;
    }

    public House deleteHouse(House house) {
        entityManager.remove(house);
        return house;
    }

    public House findHouseById(int id) {
        return entityManager.find(House.class, id);
    }

    public List<House> getAllHouses() {
        return entityManager.createQuery("SELECT h from houses h", House.class).getResultList();
    }
}
