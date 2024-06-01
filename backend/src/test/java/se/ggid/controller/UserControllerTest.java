package se.ggid.controller;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.*;
import se.ggid.dto.UserDto;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.ggid.service.UserService;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class UserControllerTest {
    
  @Inject
  UserService userService;

  @BeforeEach
  void create() {
    userService.rensaUsers();
    UserDto userDto = new UserDto();
    userDto.setName("Kalle Kula");
    userDto.setAddress("Gatan 123");
    userDto.setEmail("Kalle@kula.se");
    userDto.setTelephone("123456");
    given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(userDto)
        .when()
        .post("/ggid/user")
        .then()
        .statusCode(Response.Status.OK.getStatusCode());
  }

  @Test
  @Order(1)
  void getOK() {
    given()
        .when()
        .get("/ggid/user")
        .then()
        .statusCode(Response.Status.OK.getStatusCode());
  }

  @Test
  @Order(2)
  void getListOfUsers() {
    given()
            .when()
            .get("/ggid/user")
            .as(UserDto[].class);

  }

  @Test
  @Order(3)
  void testaAttListanArEttLang()
  {
    assertEquals(1, userService.findAll().size());
  }

}
