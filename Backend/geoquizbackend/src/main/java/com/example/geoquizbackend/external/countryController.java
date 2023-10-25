package com.example.geoquizbackend.external;

import com.example.geoquizbackend.models.CountryData;
import com.example.geoquizbackend.models.GameData;
import com.example.geoquizbackend.services.UniqueRandomNumberGenerator;
import com.example.geoquizbackend.services.countryService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/countries")
class countryController {

    /* Used for queries */
    List<String> countryCommonNamesAll;
    List<String> countryCommonNamesAsia;
    List<String> countryCommonNamesAmericas;
    List<String> countryCommonNamesAfrica;
    List<String> countryCommonNamesOceania;
    List<String> countryCommonNamesEurope;
    List<String> countryCommonNamesAntarctic;




    /* Stores country objects returned by API */
    CountryData[] Countries;

    /* HTTP service for external API */
    private countryService countryService;

    public countryController(countryService countryService) {
        this.countryService = countryService;
        this.countryCommonNamesAll = countryService.getAllCommonNames().block();
        this.countryCommonNamesAsia = countryService.getAllCommonNamesAsia().block();
        this.countryCommonNamesAmericas = countryService.getAllCommonNamesAmericas().block();
        this.countryCommonNamesAfrica = countryService.getAllCommonNamesAfrica().block();
        this.countryCommonNamesOceania = countryService.getAllCommonNamesOceania().block();
        this.countryCommonNamesEurope = countryService.getAllCommonNamesEurope().block();
        this.countryCommonNamesAntarctic = countryService.getAllCommonNamesAntarctic().block();
    }
    @GetMapping("/get")
    public CountryData getByName(@RequestParam String name) {
        Countries = countryService
                    .getByName(name)
                    .block();

        return Countries[0];
    }

    @GetMapping("/testGetByName")
    public String test() {
        return Countries[0].toString();
    }

    @GetMapping("/testCommon")
    public String commonNames() {
        return String.join(", ", countryCommonNamesAll);
    }

    @GetMapping("/gameDataAll")
    public ArrayList<GameData> getGameDataAll() {
        ArrayList<GameData> gameData = new ArrayList<>(4);
        UniqueRandomNumberGenerator gen = new UniqueRandomNumberGenerator(countryCommonNamesAll.size());

        CountryData countryData = null;
        GameData country;
        for (int i = 0; i < 4; i++) {
            country = new GameData();
            countryData = getByName(countryCommonNamesAll.get(gen.generate()));
            country.setName(countryData.getName().getCommon());
            country.setCapital(countryData.getCapital().get(0));
            country.setFlag(countryData.getFlag());
            country.setContinent(countryData.getRegion());
            country.setPopulation(countryData.getPopulation());

            gameData.add(country);
        }

        return gameData;
    }

    @GetMapping("/gameDataAsia")
    public ArrayList<CountryData> getGameDataAsia() {

        ArrayList<CountryData> GameData = new ArrayList<>(4);
        UniqueRandomNumberGenerator gen = new UniqueRandomNumberGenerator(countryCommonNamesAsia.size());
        for (int i = 0; i < 4; i++) {
            GameData.add(
                    getByName(countryCommonNamesAsia.get(gen.generate()))
            );
        }

        return GameData;
    }

    @GetMapping("/gameDataAmericas")
    public ArrayList<CountryData> getGameDataAmericas() {

        ArrayList<CountryData> GameData = new ArrayList<>(4);
        UniqueRandomNumberGenerator gen = new UniqueRandomNumberGenerator(countryCommonNamesAmericas.size());
        for (int i = 0; i < 4; i++) {
            GameData.add(
                    getByName(countryCommonNamesAmericas.get(gen.generate()))
            );
        }

        return GameData;
    }

    @GetMapping("/gameDataAfrica")
    public ArrayList<CountryData> getGameDataAfrica() {

        ArrayList<CountryData> GameData = new ArrayList<>(4);
        UniqueRandomNumberGenerator gen = new UniqueRandomNumberGenerator(countryCommonNamesAfrica.size());
        for (int i = 0; i < 4; i++) {
            GameData.add(
                    getByName(countryCommonNamesAfrica.get(gen.generate()))
            );
        }

        return GameData;
    }

    @GetMapping("/gameDataOceania")
    public ArrayList<CountryData> getGameDataOceania() {

        ArrayList<CountryData> GameData = new ArrayList<>(4);
        UniqueRandomNumberGenerator gen = new UniqueRandomNumberGenerator(countryCommonNamesOceania.size());
        for (int i = 0; i < 4; i++) {
            GameData.add(
                    getByName(countryCommonNamesOceania.get(gen.generate()))
            );
        }

        return GameData;
    }

    @GetMapping("/gameDataEurope")
    public ArrayList<CountryData> getGameDataEurope() {

        ArrayList<CountryData> GameData = new ArrayList<>(4);
        UniqueRandomNumberGenerator gen = new UniqueRandomNumberGenerator(countryCommonNamesEurope.size());
        for (int i = 0; i < 4; i++) {
            GameData.add(
                    getByName(countryCommonNamesEurope.get(gen.generate()))
            );
        }

        return GameData;
    }

    @GetMapping("/gameDataAntarctic")
    public ArrayList<CountryData> getGameDataAntarctic() {

        ArrayList<CountryData> GameData = new ArrayList<>(4);
        UniqueRandomNumberGenerator gen = new UniqueRandomNumberGenerator(countryCommonNamesAntarctic.size());
        for (int i = 0; i < 4; i++) {
            GameData.add(
                    getByName(countryCommonNamesAntarctic.get(gen.generate()))
            );
        }

        return GameData;
    }

    @GetMapping("/gameDataCoatOfArms")
    public ArrayList<GameData> getGameDataCoatOfArms() {
        ArrayList<GameData> gameData = new ArrayList<>(4);
        UniqueRandomNumberGenerator gen = new UniqueRandomNumberGenerator(countryCommonNamesAll.size());

        CountryData countryData = null;
        GameData country;
        for (int i = 0; i < 4; i++) {
            country = new GameData();
            countryData = getByName(countryCommonNamesAll.get(gen.generate()));
            while (countryData.getCoatOfArms() == null) {
                countryData = getByName(countryCommonNamesAll.get(gen.generate()));
            }
            country.setName(countryData.getName().getCommon());
            country.setCapital(countryData.getCapital().get(0));
            country.setFlag(countryData.getFlag());
            country.setContinent(countryData.getRegion());
            country.setPopulation(countryData.getPopulation());
            country.setCoatOfArms(countryData.getCoatOfArms().getPng());

            gameData.add(country);
        }

        return gameData;
    }
}