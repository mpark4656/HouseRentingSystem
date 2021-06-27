package com.app.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Objects;

@Entity(name = "houses")
@Table(name = "houses")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JoinColumn(name = "owner_id", nullable = false)
    @ManyToOne(cascade = CascadeType.REFRESH)
    private User owner;

    @Min(0)
    @Column(name = "num_rooms", nullable = false)
    private int numOfRooms;

    @Column(nullable = false)
    private String locality;

    public House() {
        setNumOfRooms(1);
        setOwner(null);
        setLocality(null);
    }

    public House(int numOfRooms, User owner, String locality) {
        setNumOfRooms(numOfRooms);
        setOwner(owner);
        setLocality(locality);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
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

    @Override
    public int hashCode() {
        return Objects.hash(id, owner, numOfRooms, locality);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;

        House house = (House) obj;
        return Objects.equals(id, house.id) &&
                Objects.equals(owner, house.owner) &&
                Objects.equals(numOfRooms, house.numOfRooms) &&
                Objects.equals(locality, house.locality);
    }

    @Override
    public String toString() {
        // TODO Implement this
        return null;
    }
}