package com.example;

import com.example.geoquizbackend.GeoquizbackendApplication;
import com.example.geoquizbackend.Guest.Guest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = GeoquizbackendApplication.class)
@RunWith(SpringRunner.class)
public class GuestControllerTest {

    @LocalServerPort
    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
    }

    @Test
    public void testGetGuestByInitials() {
        String initials = "JD";

        Response response = RestAssured.given()
                .queryParam("initials", initials)
                .when()
                .get("/guests/get")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }

    @Test
    public void testCreateGuest() {
        Guest guest = new Guest();
        guest.setInitials("JD");

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(guest)
                .when()
                .post("/guests/create")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(201, statusCode);
    }

    @Test
    public void testUpdateGuest() {
        Guest guest = new Guest();
        guest.setInitials("JD");

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(guest)
                .when()
                .put("/guests/update")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }

    @Test
    public void testDeleteGuest() {
        Long id = 1L;

        Response response = RestAssured.given()
                .pathParam("id", id)
                .when()
                .delete("/guests/delete/{id}")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(204, statusCode);
    }
}

