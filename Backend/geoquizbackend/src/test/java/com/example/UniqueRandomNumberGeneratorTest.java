package com.example;

//package com.example.geoquizbackend.services;

import com.example.geoquizbackend.services.UniqueRandomNumberGenerator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UniqueRandomNumberGeneratorTest {

    @Test
    public void testConstructor() {
        UniqueRandomNumberGenerator generator = new UniqueRandomNumberGenerator(10);
        assertEquals(0, generator.minVal);
        assertEquals(9, generator.maxVal);
        assertTrue(generator.generatedNumbers.isEmpty());
    }

    @Test
    public void testGenerateNotUnique() {
        UniqueRandomNumberGenerator generator = new UniqueRandomNumberGenerator(10);
        generator.generatedNumbers.add(5);
        int number = generator.generate();
        assertTrue(number >= 0 && number <= 9);
        assertFalse(generator.generatedNumbers.contains(5)); // The number 5 should be replaced
    }


    @Test
    public void testGenerateEmptySet() {
        UniqueRandomNumberGenerator generator = new UniqueRandomNumberGenerator(10);
        int number = generator.generate();
        assertTrue(number >= 0 && number <= 9);
        assertTrue(generator.generatedNumbers.contains(number));
    }

    @Test
    public void testGenerateNonEmptySet() {
        UniqueRandomNumberGenerator generator = new UniqueRandomNumberGenerator(10);
        generator.generatedNumbers.add(5);
        int number = generator.generate();
        assertTrue(number >= 0 && number <= 9);
        assertTrue(generator.generatedNumbers.contains(number));
    }
}
