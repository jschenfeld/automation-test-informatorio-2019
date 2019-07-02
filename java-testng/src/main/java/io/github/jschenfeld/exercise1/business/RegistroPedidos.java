package io.github.jschenfeld.exercise1.business;

import java.util.ArrayList;
import java.util.List;

import io.github.jschenfeld.exercise1.model.Pedido;

public class RegistroPedidos {

	private static List<Pedido> pedidos = new ArrayList<>();

	public void agregar(Pedido pedido) {
		if (null == pedido) {
			System.out.println("verificar los datos del Pedido.");
		} else {
			Pedido pedidoExistente = buscarPedidoPorId(pedido.getId());
			if (null != pedidoExistente) {
				System.out.println(String.format("Ya existe un pedido con id %d.", 
						pedido.getId()));
			} else {
				actualizarStock(pedido);					
			}
		}
	}

	public void actualizarStock(Pedido pedido) {
		List<String> errores = RegistroProductos.validarStock(pedido.getProductos());
		if(errores.isEmpty()) {
			RegistroProductos.actualizarStock(pedido.getProductos());
			pedidos.add(pedido);
		} else {
			errores.forEach(System.out::println);
		}
	}

	public void listar() {
		if (pedidos.isEmpty()) {
			System.out.println("La lista de pedidos esta vacia.");
		} else {
			for (Pedido pedido : pedidos) {
				System.out.println(String.format("%s %s", pedido.getId(), pedido.getCliente().getDni()));
				pedido.listarProductos();
			}
		}
	}

	public void eliminar(Integer id) {
		Pedido pedidoAeliminar = buscarPedidoPorId(id);

		if (null == pedidoAeliminar) {
			System.out.println(String.format("El pedido %d no se encuentra registrado.", id));
		} else {
			pedidos.remove(pedidoAeliminar);
			System.out.println(String.format("El pedido %d ha sido eliminado.", id));
		}
	}

	public Pedido buscarPedidoPorId(Integer id) {
		for (Pedido pedido : pedidos) {
			if (pedido.getId().equals(id)) {
				return pedido;
			}
		}
		return null;
	}
}