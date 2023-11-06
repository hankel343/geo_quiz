package com.example.geoquizbackend.external;
import com.example.geoquizbackend.models.CountryData;
import com.example.geoquizbackend.models.GameData;
import com.example.geoquizbackend.services.UniqueRandomNumberGenerator;
import com.example.geoquizbackend.services.countryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Get a country by name", description = "Returns a country as per the provided name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found - The country was not found")
    })
    @GetMapping("/get")
    public CountryData getByName(@RequestParam String name) {
        Countries = countryService
                    .getByName(name)
                    .block();

        return Countries[0];
    }
    @Operation(summary = "Test method", description = "Test method for debugging")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully executed")
    })
    @GetMapping("/testGetByName")
    public String test() {
        return Countries[0].toString();
    }
    @Operation(summary = "Get all common country names", description = "Returns an array of all common country names")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved common country names")
    })
    @GetMapping("/testCommon")
    public String[] commonNames() {
        String[] names = new String[countryCommonNamesAll.size()];
        for (int i = 0; i < countryCommonNamesAll.size(); i++) {
            names[i] = countryCommonNamesAll.get(i);
        }

        return names;
    }
    @Operation(summary = "Get all common country names", description = "Returns an array of all common country names")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved common country names")
    })
    @GetMapping("/gameData")
    public ArrayList<GameData> getGameDataAll(@RequestParam(value = "count", defaultValue = "1") int count) {
        ArrayList<GameData> gameData = new ArrayList<>(count);
        UniqueRandomNumberGenerator gen = new UniqueRandomNumberGenerator(countryCommonNamesAll.size());

        GameData country;
        CountryData countryData = null;
        for (int i = 0; i < count; i++) {
            country = new GameData();
            countryData = getByName(countryCommonNamesAll.get(gen.generate()));
            country.setName(countryData.getName().getCommon());

            List<String> capital = countryData.getCapital();
            if (capital != null && !capital.isEmpty()) {
                country.setCapital(capital.get(0));
            }

            country.setFlag(countryData.getFlag());
            country.setContinent(countryData.getRegion());
            country.setCoatOfArms(countryData.getCoatOfArms().getPng());
            country.setPopulation(countryData.getPopulation());

            gameData.add(country);
        }

        return gameData;
    }
    @Operation(summary = "Get game data for Asia", description = "Returns game data for a specified number of countries in Asia")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved game data for Asia")
    })
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
    @Operation(summary = "Get game data for Americas", description = "Returns game data for a specified number of countries in Americas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved game data for Americas")
    })
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
    @Operation(summary = "Get game data for Africa", description = "Returns game data for a specified number of countries in Africa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved game data for Africa")
    })
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
    @Operation(summary = "Get game data for Oceania", description = "Returns game data for a specified number of countries in Oceania")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved game data for Oceania")
    })
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
    @Operation(summary = "Get game data for Europe", description = "Returns game data for a specified number of countries in Europe")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved game data for Europe")
    })
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
    @Operation(summary = "Get game data for Antarctic", description = "Returns game data for a specified number of countries in Antarctic")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved game data for Antarctic")
    })
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
    @Operation(summary = "Get game data with coat of arms", description = "Returns game data for a specified number of countries that have a coat of arms")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved game data with coat of arms")
    })
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