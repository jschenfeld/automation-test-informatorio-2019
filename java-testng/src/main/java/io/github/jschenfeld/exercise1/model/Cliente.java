package io.github.jschenfeld.exercise1.model;

public class Cliente extends Persona {

	private Tipo tipo;

	public Cliente() {
	}

	public Cliente(Integer dni, String nombre, String apellido, Tipo tipo) {
		super(dni, nombre, apellido);
		this.tipo = tipo;
	}

	public enum Tipo {
		MINORISTA, MAYORISTA;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public boolean valido() {
		boolean valido = super.valido();
		if (null == tipo) {
			valido = false;
		}
		return valido;
	}
	
	@Override
	public String toString() {
		return String.format("%d %s %s %s", getDni(), getApellido(), getNombre(), tipo);
	}
}