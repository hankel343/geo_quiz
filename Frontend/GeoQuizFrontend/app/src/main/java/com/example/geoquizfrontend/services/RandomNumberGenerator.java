package com.example.geoquizfrontend.services;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumberGenerator {
    private int minVal = 0;
    private int maxVal = 0;

    Set<Integer> generatedNumbers = new HashSet<>();

    Random rand = new Random();

    public RandomNumberGenerator(int maxValue) {
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
