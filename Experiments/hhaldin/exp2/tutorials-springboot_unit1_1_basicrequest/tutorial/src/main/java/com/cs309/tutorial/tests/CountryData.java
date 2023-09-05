package com.cs309.tutorial.tests;

public class CountryData {
    String name;
    String capital;

    CountryData(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }

    public String getName() {
        return this.name;
    }

    public String getCapital() {
        return this.capital;
    }
}
