package com.app.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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

}
