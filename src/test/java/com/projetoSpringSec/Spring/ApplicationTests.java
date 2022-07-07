package com.projetoSpringSec.Spring;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.Before;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
class ApplicationTests {
	
	@LocalServerPort
	private int port;
	
	@BeforeEach
	public void setUp() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	  //RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = this.port;
		RestAssured.basePath = "/api-beneficiario";
	}
	
	@Test
	void contextLoads() {
		assertFalse(Boolean.FALSE);
	}
	
	@Test
	public void BuscaBeneficiarioHTTP200Test() {
		given()
		.accept(ContentType.JSON)
		.when()
		.get("/beneficiario-consult/1")
		.then()
		.statusCode(HttpStatus.OK.value());
	}

	
	@Test
	public void BuscaBeneficiarioHTTP200Test2() {
		given()
		.accept(ContentType.JSON)
		.when()
		.get("/beneficiario-consult/1")
		.then()
		.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void BuscaBeneficiarioHTTP200Test3() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		given()
		.accept(ContentType.JSON)
		.when()
		.get("/beneficiario-consult/1")
		.then()
		.statusCode(HttpStatus.OK.value());
	}
}
