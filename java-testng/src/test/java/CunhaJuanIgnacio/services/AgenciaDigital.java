package CunhaJuanIgnacio.services;

import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class AgenciaDigital {
	
	@BeforeSuite
	public void setup() {
		RestAssured.baseURI = "http://www.agenciadigital1.net";		
		RestAssured.basePath = "/api";

//		ResponseSpecBuilder builder = new ResponseSpecBuilder();
//		builder.expectContentType(ContentType.JSON);
//		RestAssured.responseSpecification = builder.build();
	}
	
	@BeforeClass
	public void setup2() {
		RestAssured.basePath = RestAssured.basePath + "/news/{idNews}";
	}
	
	@Test
	public void getAllNews() {
		RestAssured.given().log().all()
				.pathParam("idNews", "")
			.when()
				.get()
			.then()
				.assertThat()
				.body("[0].idNews", Matchers.equalTo(54))
				.body("[0].title", equalTo("El Viernes 4 de Octubre estará Alberto Fernandez en Corrientes "))
				.body("[0].introduction", equalTo("Tal como lo informará Pitin Aragón, Alberto Fernandez visitaría Corrientes"));
	}
	
	
	/**
	 * the pathParam is always a String.
	 * The body of a single json object uses only the parameter name and not [].
	 */
	@Test
	public void getOneNews() {
		RestAssured.given().log().all()
				.pathParam("idNews", "44")
			.when()
				.get()
			.then()
				.assertThat()
				.body("idNews", Matchers.equalTo(44))
				.body("title", equalTo("Cambiemos ¿Un Gobierno para Ricos? "))
				.body("introduction", equalTo("Emanuel Alvarez Agis, evalua la gestion de Cambiemos en el plano Economico y su verdadero impacto en el bolsillo de quienes mas tienen"));
	}
}
