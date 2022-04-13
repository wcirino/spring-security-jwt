package com.projetoSpringSec.Spring;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {
	
	@LocalServerPort
	private int port;

	@Test
	void contextLoads() {
		assertFalse(Boolean.FALSE);
	}
	
	@Before
	public void setUp() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	  //RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = port;
		RestAssured.basePath = "/api-beneficiario";
	}
	
	@Test
	public void BuscaBeneficiarioHTTP200Test() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		given()
		.accept(ContentType.JSON)
		.when()
		.get("/beneficiario-consult/1")
		.then()
		.statusCode(HttpStatus.OK.value());
	}

}
