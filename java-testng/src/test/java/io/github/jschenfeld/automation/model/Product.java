package io.github.jschenfeld.automation.model;

public class Product {

	private Integer id;
	private String nombre;
	private Integer cantidad;

	public Product() {
	}

	public Product(int id, String nombre, int cantidad) {
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}