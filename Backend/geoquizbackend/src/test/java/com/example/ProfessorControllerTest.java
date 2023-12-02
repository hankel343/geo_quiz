package com.example;

import com.example.geoquizbackend.GeoquizbackendApplication;
import com.example.geoquizbackend.Professor.Professor;
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
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = GeoquizbackendApplication.class)
@RunWith(SpringRunner.class)
public class ProfessorControllerTest {

    @LocalServerPort
    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
    }

    @Test
    public void testGetProfessorByEmail() {
        String email = "john.doe@example.com";

        Response response = RestAssured.given()
                .queryParam("email", email)
                .when()
                .get("/professors/get")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }

    @Test
    public void testExistsByEmail() {
        String email = "john.doe@example.com";

        Response response = RestAssured.given()
                .queryParam("email", email)
                .when()
                .get("/professors/exists")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);

        Boolean exists = response.as(Boolean.class);
        assertTrue(exists);
    }


    @Test
    public void testCreateProfessor() {
        Professor professor = new Professor();
        professor.setFirstName("John");
        professor.setLastName("Doe");
        professor.setEmail("john.doe@example.com");
        professor.setPassword("password123");

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(professor)
                .when()
                .post("/professors")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(201, statusCode);
    }

    @Test
    public void testAuthenticateProfessor() {
        String email = "john.doe@example.com";
        String password = "password123";

        Response response = RestAssured.given()
                .queryParam("email", email)
                .queryParam("password", password)
                .when()
                .get("/professors/authenticate")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }


    @Test
    public void testUpdateProfessor() {
        Long id = 1L;
        Professor professor = new Professor();
        professor.setFirstName("John");
        professor.setLastName("Doe");
        professor.setEmail("john.doe@example.com");
        professor.setPassword("password123");

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(professor)
                .pathParam("id", id)
                .when()
                .put("/professors/{id}")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }


    @Test
    public void testDeleteProfessor() {
        Long id = 1L;

        Response response = RestAssured.given()
                .pathParam("id", id)
                .when()
                .delete("/professors/{id}")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }



    @Test
    public void testGetStudentsByProfessor() {
        Long professorId = 1L;

        Response response = RestAssured.given()
                .pathParam("id", professorId)
                .when()
                .get("/professors/{id}/students")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }

    @Test
    public void testGetGeoClassesByProfessor() {
        Long professorId = 1L;

        Response response = RestAssured.given()
                .pathParam("id", professorId)
                .when()
                .get("/professors/{id}/geoClasses")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }
}

