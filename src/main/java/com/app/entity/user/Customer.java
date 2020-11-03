package com.app.entity.user;

import com.app.entity.User;
import javax.persistence.Entity;

@Entity
public class Customer extends User {
    public Customer() {
        super();
    }

    public Customer(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName);
    }
}
