package com.app.entities.user;

import com.app.entities.User;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "customers")
@Table(name = "customers")
public class Customer extends User {
    public Customer() {
        super();
    }

    public Customer(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName);
    }
}
