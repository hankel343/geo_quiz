package com.example;

import com.example.geoquizbackend.GeoquizbackendApplication;
import com.example.geoquizbackend.Student.Student;
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
public class StudentControllerTest {

    @LocalServerPort
    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
    }

    @Test
    public void testGetAllStudents() {
        Response response = RestAssured.given()
                .when()
                .get("/students")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }

    @Test
    public void testGetStudentById() {
        Response response = RestAssured.given()
                .when()
                .get("/students/1")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }

    @Test
    public void testExistsByEmail() {
        Response response = RestAssured.given()
                .queryParam("email", "test@example.com")
                .when()
                .get("/students/exists")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }

    @Test
    public void testAuthenticate() {
        Response response = RestAssured.given()
                .queryParam("email", "test@example.com")
                .queryParam("password", "password")
                .when()
                .get("/students/authenticate")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }

    @Test
    public void testCreateStudent() {
        Student student = new Student();
        student.setEmail("test@example.com");
        student.setPassword("password");

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(student)
                .when()
                .post("/students")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(201, statusCode);
    }

    @Test
    public void testUpdateStudent() {
        Student student = new Student();
        student.setId(1L);
        student.setEmail("test@example.com");
        student.setPassword("password");

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(student)
                .when()
                .put("/students/1")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }

    @Test
    public void testDeleteStudent() {
        Response response = RestAssured.given()
                .when()
                .delete("/students/1")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }


}
