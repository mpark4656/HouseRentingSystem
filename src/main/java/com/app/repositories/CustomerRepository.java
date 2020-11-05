package com.app.repositories;

import com.app.entities.user.Customer;
import java.util.List;

public class CustomerRepository extends Repository<Customer> {
    public Customer find(int id) {
        return entityManager.find(Customer.class, id);
    }

    public List<Customer> list() {
        return entityManager.createQuery("SELECT c FROM customers c", Customer.class).getResultList();
    }
}
