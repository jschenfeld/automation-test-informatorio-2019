package io.github.jschenfeld.exercise1.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.github.jschenfeld.exercise1.model.Cliente;
import io.github.jschenfeld.exercise1.model.Cliente.Tipo;
import io.github.jschenfeld.exercise1.utils.FileUtils;

public class RegistroClientes {

	private List<Cliente> clientes = new ArrayList<>();
	private static final String DATABASE = "clientes.csv";
	
	public RegistroClientes() {
		cargarClientesDesdeArchivo();
	}

	private void cargarClientesDesdeArchivo() {
		List<Map<String, String>> rawData = FileUtils.readCSV(DATABASE);
		for (Map<String, String> record : rawData) {
			Cliente cliente = new Cliente();
			cliente.setDni(Integer.parseInt(record.get("dni")));
			cliente.setNombre(record.get("nombre"));
			cliente.setApellido(record.get("apellido"));
			cliente.setTipo(Tipo.valueOf(record.get("tipo")));
			clientes.add(cliente);
		}
	}

	public void agregar(Cliente cliente) {
		if (null == cliente || !cliente.valido()) {
			System.out.println("verificar los datos del cliente.");
		} else {
			Cliente clienteExistente = buscarClientePorDni(cliente.getDni());
			if (null != clienteExistente) {
				System.out.println(String.format("Ya existe un cliente con dni %d.", 
						cliente.getDni()));
			} else {
				clientes.add(cliente);
			}
		}
	}

	public void listar() {
		if (clientes.isEmpty()) {
			System.out.println("La lista de clientes esta vacia.");
		} else {
			System.out.println("===================================");
			System.out.println("Listar Clientes");
			for (Cliente cliente : clientes) {
				System.out.println(cliente.toString());
			}
			System.out.println("===================================");
		}
		System.out.println();
	}

	public void eliminar(Integer dni) {
		Cliente clienteAeliminar = buscarClientePorDni(dni);

		if (null == clienteAeliminar) {
			System.out.println(String.format("El cliente con dni %d no se encuentra registrado.", dni));
		} else {
			clientes.remove(clienteAeliminar);
			System.out.println(String.format("El cliente con dni %d ha sido eliminado.", dni));
		}
	}

	public Cliente buscarClientePorDni(Integer dni) {
		for (Cliente cliente : clientes) {
			if (cliente.getDni().equals(dni)) {
				return cliente;
			}
		}
		return null;
	}
}