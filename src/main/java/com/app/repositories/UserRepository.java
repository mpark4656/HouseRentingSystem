package com.app.repositories;

import com.app.entities.User;

import javax.persistence.NoResultException;
import java.util.List;

public class UserRepository extends Repository<User> {
    public User find(int id) {
        return entityManager.find(User.class, id);
    }

    public User findByUsername(String username) {
        try {
            return
                entityManager.
                createQuery("SELECT u FROM users u WHERE u.username = :username", User.class).
                setParameter("username", username).
                getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }

    public boolean usernameExists(String username) {
        List<User> users =
            entityManager.createQuery("SELECT u FROM users u WHERE u.username = :username", User.class).
            setParameter("username", username).
            getResultList();

        return !users.isEmpty();
    }

    public boolean emailExists(String email) {
        List<User> users =
                entityManager.createQuery("SELECT u FROM users u WHERE u.email = :email", User.class).
                        setParameter("email", email).
                        getResultList();

        return !users.isEmpty();
    }

    public List<User> list() {
        return entityManager.createQuery("SELECT u FROM users u", User.class).getResultList();
    }
}
