package com.app.repositories;

import com.app.entities.House;
import java.util.List;

public class HouseRepository extends Repository {
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

    public House deleteHouseById(int id) {
        return deleteHouse(findHouseById(id));
    }

    public House findHouseById(int id) {
        return entityManager.find(House.class, id);
    }

    public List<House> getAllHouses() {
        return entityManager.createQuery("SELECT h from houses h", House.class).getResultList();
    }
}
