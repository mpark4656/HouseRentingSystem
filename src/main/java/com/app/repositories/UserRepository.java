package com.app.repositories;

import com.app.entities.User;
import javax.persistence.NoResultException;
import java.util.List;

public class UserRepository extends Repository<User> {
    @Override
    public User find(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> list() {
        return entityManager.createQuery("SELECT u FROM users u", User.class).getResultList();
    }

    public User findByUsername(String username) {
        try {
            if(username != null) {
                return
                    entityManager.
                        createQuery("SELECT u FROM users u WHERE lower(u.username) = :username", User.class).
                        setParameter("username", username.toLowerCase()).
                        getSingleResult();
            } else return null;
        } catch(NoResultException e) {
            return null;
        }
    }

    public boolean usernameExists(String username) {
        if(username != null) {
            List<User> users =
                    entityManager.createQuery("SELECT u FROM users u WHERE lower(u.username) = :username", User.class).
                            setParameter("username", username.toLowerCase()).
                            getResultList();

            return !users.isEmpty();
        } else return false;
    }

    public boolean emailExists(String email) {
        if(email != null) {
            List<User> users =
                    entityManager.createQuery("SELECT u FROM users u WHERE upper(u.emailAddress) = :email", User.class).
                            setParameter("email", email.toUpperCase()).
                            getResultList();

            return !users.isEmpty();
        } else return false;
    }

    public User deleteByUsername(String username) {
        User user = findByUsername(username);
        if(user != null) {
            entityManager.remove(user);
        }
        return user;
    }
}
