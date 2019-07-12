package io.github.jschenfeld.automation.ejemplos;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.jschenfeld.exercise1.model.Cliente.Tipo;

public class MiPrimerTest extends BaseTest {

	@Test(dependsOnMethods = {"test2"}, dependsOnGroups = {"ui"})
	public void testDependiente(){
		System.out.println("testDependiente1");
		assertTrue(true, "");
		System.out.println("testDependiente2");
		assertTrue(false, "");
		System.out.println("testDependiente3");
		assertTrue(true, "");
		System.out.println("testDependiente4");
		assertTrue(true, "");
	}
	
	@Test(groups = {"ui"})
	public void uiTestGroup(){
		SoftAssert softAssert = new SoftAssert();
		System.out.println("uiTestGroup1");
		softAssert.assertTrue(true);
		System.out.println("uiTestGroup2");
		softAssert.assertTrue(true);
		System.out.println("uiTestGroup3");
		softAssert.assertTrue(true);
		System.out.println("uiTestGroup4");
		softAssert.assertTrue(true);
		System.out.println("uiTestGroup5");
		softAssert.assertTrue(true);
		softAssert.assertAll();
	}	
	
	@Test(groups = {"ui"}, enabled = false)
	public void uiTestGroup2(){
		System.out.println("uiTestGroup2");
		assertTrue(true);
	}

	@Test(dataProvider = "clientes")
	public void test2(Integer numero, String apellido, String nombre, Tipo tipo){
		System.out.println("dni: " + numero);
		System.out.println("apellido: " + apellido);
		System.out.println("nombre: " + nombre);
		System.out.println("tipo: " + tipo);
		System.out.println("======================");
	    Assert.assertNotNull(numero, "El dni ");
		assertTrue(numero > 0);
		assertFalse(apellido.isEmpty());
	    
	}

	@DataProvider(name = "clientes")
	public Object[][] dp() {
		return new Object[][] 
				{ new Object[] { 1, "Schenfeld", "Jonatan", Tipo.MAYORISTA }, 
		          new Object[] { 2, "Acosta", "Laura", Tipo.MINORISTA }, 
				  new Object[] { 3, "Lopez", "Juan", Tipo.MAYORISTA }, 
				  new Object[] { 4, "Garcia", "Romina", Tipo.MINORISTA}, 
			};
	}
}