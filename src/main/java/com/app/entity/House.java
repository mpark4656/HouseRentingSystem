package com.app.entity;

import java.util.UUID;

public class House {
    private String id = UUID.randomUUID().toString();
    private String ownerId;
    private int numOfRooms;
    private String locality;

    public House() {
        numOfRooms = 1;
        ownerId = null;
        locality = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
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
