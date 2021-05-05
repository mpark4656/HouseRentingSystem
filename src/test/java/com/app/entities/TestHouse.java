package com.app.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestHouse {
    private House defaultHouse;
    private House parameterizedHouseOne;
    private House parameterizedHouseTwo;
    private House parameterizedHouseThree;

    private User ownerOne;
    private User ownerTwo;
    private User ownerThree;

    final private String localityOne = "Arlington, VA";
    final private String localityTwo = "Dulles, VA";
    final private String localityThree = "LA, CA";

    final private int numOfRoomsOne = 2;
    final private int numOfRoomsTwo = 3;
    final private int numOfRoomsThree = 4;

    final private int idOne = 1;
    final private int idTwo = 2;
    final private int idThree = 3;

    @BeforeEach
    void initEach() {
        ownerOne = new User();
        ownerOne.setId(idOne);
        ownerTwo = new User();
        ownerTwo.setId(idTwo);
        ownerThree = new User();
        ownerThree.setId(idThree);
        
        defaultHouse = new House();
        defaultHouse.setId(idOne);
        parameterizedHouseOne = new House(numOfRoomsOne, ownerOne, localityOne);
        parameterizedHouseOne.setId(idOne);
        parameterizedHouseTwo = new House(numOfRoomsTwo, ownerTwo, localityTwo);
        parameterizedHouseTwo.setId(idTwo);
        parameterizedHouseThree = new House(numOfRoomsThree, ownerThree, localityThree);
        parameterizedHouseThree.setId(idThree);
    }

    @Test
    @DisplayName("Default Constructor Testing")
    void testHouse() {
        assertEquals(idOne, defaultHouse.getId());
        assertEquals(1, defaultHouse.getNumOfRooms());
        assertNull(defaultHouse.getLocality());
        assertNull(defaultHouse.getOwner());
    }

    @Test
    @DisplayName("Three-parameter Constructor Testing")
    void testHouseNumOwnerLocality() {
        assertEquals(idOne, defaultHouse.getId());
        assertEquals(numOfRoomsOne, parameterizedHouseOne.getNumOfRooms());
        assertEquals(ownerOne, parameterizedHouseOne.getOwner());
        assertEquals(localityOne, parameterizedHouseOne.getLocality());

        assertEquals(idTwo, parameterizedHouseTwo.getId());
        assertEquals(numOfRoomsTwo, parameterizedHouseTwo.getNumOfRooms());
        assertEquals(ownerTwo, parameterizedHouseTwo.getOwner());
        assertEquals(localityTwo, parameterizedHouseTwo.getLocality());

        assertEquals(idThree, parameterizedHouseThree.getId());
        assertEquals(numOfRoomsThree, parameterizedHouseThree.getNumOfRooms());
        assertEquals(ownerThree, parameterizedHouseThree.getOwner());
        assertEquals(localityThree, parameterizedHouseThree.getLocality());
    }

    @Test
    @DisplayName("ID Getter Testing")
    void testGetId() {
        assertEquals(idOne, defaultHouse.getId());
        assertEquals(idOne, parameterizedHouseOne.getId());
        assertEquals(idTwo, parameterizedHouseTwo.getId());
        assertEquals(idThree, parameterizedHouseThree.getId());
    }

    @Test
    @DisplayName("ID Setter Testing")
    void testSetId() {
        defaultHouse.setId(idThree);
        parameterizedHouseOne.setId(idTwo);
        parameterizedHouseTwo.setId(idOne);
        parameterizedHouseThree.setId(idOne);

        assertEquals(idThree, defaultHouse.getId());
        assertEquals(idTwo, parameterizedHouseOne.getId());
        assertEquals(idOne, parameterizedHouseTwo.getId());
        assertEquals(idOne, parameterizedHouseThree.getId());
    }

    @Test
    @DisplayName("Owner Getter Testing")
    void testGetOwner() {
        fail("Not implemented");
    }

    @Test
    @DisplayName("Owner Setter Testing")
    void testSetOwner() {
        fail("Not implemented");
    }

    @Test
    @DisplayName("Number of Rooms Getter Testing")
    void testGetNumOfRooms() {
        fail("Not implemented");
    }

    @Test
    @DisplayName("Number of Rooms Setter Testing")
    void testSetNumOfRooms() {
        fail("Not implemented");
    }

    @Test
    @DisplayName("Locality Getter Testing")
    void testGetLocality() {
        fail("Not implemented");
    }

    @Test
    @DisplayName("Locality Setter Testing")
    void testSetLocality() {
        fail("Not implemented");
    }

    @Test
    @DisplayName("HashCode Testing")
    void testGetHashCode() {
        fail("Not implemented");
    }

    @Test
    @DisplayName("Equals Testing")
    void testEquals() {
        fail("Not implemented");
    }
}
