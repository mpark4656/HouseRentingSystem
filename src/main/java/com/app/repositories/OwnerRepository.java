package com.app.repositories;

import com.app.entities.user.Owner;
import java.util.List;

public class OwnerRepository extends Repository<Owner> {
    public Owner find(int id) {
        return entityManager.find(Owner.class, id);
    }

    public List<Owner> list() {
        return entityManager.createQuery("SELECT o FROM owners o", Owner.class).getResultList();
    }
}
