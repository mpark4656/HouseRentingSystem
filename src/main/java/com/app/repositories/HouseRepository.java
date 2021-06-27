package com.app.repositories;

import com.app.entities.House;
import java.util.List;

public class HouseRepository extends Repository<House> {
    @Override
    public House find(int id) {
        return entityManager.find(House.class, id);
    }

    @Override
    public List<House> list() {
        return entityManager.createQuery("SELECT h from houses h", House.class).getResultList();
    }
}
