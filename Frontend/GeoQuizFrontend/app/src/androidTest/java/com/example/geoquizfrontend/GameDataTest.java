package com.example.geoquizfrontend;

import static org.junit.Assert.assertEquals;

import com.example.geoquizfrontend.models.GameData;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GameDataTest {

    private GameData gameData;

    @Before
    public void setup() {
        gameData = new GameData();
        gameData.setName("Test Country");
        gameData.setCapital("Test Capital");
        gameData.setFlag("Test Flag");
        gameData.setContinent("Test Continent");
        gameData.setcoatOfArms("Test Coat of Arms");
        gameData.setPopulation(1000000);
    }

    @Test
    public void testGetName() {
        assertEquals("Test Country", gameData.getName());
    }

    @Test
    public void testGetCapital() {
        assertEquals("Test Capital", gameData.getCapital());
    }

    @Test
    public void testGetFlag() {
        assertEquals("Test Flag", gameData.getFlag());
    }

    @Test
    public void testGetContinent() {
        assertEquals("Test Continent", gameData.getContinent());
    }

    @Test
    public void testGetcoatOfArms() {
//        assertEquals("Test Coat of Arms", gameData.getcoatOfArms());
    }

    @Test
    public void testGetPopulation() {
        assertEquals(1000000, gameData.getPopulation());
    }
}

