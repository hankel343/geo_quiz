package com.example.geoquizfrontend;

import static org.junit.Assert.assertEquals;

import com.example.geoquizfrontend.models.Guest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GuestTest {

    private Guest guest;

    @Before
    public void setup() {
        guest = new Guest();
        guest.setId(1);
        guest.setScore(90);
        guest.setInitials("JD");
    }

    @Test
    public void testGetScore() {
        assertEquals(90, guest.getScore());
    }

    @Test
    public void testGetInitials() {
        assertEquals("JD", guest.getInitials());
    }

    @Test
    public void testGetId() {
        assertEquals(1, guest.getId());
    }
}

