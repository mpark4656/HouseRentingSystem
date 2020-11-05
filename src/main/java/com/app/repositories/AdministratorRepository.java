package com.app.repositories;

import com.app.entities.user.Administrator;
import java.util.List;

public class AdministratorRepository extends Repository<Administrator> {
    public Administrator find(int id) {
        return entityManager.find(Administrator.class, id);
    }

    public List<Administrator> list() {
        return entityManager.createQuery("SELECT a FROM administrators a", Administrator.class).getResultList();
    }
}
