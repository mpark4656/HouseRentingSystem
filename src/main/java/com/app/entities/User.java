package com.app.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity(name = "users")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String username;

    @Column(nullable = false)
    @NotBlank
    private String password;

    @ElementCollection(targetClass = Role.class)
    @CollectionTable(name="roles", joinColumns = @JoinColumn(name="user_id"))
    @Column(nullable = false)
    @OneToMany
    @Enumerated(EnumType.STRING)
    @NotEmpty
    private Set<Role> roles;

    @Column(name = "fname", nullable = false)
    @NotBlank
    private String firstName;

    @Column(name = "lname", nullable = false)
    @NotBlank
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
