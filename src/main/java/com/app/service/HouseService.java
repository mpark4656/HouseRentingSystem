package com.app.service;

import com.app.entity.House;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class HouseService {

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

    public House findHouseById(int id) {
        return entityManager.find(House.class, id);
    }

    public List<House> getAllHouses() {
        return entityManager.createQuery("SELECT h from house h", House.class).getResultList();
    }
}
