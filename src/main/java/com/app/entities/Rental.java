package com.app.entities;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Entity(name = "rentals")
@Table(name = "rentals")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "date_added", nullable = false)
    @JsonbDateFormat("yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateAdded;

    @Column(nullable = false)
    @Min(0)
    private double rent;

    @Column
    private String description;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "house_id", nullable = false)
    private House house;

    @JoinColumn(name = "customer_id")
    private User customer;

    @PrePersist
    void init() {
        setDateAdded(LocalDateTime.now());
    }

    public Rental() {
        setRent(0);
        setDescription(null);
        setHouse(null);
        setCustomer(null);
    }

    public Rental(double rent, String description, House house) {
        setRent(rent);
        setDescription(description);
        setHouse(house);
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

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }
}
