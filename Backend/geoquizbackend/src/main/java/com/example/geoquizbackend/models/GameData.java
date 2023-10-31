package com.example.geoquizbackend.models;


public class GameData {
    private String name;
    private String capital;
    private String flag;
    private String coatOfArms;
    private String continent;
    private int population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCoatOfArms() { return this.coatOfArms; }

    public void setCoatOfArms(String coatOfArms) { this.coatOfArms = coatOfArms; }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getPopulation() {
        return this.population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}