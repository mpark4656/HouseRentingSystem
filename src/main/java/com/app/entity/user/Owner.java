package com.app.entity.user;

import com.app.entity.User;
import javax.persistence.Entity;

@Entity
public class Owner extends User {

    public Owner() {
        super();
    }

    public Owner(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName);
    }
}
