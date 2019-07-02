package io.github.jschenfeld.exercise1;

import io.github.jschenfeld.exercise1.business.RegistroClientes;
import io.github.jschenfeld.exercise1.business.RegistroPedidos;
import io.github.jschenfeld.exercise1.business.RegistroProductos;
import io.github.jschenfeld.exercise1.model.Cliente;
import io.github.jschenfeld.exercise1.model.Cliente.Tipo;
import io.github.jschenfeld.exercise1.model.Pedido;
import io.github.jschenfeld.exercise1.model.Producto;

public class SistemaApp {

	public static void main(String[] args) {
		RegistroClientes clientes =  new RegistroClientes();
		RegistroProductos productos = new RegistroProductos();
		
		clientes.agregar(new Cliente(4, "Gabriela", "Lopez", Tipo.MINORISTA));
		clientes.listar();
		productos.agregar(new Producto(7, "Base para notebook", "unidades", 15));
		productos.listar();

		RegistroPedidos registroPedidos = new RegistroPedidos();
		Pedido pedido = new Pedido(clientes.buscarClientePorDni(1));
		pedido.agregar(1, 10);
		pedido.agregar(2, 3);
		pedido.agregar(3, 5);
		registroPedidos.agregar(pedido);
		
	}
}