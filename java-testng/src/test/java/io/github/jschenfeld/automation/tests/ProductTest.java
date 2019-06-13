package io.github.jschenfeld.automation.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.jschenfeld.automation.model.Product;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ProductTest {

	private Product product = new Product(666, "Proyector", 1);

	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 3000;
		RestAssured.basePath = "/api/product";
	}

	@Test
	public void getAll() {
		Response response = RestAssured.given().log().all().get();
		response.prettyPrint();

		assertEquals(response.getStatusCode(), 200);
		JsonPath json = response.jsonPath();
		assertFalse(json.getList("products").isEmpty(), "Lista de productos vacia.");
		assertEquals(json.getInt("products[0].id"), 1);
		assertEquals(json.getInt("products[0].cantidad"), 12);
		assertEquals(json.getString("products[0].nombre"), "monitor");
	}

	@Test
	public void getByIdUsingPathParam() {
		Response response = RestAssured.given().log().all().pathParam("productId", "1").get("/{productId}");
		response.prettyPrint();
		assertEquals(response.getStatusCode(), 200);
		JsonPath json = response.jsonPath();
		assertEquals(json.getInt("id"), 1);
		assertEquals(json.getInt("cantidad"), 12);
		assertEquals(json.getString("nombre"), "monitor");
	}

	@Test
	public void addProductBadRequest() {
		Response response = RestAssured.given().log().all().contentType(ContentType.JSON).post();
		response.prettyPeek();
		assertEquals(response.getStatusCode(), 400);
		JsonPath json = response.jsonPath();
		assertEquals(json.getString("message"), "bad Request");
	}

	@Test
	public void addProduct() {
		Response response = RestAssured.given().log().all().contentType(ContentType.JSON).body(product).post();
		response.prettyPrint();
		assertEquals(response.statusCode(), 201);
		JsonPath json = response.jsonPath();

		assertEquals(json.getString("message"), "El producto se ha recibido");
	}

	@Test(dependsOnMethods = "addProduct")
	public void getByIdUsingQueryParam() {
		Response response = RestAssured.given().log().all().queryParam("productId", product.getId()).get();
		response.prettyPrint();
		assertEquals(response.statusCode(), 200);
		JsonPath json = response.jsonPath();

		assertEquals(json.getInt("id"), product.getId());
		assertEquals(json.getString("nombre"), product.getNombre());
		assertEquals(json.getInt("cantidad"), product.getCantidad());
	}

	@Test(dependsOnMethods = "getByIdUsingQueryParam")
	public void deleteProduct() {
		Response response = RestAssured.given().log().all().pathParam("id", product.getId()).delete("/{id}");
		response.prettyPrint();
		assertEquals(response.statusCode(), 200);
		JsonPath json = response.jsonPath();
		assertEquals(json.getString("message"), "El producto ha sido eliminado exitosamente.");
	}

}
