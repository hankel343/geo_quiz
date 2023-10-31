package com.example.geoquizfrontend.models;

public class GameData {
    private String name;
    private String capital;
    private String flag;
    private String continent;
    private String coa;
    private int population;

    public GameData() {

    }

    public GameData(String name, String capital, String flag, String coa, String continent, int population) {
        this.name = name;
        this.capital = capital;
        this.flag = flag;
        this.coa = coa;
        this.continent = continent;
        this.population = population;
    }

    // Getters and setters
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

    public String getCoatOfArms(String coa) { return coa; }
    public void setCoa(String coa)  { this.coa = coa; }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
