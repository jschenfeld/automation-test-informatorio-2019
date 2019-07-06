package io.github.jschenfeld.automation.exercise1;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.github.jschenfeld.exercise1.business.RegistroClientes;
import io.github.jschenfeld.exercise1.model.Cliente;
import io.github.jschenfeld.exercise1.model.Cliente.Tipo;

public class RegistroClientesTest {

	@Test
	public void obtenerClientesTest() {
		RegistroClientes registroClientes = new RegistroClientes();
		Cliente cliente = registroClientes.buscarClientePorDni(1);
		assertEquals(cliente.getDni(), Integer.valueOf("1"), "dni incorrecto");
		assertEquals(cliente.getApellido(), "Schenfeld", "apellido incorrecto");
		assertEquals(cliente.getNombre(), "Jonatan", "nombre incorrecto");
		assertEquals(cliente.getTipo(), Tipo.MAYORISTA, "tipo cliente incorrecto");
	}
	
	@Test
	public void agregarClientesTest() {
		RegistroClientes registroClientes = new RegistroClientes();
		Cliente clienteNuevo = new Cliente(100, "Juana", "Ramona", Tipo.MINORISTA);
		registroClientes.agregar(clienteNuevo);
		Cliente cliente = registroClientes.buscarClientePorDni(clienteNuevo.getDni());
		assertEquals(cliente.getDni(), clienteNuevo.getDni(), "dni incorrecto");
		assertEquals(cliente.getApellido(), clienteNuevo.getApellido(), "apellido incorrecto");
		assertEquals(cliente.getNombre(), clienteNuevo.getNombre(), "nombre incorrecto");
		assertEquals(cliente.getTipo(), clienteNuevo.getTipo(), "tipo cliente incorrecto");
	}
}
