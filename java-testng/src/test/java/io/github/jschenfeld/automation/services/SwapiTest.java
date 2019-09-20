package io.github.jschenfeld.automation.services;

import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;

public class SwapiTest {

	public SwapiTest() {
		String url = "https://swapi.co/api/{resource}/{id}";
		RestAssured
		.given()
			.log().all()
			.pathParam("resource", "people")
			.pathParam("id", "1")
		.when()
			.get(url)
		.then()
			.statusCode(200)
			.assertThat().body("films[0]", equalTo("https://swapi.co/api/films/2/"));
	}
}