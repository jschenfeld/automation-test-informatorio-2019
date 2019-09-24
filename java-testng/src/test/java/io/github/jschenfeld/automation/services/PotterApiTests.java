package io.github.jschenfeld.automation.services;

import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PotterApiTests {

	@Test
	public void getCharacters() {
		String url = "https://www.potterapi.com/{version}/{resource}/{id}";
		String key = "$2a$10$nuHwK3mjECk7VSs9i.gtUuJk5L7x7IFpJ2EhzS57XPrMrM6IqodGC";
		RestAssured
		.given()
			.log().all()
			.pathParam("version", "v1")
			.pathParam("resource", "characters")
			.pathParam("id", "5a0fa4daae5bc100213c232e")
			.queryParam("key", key)
			.get(url)
		.then()
			.statusCode(200)
			.assertThat().body("name", equalTo("Hannah Abbott"));
	}
	
	
	@Test
	public void getCharacters2() {
		String url = "https://www.potterapi.com/{version}/{resource}/{id}";
		String key = "$2a$10$nuHwK3mjECk7VSs9i.gtUuJk5L7x7IFpJ2EhzS57XPrMrM6IqodGC";
		Response response = RestAssured
		.given()
			.log().all()
			.pathParam("version", "v1")
			.pathParam("resource", "characters")
			.pathParam("id", "5a0fa4daae5bc100213c232e")
			.queryParam("key", key)
			.get(url);
		
		JsonPath jsonPath = response.body().jsonPath();
		
		assertEquals(jsonPath.getString("name"), "Hannah Abbott");;
	}
}