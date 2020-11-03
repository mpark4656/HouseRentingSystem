package com.app.entities.user;

import com.app.entities.User;
import javax.persistence.Entity;

@Entity
public class Administrator extends User {
    public Administrator() {
        super();
    }

    public Administrator(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName);
    }
}
