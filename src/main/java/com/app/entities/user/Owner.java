package com.app.entities.user;

import com.app.entities.User;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "owners")
@Table(name = "owners")
public class Owner extends User {

    public Owner() {
        super();
    }

    public Owner(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName);
    }
}
