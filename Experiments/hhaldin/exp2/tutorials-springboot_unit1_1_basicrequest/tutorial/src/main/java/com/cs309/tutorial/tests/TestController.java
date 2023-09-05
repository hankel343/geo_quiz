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

/*
	I'm using a basic text file to model a database in the following controller.
	POST methods write to data.txt and GET retrieves all the data from it.
 */

@RestController
public class TestController {
	



	@GetMapping("/getTest")
	public String getTest(@RequestParam(value = "username", defaultValue = "World") String message) {
		String fileName = "data.txt";
		StringBuilder fileContents = new StringBuilder();

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
			String line;
			while ((line = reader.readLine()) != null) {
				fileContents.append(line).append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
			return "Failed to read file contents.";
		}

		return fileContents.toString();
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
