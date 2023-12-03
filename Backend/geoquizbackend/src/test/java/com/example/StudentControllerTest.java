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
    public void testGetStudentByIdInvalid() {
        Response response = RestAssured.given()
                .when()
                .get("/students/9999")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(404, statusCode);
    }

    @Test
    public void testExistsByEmailInvalid() {
        Response response = RestAssured.given()
                .queryParam("email", "nonexistent@example.com")
                .when()
                .get("/students/exists")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
        assertEquals("false", response.getBody().asString());
    }


    @Test
    public void testAuthenticateInvalidPassword() {
        Response response = RestAssured.given()
                .queryParam("email", "test@example.com")
                .queryParam("password", "wrongpassword")
                .when()
                .get("/students/authenticate")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(404, statusCode);
    }

    @Test
    public void testAuthenticateInvalidCredentials() {
        // Assuming there is no student with email "nonexistent@example.com" and password "wrongpassword"
        Response response = RestAssured.given()
                .queryParam("email", "nonexistent@example.com")
                .queryParam("password", "wrongpassword")
                .when()
                .get("/students/authenticate")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(401, statusCode);
    }

    @Test
    public void testUpdateStudentInvalidId() {
        Student student = new Student();
        student.setId(9999L);
        student.setEmail("test@example.com");
        student.setPassword("password");

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(student)
                .when()
                .put("/students/9999")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(404, statusCode);
    }

    @Test
    public void testDeleteStudentInvalidId() {
        Response response = RestAssured.given()
                .when()
                .delete("/students/9999")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(404, statusCode);
    }

    @Test
    public void testGetStudentByIdNonExistent() {
        // Assuming there is no student with ID 100
        Response response = RestAssured.given()
                .when()
                .get("/students/100")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(404, statusCode);
    }

    @Test
    public void testExistsByEmailNonExistent() {
        // Assuming there is no student with email "nonexistent@example.com"
        Response response = RestAssured.given()
                .queryParam("email", "nonexistent@example.com")
                .when()
                .get("/students/exists")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
        assertEquals("false", response.getBody().asString());
    }


    @Test
    public void testAuthenticateNonExistent() {
        // Assuming there is no student with email "nonexistent@example.com" and password "wrongpassword"
        Response response = RestAssured.given()
                .queryParam("email", "nonexistent@example.com")
                .queryParam("password", "wrongpassword")
                .when()
                .get("/students/authenticate")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(401, statusCode);
    }

    @Test
    public void testCreateStudentExisting() {
        // Assuming there is already a student with email "test@example.com"
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
        assertEquals(400, statusCode);
    }

    @Test
    public void testUpdateStudentNonExistent() {
        // Assuming there is no student with ID 100
        Student student = new Student();
        student.setId(100L);
        student.setEmail("test@example.com");
        student.setPassword("password");

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(student)
                .when()
                .put("/students/100")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(404, statusCode);
    }

    @Test
    public void testDeleteStudentNonExistent() {
        // Assuming there is no student with ID 100
        Response response = RestAssured.given()
                .when()
                .delete("/students/100")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(404, statusCode);
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
    public void testGetStudentByIdValid() {
        // Assuming there is a student with ID 1
        Response response = RestAssured.given()
                .when()
                .get("/students/1")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }

    @Test
    public void testExistsByEmailValid() {
        // Assuming there is a student with email "test@example.com"
        Response response = RestAssured.given()
                .queryParam("email", "test@example.com")
                .when()
                .get("/students/exists")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
        assertEquals("true", response.getBody().asString());
    }

    @Test
    public void testAuthenticateValidCredentials() {
        // Assuming there is a student with email "test@example.com" and password "password"
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
    public void testCreateStudentValidData() {
        Student student = new Student();
        student.setEmail("test2@example.com");
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
    public void testUpdateStudentValidData() {
        Student student = new Student();
        student.setId(1L);
        student.setEmail("test2@example.com");
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
    public void testDeleteStudentValidId() {
        // Assuming there is a student with ID 1
        Response response = RestAssured.given()
                .when()
                .delete("/students/1")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode);
    }

    @Test
    public void testCreateStudentInvalidData() {
        Student student = new Student();
        student.setEmail("");
        student.setPassword("");

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(student)
                .when()
                .post("/students")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(400, statusCode);
    }

    @Test
    public void testUpdateStudentInvalidData() {
        Student student = new Student();
        student.setId(100L);
        student.setEmail("");
        student.setPassword("");

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(student)
                .when()
                .put("/students/100")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(400, statusCode);
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
