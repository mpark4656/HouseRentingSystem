package com.app.entity;

import com.app.entity.user.Owner;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "owner_id")
    @ManyToOne
    private Owner owner;

    @Column(name = "num_rooms")
    private int numOfRooms;

    @Column
    private String locality;

    public House() {
        setNumOfRooms(1);
        setOwner(null);
        setLocality(null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }
}
