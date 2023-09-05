package com.cs309.tutorial.tests;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

import java.util.HashMap;

/*
	I'm using a basic text file to model a database in the following controller.
	POST methods write to data.txt and GET retrieves all the data from it.
 */

@RestController
public class TestController {

	HashMap<String, String> capitalCities = new HashMap<String, String>();

	@GetMapping("/")
	public String welcome() {
		return "Welcome to GeoQuiz";
	}
	@GetMapping("/getTest")
	public String getTest(
			@RequestParam(value = "country", defaultValue = "some country") String country,
			@RequestParam(value = "capital", defaultValue = "some city") String capital)
	{
		capitalCities.put(country, capital);

		System.out.println(country);
		System.out.println(capital);

		return String.format("Capital [ %s ] of country [ %s ] added to the list", capital, country);
	}
	
	@PostMapping("/postTest1")
	public String postTest1(@RequestParam(value = "username", defaultValue = "World") String message) {
		try {
			FileWriter writer = new FileWriter("data.txt", true); // Append to the file
			writer.write(message + "\n");
			writer.close();
			return String.format("Hello, %s! Your message has been saved to a file.", message);
		} catch (IOException e) {
			e.printStackTrace();
			return "Failed to save the message.";
		}
	}
	
	@PostMapping("/postTest2")
	public String postTest2(@RequestBody TestData testData) {
		// Store the data sent to this endpoint by writing it to a file
		String message = testData.getMessage();

		//Save the message to a file
		try {
			FileWriter writer = new FileWriter("data.txt", true); // true for appending to existing contents
			writer.write(message + "\n");
			writer.close();
			return String.format("Hello, %s! You sent a post request with a requestbody!", testData.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			return "Failed to save the message.";
		}
	}
	
	@DeleteMapping("/deleteTest")
	public void deleteTest() {
		//TODO
	}
	
	@PutMapping("/putTest")
	public void putTest() {
		//TODO
	}
}
