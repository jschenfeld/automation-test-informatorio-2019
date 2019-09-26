package io.github.jschenfeld.automation.services;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

	
	private int id;
	private String nombre;
	
	@JsonProperty("canti dad")
	private int cantidad;

	public Product(int id, String nombre, int cant) {
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCant() {
		return cantidad;
	}

	public void setCant(int cant) {
		this.cantidad = cant;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}