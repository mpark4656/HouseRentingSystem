package com.app.entity.user;

import com.app.entity.User;
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
