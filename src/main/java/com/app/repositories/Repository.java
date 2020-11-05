package com.app.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public abstract class Repository {
    @PersistenceContext
    protected EntityManager entityManager;
}
