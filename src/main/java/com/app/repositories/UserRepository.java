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
                createQuery("SELECT u FROM users u WHERE lower(u.username) = :username", User.class).
                setParameter("username", username.toLowerCase()).
                getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }

    public boolean usernameExists(String username) {
        List<User> users =
            entityManager.createQuery("SELECT u FROM users u WHERE lower(u.username) = :username", User.class).
            setParameter("username", username.toLowerCase()).
            getResultList();

        return !users.isEmpty();
    }

    public boolean emailExists(String email) {
        List<User> users =
            entityManager.createQuery("SELECT u FROM users u WHERE upper(u.emailAddress) = :email", User.class).
                    setParameter("email", email.toUpperCase()).
                    getResultList();

        return !users.isEmpty();
    }

    public User deleteByUsername(String username) {
        User user = findByUsername(username);
        if(user != null) {
            entityManager.remove(user);
        }
        return user;
    }

    public List<User> list() {
        return entityManager.createQuery("SELECT u FROM users u", User.class).getResultList();
    }
}
