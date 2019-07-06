package io.github.jschenfeld.automation.ejemplos;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MiPrimerTest extends BaseTest {

	@Test(dependsOnMethods = {"test2"}, dependsOnGroups = {"ui"})
	public void testDependiente(){
		System.out.println("testDependiente");
		assertTrue(true, "");
		System.out.println("testDependiente");
		assertTrue(false, "");
		System.out.println("testDependiente");
		assertTrue(true, "");
		System.out.println("testDependiente");
		assertTrue(true, "");
	}
	
	@Test(groups = {"ui"})
	public void uiTestGroup(){
		SoftAssert softAssert = new SoftAssert();
		System.out.println("uiTestGroup");
		softAssert.assertTrue(true);
		System.out.println("uiTestGroup");
		softAssert.assertTrue(true);
		System.out.println("uiTestGroup");
		softAssert.assertTrue(true);
		System.out.println("uiTestGroup");
		softAssert.assertTrue(true);
		System.out.println("uiTestGroup");
		softAssert.assertTrue(true);
		softAssert.assertAll();
	}	
	
	@Test(groups = {"ui"}, enabled = false)
	public void uiTestGroup2(){
		System.out.println("uiTestGroup2");
		assertTrue(true);
	}

	@Test(dataProvider = "clientes")
	public void test2(Integer numero, String apellido, String nombre, String tipo){
		System.out.println("dni: " + numero);
		System.out.println("apellido: " + apellido);
		System.out.println("nombre: " + nombre);
		System.out.println("tipo: " + tipo);
		System.out.println("======================");
	    assertNotNull(numero, "El dni ");
		assertTrue(numero > 0);
		assertFalse(apellido.isEmpty());
	    
	}

	@DataProvider(name = "clientes")
	public Object[][] dp() {
		return new Object[][] 
				{ new Object[] { 1, "Schenfeld", "Jonatan", "MAYORISTA" }, 
		          new Object[] { 2, "Acosta", "Laura", "ISTA" }, 
				  new Object[] { 3, "Lopez", "Juan", "MAY" }, 
				  new Object[] { 4, "Garcia", "Romina", "MAYORA"}, 
			};
	}
}