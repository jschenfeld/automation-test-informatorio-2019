package io.github.jschenfeld.exercise1.model;

public abstract class Persona {

	private Integer dni;
	private String nombre;
	private String apellido;

	public Persona() {
	}

	public Persona(Integer dni, String nombre, String apellido) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}

	public boolean valido() {
		boolean valido = true;
		if (null == dni || 0 == dni) {
			valido = false;
		}
		if (null == apellido || apellido.isEmpty()) {
			valido = false;
		}
		if (null == nombre || nombre.isEmpty()) {
			valido = false;
		}
		return valido;
	}
}