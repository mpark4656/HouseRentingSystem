package com.app.entities;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "users")
@Table(name = "users")
@IdClass(UserId.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Id
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ElementCollection(targetClass = Role.class)
    @CollectionTable(name="roles", joinColumns = @JoinColumn(name="user_id"))
    @Column(nullable = false)
    @OneToMany
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @Column(name = "fname", nullable = false)
    private String firstName;

    @Column(name = "lname", nullable = false)
    private String lastName;

    @Column(name= "email")
    private String emailAddress;

    public User() {
        setUsername(null);
        setPassword(null);
        setFirstName(null);
        setLastName(null);
        setEmailAddress(null);
    }

    public User(
            String username, String password, Set<Role> roles,
            String firstName, String lastName
    ) {
        setUsername(username);
        setPassword(password);
        setRoles(roles);
        setFirstName(firstName);
        setLastName(lastName);
    }

    public User(
            String username, String password, Set<Role> role,
            String firstName, String lastName, String emailAddress
    ) {
        setUsername(username);
        setPassword(password);
        setRoles(role);
        setFirstName(firstName);
        setLastName(lastName);
        setEmailAddress(emailAddress);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
