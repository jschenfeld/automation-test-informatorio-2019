package io.github.jschenfeld.model;

import io.github.jschenfeld.app.Informatorio.Materia;

public class Profesor extends Persona {
	// con la palabra reservada extends indicamos que Profesor hereda de Persona

	private Materia materia;

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
}