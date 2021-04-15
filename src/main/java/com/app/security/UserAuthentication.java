package com.app.security;

import com.app.entities.Role;
import com.app.entities.User;
import com.app.repositories.UserRepository;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class UserAuthentication {
    @Inject
    private UserRepository userRepository;

    @Inject
    private PasswordHash passwordHash;

    public static final String ROOT_USERNAME = "root";
    private static final String ROOT_PASSWORD = "password";
    private static final String ROOT_EMAIL = "root@app.com";

    public User authenticate(String username, String password) {
        if(username == null || password == null) return null;

        // @Issue: What if another administrator create an account with the same root email address?
        if(username.equals(ROOT_USERNAME) && password.equals(ROOT_PASSWORD)) {
            if(!userRepository.usernameExists(ROOT_USERNAME) && !userRepository.emailExists(ROOT_EMAIL))
                return createRootUser();
        }

        User user = userRepository.findByUsername(username);
        if(user != null && user.getPassword().equals(passwordHash.hash(password))) return user;

        return null;
    }

    private User createRootUser() {
        try {
            Set<Role> roleSet = new HashSet<>();
            roleSet.add(Role.ADMINISTRATOR);
            roleSet.add(Role.CUSTOMER);
            roleSet.add(Role.OWNER);

            User user = new User(
                    ROOT_USERNAME,
                    passwordHash.hash(ROOT_PASSWORD),
                    roleSet,
                    "ROOT",
                    "ADMIN",
                    ROOT_EMAIL.toUpperCase()
            );
            return userRepository.create(user);
        } catch(Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
