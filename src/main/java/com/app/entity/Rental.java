package com.app.entity;

import com.app.entity.user.Customer;
import com.app.entity.user.Owner;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "rentals")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "date_added", nullable = false)
    private LocalDateTime dateAdded;

    @Column(nullable = false)
    private double rent;

    @Column
    private String description;

    @OneToOne
    @Column(name = "house_id", nullable = false)
    private House house;

    @ManyToOne
    @Column(name = "owner_id", nullable = false)
    private Owner owner;

    @Column(name = "customer_id")
    private Customer customer;

    @PrePersist
    void init() {
        setDateAdded(LocalDateTime.now());
    }

    public Rental() {
        setRent(0);
        setDescription(null);
        setHouse(null);
        setOwner(null);
        setCustomer(null);
    }

    public Rental(double rent, String description, House house, Owner owner) {
        setRent(rent);
        setDescription(description);
        setHouse(house);
        setOwner(owner);
        setCustomer(null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
