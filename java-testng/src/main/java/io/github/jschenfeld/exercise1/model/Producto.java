package io.github.jschenfeld.exercise1.model;

public class Producto {

	private Integer codigo;
	private String descripcion;
	private String unidad;
	private Integer cantidad;

	public Producto() {
	}

	public Producto(Integer codigo, String descripcion, String unidad, Integer cantidad) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.unidad = unidad;
		this.cantidad = cantidad;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s %s", codigo, descripcion, unidad, cantidad);
	}

	public boolean valido() {
		boolean valido = true;
		if (null == codigo || 0 == codigo) {
			valido = false;
		}
		if (null == descripcion || descripcion.isEmpty()) {
			valido = false;
		}
		if (null == unidad || unidad.isEmpty()) {
			valido = false;
		}
		if (null == cantidad || 0 == cantidad) {
			valido = false;
		}

		return valido;
	}
}