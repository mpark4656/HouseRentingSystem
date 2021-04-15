package com.app.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public abstract class Repository<T> {
    @PersistenceContext
    protected EntityManager entityManager;

    public T create(T t) {
        entityManager.persist(t);
        return t;
    }

    public T update(T t) {
        return entityManager.merge(t);
    }

    public T delete(T t) {
        entityManager.remove(attach(t));
        return t;
    }

    public T deleteById(int id) {
        return delete(find(id));
    }

    abstract public T attach(T t);

    abstract public T find(int id);

    abstract public List<T> list();
}
