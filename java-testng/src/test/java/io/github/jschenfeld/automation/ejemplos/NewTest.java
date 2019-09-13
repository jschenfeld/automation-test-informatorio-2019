package io.github.jschenfeld.automation.ejemplos;

import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.jschenfeld.exercise1.model.Cliente;
import io.github.jschenfeld.exercise1.model.Cliente.Tipo;
import io.github.jschenfeld.exercise1.utils.FileUtils;
import io.github.jschenfeld.model.Estudiante;

public class NewTest {
	
	
	@Test(dataProvider = "dp")
	public void f(Integer n, String s) {
		System.out.println(n + s);
	}
	
	@Test(dataProvider = "dp2")
	public void f(Estudiante estudiante) {
		System.out.println("Apellido: " + estudiante.getApellido());
	}
	
	@Test(dataProvider = "clientes")
	public void clientesTest(Cliente cliente) {
		System.out.println("Listar Clientes");
		System.out.println(cliente.toString());
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
	}
	
	@DataProvider
	public Object[][] dp2() {
		Estudiante estudiante = new Estudiante();
		estudiante.setApellido("Cunha");
		Estudiante estudiante2 = new Estudiante();
		estudiante2.setApellido("Soto");
		return new Object[][] { new Object[] { estudiante }, new Object[] { estudiante2}, };
	}
	
	@DataProvider
	public Object[] clientes() {
		List<Map<String, String>> rawData = FileUtils.readCSV("clientes.csv");
		int index = 0;
		Object[] result = new Object[rawData.size()];
			for (Map<String, String> record : rawData) {
				Cliente cliente = new Cliente();
				cliente.setDni(Integer.parseInt(record.get("dni")));
				cliente.setNombre(record.get("nombre"));
				cliente.setApellido(record.get("apellido"));
				cliente.setTipo(Tipo.valueOf(record.get("tipo")));
				result[index++] = cliente;
			}
		return result;
		
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
	}

}
