package com.example.geoquizbackend.services;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class UniqueRandomNumberGenerator {

    public int minVal = 0;
    public int maxVal = 0;
    public Set<Integer> generatedNumbers = new HashSet<>();
    Random rand = new Random();

    public UniqueRandomNumberGenerator(int maxValue) {
        this.maxVal = maxValue-1;
    }

    public int generate() {
        int randNum = rand.nextInt(maxVal - minVal + 1) + minVal;

        while (generatedNumbers.contains(randNum)) {
            randNum = rand.nextInt(maxVal - minVal + 1) + minVal;
            generatedNumbers.add(randNum);
        }

        return randNum;
    }
}
