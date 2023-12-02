package com.example;

import com.example.geoquizbackend.GeoquizbackendApplication;
import com.example.geoquizbackend.models.CountryData;
import com.jayway.jsonpath.TypeRef;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = GeoquizbackendApplication.class)
@RunWith(SpringRunner.class)
public class CountryControllerTest {

    @LocalServerPort
    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
    }

    @Test
    public void testGetByName() {
        String countryName = "United States";

        Response response = RestAssured.given()
                .queryParam("name", countryName)
                .when()
                .get("/countries/get")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }

    @Test
    public void testGetGameDataAsia() {
        Response response = RestAssured.given()
                .when()
                .get("/countries/gameDataAsia")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);

    }

    @Test
    public void testGetGameDataAmericas() {
        Response response = RestAssured.given()
                .when()
                .get("/countries/gameDataAmericas")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }

    @Test
    public void testGetGameDataAfrica() {
        Response response = RestAssured.given()
                .when()
                .get("/countries/gameDataAfrica")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }


    @Test
    public void testGetGameDataOceania() {
        Response response = RestAssured.given()
                .when()
                .get("/countries/gameDataOceania")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }

    @Test
    public void testGetGameDataEurope() {
        Response response = RestAssured.given()
                .when()
                .get("/countries/gameDataEurope")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }

    @Test
    public void testGetGameDataAntarctic() {
        Response response = RestAssured.given()
                .when()
                .get("/countries/gameDataAntarctic")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }

    @Test
    public void testGetGameDataCoatOfArms() {
        Response response = RestAssured.given()
                .when()
                .get("/countries/gameDataCoatOfArms")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }


    @Test
    public void testGetGameDataAll() {
        int count = 5;

        Response response = RestAssured.given()
                .queryParam("count", count)
                .when()
                .get("/countries/gameData")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }

    @Test
    public void testCommonNames() {
        Response response = RestAssured.given()
                .when()
                .get("/countries/testCommon")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);

        String[] names = response.as(String[].class);
        assertNotNull(names);
        assertTrue(names.length > 0);
    }

    @Test
    public void testGetByName_InvalidName() {
        String countryName = "InvalidCountry";

        Response response = RestAssured.given()
                .queryParam("name", countryName)
                .when()
                .get("/countries/get")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(404, statusCode);
    }

    @Test
    public void testGetGameDataAll_InvalidCount() {
        int count = -1;

        Response response = RestAssured.given()
                .queryParam("count", count)
                .when()
                .get("/countries/gameData")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(400, statusCode);
    }

    @Test
    public void testGetGameDataAll_NoCount() {
        Response response = RestAssured.given()
                .when()
                .get("/countries/gameData")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(400, statusCode);
    }
}

