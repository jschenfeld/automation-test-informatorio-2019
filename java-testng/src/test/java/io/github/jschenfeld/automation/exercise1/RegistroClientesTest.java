package io.github.jschenfeld.automation.exercise1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.jschenfeld.exercise1.business.RegistroClientes;
import io.github.jschenfeld.exercise1.model.Cliente;
import io.github.jschenfeld.exercise1.model.Cliente.Tipo;

public class RegistroClientesTest {
	RegistroClientes registroClientes = new RegistroClientes();
	
	
	@Test(dependsOnMethods = {"agregarClientesTest"})
	public void obtenerClientesTest() {
		Cliente cliente = registroClientes.buscarClientePorDni(1000);
		assertNotNull(cliente, "No se encontro el cliente con dni 1000");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(cliente.getDni(), Integer.valueOf("1000"), "dni incorrecto");
		soft.assertEquals(cliente.getApellido(), "Schenfeld", "apellido incorrecto");
		soft.assertEquals(cliente.getNombre(), "Jonatan", "nombre incorrecto");
		soft.assertEquals(cliente.getTipo(), Tipo.MAYORISTA, "tipo cliente incorrecto");
		
		soft.assertAll();
	}
	
	@Test(dataProvider = "clientes")
	public void agregarClientesTest(Integer dni, String apellido, String nombre, Tipo tipo) {
		Cliente clienteNuevo = new Cliente(dni, nombre, apellido, tipo);
		registroClientes.agregar(clienteNuevo);
		Cliente cliente = registroClientes.buscarClientePorDni(clienteNuevo.getDni());
		assertEquals(cliente.getDni(), clienteNuevo.getDni(), "dni incorrecto");
		assertEquals(cliente.getApellido(), clienteNuevo.getApellido(), "apellido incorrecto");
		assertEquals(cliente.getNombre(), clienteNuevo.getNombre(), "nombre incorrecto");
		assertEquals(cliente.getTipo(), clienteNuevo.getTipo(), "tipo cliente incorrecto");
	}
	
	@DataProvider(name = "clientes")
	public Object[][] dp() {
		return new Object[][] 
				{ new Object[] { 1000, "Schenfeld", "Jonatan", Tipo.MAYORISTA }, 
		          new Object[] { 22213, "Acosta", "Laura", Tipo.MINORISTA }, 
				  new Object[] { 3123123, "Lopez", "Juan", Tipo.MAYORISTA } 
			};
	}
	
	@Test(groups = { "informatorio" } )
	@Parameters({"dni"})
	public void eliminarClientesTest(@Optional(value = "3") Integer dni) {
		Cliente clienteExistente = registroClientes.buscarClientePorDni(dni);
		assertNotNull(clienteExistente);
		registroClientes.eliminar(dni);
		Cliente clienteEliminado = registroClientes.buscarClientePorDni(dni);
		assertNull(clienteEliminado);
	}
}