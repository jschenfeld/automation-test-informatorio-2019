package io.github.jschenfeld.exercise1.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	
	private static Integer ultimoId = 0;
	private Integer id;
	private Cliente cliente;
	private List<Producto> productos = new ArrayList<>();
	
	public Pedido(Cliente cliente) {
		if(null == cliente) {
			throw new RuntimeException("El cliente no es valido");
		}
		this.id = ++Pedido.ultimoId;
		this.cliente = cliente;
	}
	
	public Integer getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public List<Producto> getProductos() {
		return productos;
	}
	
	public void agregar(Integer codigo, Integer cantidad) {
		System.out.println("Codigo " + codigo);
		System.out.println("Cantidad " + cantidad);
		Producto producto = new Producto();
		producto.setCantidad(cantidad);
		producto.setCodigo(codigo);
		this.productos.add(producto);
	}
	
	public void listarProductos() {
		System.out.println("Productos");
		for (Producto producto : productos) {
			System.out.println(producto.toString());
		}
	}
	
	
}