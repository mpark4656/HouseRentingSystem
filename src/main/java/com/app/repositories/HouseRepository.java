package com.app.repositories;

import com.app.entities.House;
import java.util.List;

public class HouseRepository extends Repository<House> {
    public House find(int id) {
        return entityManager.find(House.class, id);
    }

    public List<House> list() {
        return entityManager.createQuery("SELECT h from houses h", House.class).getResultList();
    }
}
