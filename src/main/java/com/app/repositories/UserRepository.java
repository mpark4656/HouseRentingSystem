package com.app.repositories;

import com.app.entities.User;
import java.util.List;

public class UserRepository extends Repository<User> {
    public User find(int id) {
        return entityManager.find(User.class, id);
    }

    public List<User> list() {
        return entityManager.createQuery("SELECT u FROM users u", User.class).getResultList();
    }
}
