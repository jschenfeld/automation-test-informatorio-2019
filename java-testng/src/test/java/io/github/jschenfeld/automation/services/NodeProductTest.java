package io.github.jschenfeld.automation.services;

import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class NodeProductTest {

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
		RestAssured.given().log().all().pathParam("id", "").when().get().then().assertThat()
				.body("products[0].id", Matchers.equalTo(1)).body("products[0].nombre", equalTo("monitor"))
				.body("products[0].cantidad", equalTo(12));
	}

	@Test
	public void addNewProduct() {		
		Product product = new Product(666, "Guiso", 999);
		
		RestAssured.given().log().all()
		.contentType(ContentType.JSON)
		.pathParam("id", "")
		.body(product)
		.post()
		.then()
		.statusCode(201)
				.body("message", Matchers.equalTo("El producto se ha recibido"));
	}
	
	@Test(dependsOnMethods = "addNewProduct")
	public void getById() {
		RestAssured.given().log().all()
		.contentType(ContentType.JSON)
		.pathParam("id", "666")
		.get()
		.then()
		.statusCode(200)
		.body("nombre", equalTo("Guiso"))
		.body("cant", equalTo(999));
	}

	@Test(dependsOnMethods = "getById")
	public void deleteProduct() {
		RestAssured.given().log().all()
		.contentType(ContentType.JSON)
		.pathParam("id", "666")
		.delete()
		.then()
		.statusCode(200)
		.body("message", equalTo("El producto ha sido eliminado exitosamente."));
	}
	
	@Test(dependsOnMethods = "deleteProduct")
	public void getByIdAfterDelete() {
		RestAssured.given()
		.log().all()
		.pathParam("id", "666")
		.get()
		.then()
		.statusCode(204);
	}
}