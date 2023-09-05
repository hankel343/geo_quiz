package com.cs309.tutorial.tests;

import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;

import java.util.HashMap;

/*
	I'm using a basic text file to model a database in the following controller.
	POST methods write to data.txt and GET retrieves all the data from it.
 */

@RestController
public class CountryController {

	private HashMap<Integer, CountryData> countryList = new HashMap<Integer, CountryData>();
	private int id = 0;

	@GetMapping("/")
	public String welcome() {
		return "Welcome to GeoQuiz";
	}
	@GetMapping("/getTest")
	public String getTest(
			@RequestParam(value = "country", defaultValue = "some country") String country,
			@RequestParam(value = "capital", defaultValue = "some city") String capital)
	{
		CountryData newCountry = new CountryData(country, capital);
		countryList.put(id++, newCountry);

		System.out.println(country);
		System.out.println(capital);

		return String.format("Capital [ %s ] of country [ %s ] added to the list", capital, country);
	}

	@GetMapping("/countries")
	public @ResponseBody HashMap<Integer, CountryData> getAllCountries() {
		return countryList;
	}
	
	@PostMapping("/postCountry")
	public String postTest2(@RequestBody CountryData testData) {
		countryList.put(id++, testData);

		return String.format("Country %s added to the list!", testData.getName());
	}
	
	@DeleteMapping("/deleteTest")
	public void deleteTest(@RequestParam(value = "id") int countryID) {
		countryList.remove(countryID);
	}
	
	@PutMapping("/putTest")
	public void putTest(@RequestParam(value = "id") int countryID) {
		countryList.get(countryID);
	}
}
