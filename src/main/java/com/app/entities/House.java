package com.app.entities;

import com.app.entities.user.Owner;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "houses")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JoinColumn(name = "owner_id")
    @ManyToOne
    private Owner owner;

    @Column(name = "num_rooms", nullable = false)
    @Min(0)
    private int numOfRooms;

    @Column(nullable = false)
    @NotBlank(message = "Locality must be set")
    @NotNull(message = "Locality must not be null")
    private String locality;

    public House() {
        setNumOfRooms(1);
        setOwner(null);
        setLocality(null);
    }

    public House(int numOfRooms, Owner owner, String locality) {
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

    @Override
    public int hashCode() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(!(obj instanceof House)) return false;

        House houseObj = (House) obj;
        return houseObj.id == this.id;
    }
}
