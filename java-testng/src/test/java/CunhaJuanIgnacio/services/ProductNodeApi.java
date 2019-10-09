package CunhaJuanIgnacio.services;

import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ProductNodeApi {
	@BeforeSuite
	public void setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 3000;
		RestAssured.basePath = "/api";

//		ResponseSpecBuilder builder = new ResponseSpecBuilder();
//		builder.expectContentType(ContentType.JSON);
//		RestAssured.responseSpecification = builder.build();
	}
	
	@BeforeClass
	public void setup2() {
		RestAssured.basePath = RestAssured.basePath + "/product/{id}";
	}

	@Test
	public void getAllProducts() {
		RestAssured.given().log().all().pathParam("id", "")
		.when()
			.get()
		.then()
			.assertThat()
				.body("products[0].id", Matchers.equalTo(1))
				.body("products[0].nombre", equalTo("monitor"))
				.body("products[0].cantidad", equalTo(12));
	}
	
	@Test
	public void getOneProducts() {
		RestAssured.given().log().all().pathParam("id", "3")
		.when()
			.get()
		.then()
			.assertThat()
				.body("id", Matchers.equalTo(3))
				.body("nombre", equalTo("teclado"))
				.body("cantidad", equalTo(20));
	}
}
