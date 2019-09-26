package io.github.jschenfeld.automation.services;

import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PotterApiTests {
	
	private static final String key = "$2a$10$nuHwK3mjECk7VSs9i.gtUuJk5L7x7IFpJ2EhzS57XPrMrM6IqodGC";
	
	@BeforeSuite
	public void setup() {
		RestAssured.baseURI = "https://www.potterapi.com";
		RestAssured.basePath = "/v1";
		
		ResponseSpecBuilder builder = new ResponseSpecBuilder();
		builder.expectContentType(ContentType.JSON);
		RestAssured.responseSpecification = builder.build();
	}
	
	@BeforeClass
	public void setup2() {
		RestAssured.basePath = RestAssured.basePath  + "/characters/{id}";
		RestAssured.responseSpecification.statusCode(200);

	}

	@Test
	public void getCharacters() {
		RestAssured
		.given()
			.log().all()
			.contentType(ContentType.JSON)
			.pathParam("id", "")
			.queryParam("key", key)
			.get()
		.then()
			.assertThat()
				.body("[0].name", equalTo("Hannah Abbott"))
			.and()		
				.body("[0].role",  equalTo("student"));
	}
	
	@Test
	public void getCharacters2() {
		Response response = RestAssured
		.given()
			.log().all()
			.contentType(ContentType.JSON)
			.pathParam("id", "")
			.queryParam("key", key)
			.get();
		
		JsonPath jsonPath = response.body().jsonPath();
		List<Map<String, String>> characters = jsonPath.getList(""); 
		for (Map<String, String> character : characters) {
			System.out.println(character.get("name"));
			System.out.println(character.get("role"));

		}
	}
	
	@Test
	public void getCharacter() {
		RestAssured
		.given()
			.log().all()
			.contentType(ContentType.JSON)
			.pathParam("id", "5a0fa4daae5bc100213c232e")
			.queryParam("key", key)
			.get()
		.then()
			.assertThat()
				.body("name", equalTo("Hannah Abbott"));
	}
	
	
	@Test
	public void getCharacter2() {
		Response response = RestAssured
		.given()
			.log().all()
			.contentType(ContentType.JSON)
			.pathParam("id", "5a0fa4daae5bc100213c232e")
			.queryParam("key", key)
			.get();
		
		JsonPath jsonPath = response.body().jsonPath();
		assertEquals(jsonPath.getString("name"), "Hannah Abbott");;
	}
}