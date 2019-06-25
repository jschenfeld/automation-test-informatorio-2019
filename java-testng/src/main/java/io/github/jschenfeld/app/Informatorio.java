package io.github.jschenfeld.app;

import io.github.jschenfeld.model.Estudiante;
import io.github.jschenfeld.model.Persona;

public class Informatorio {

	public static String PRUEBAS_AUTOMATIZADAS = "PRUEBAS_AUTOMATIZADAS";
	public static void main(String[] args) {
		 Persona persona = new Estudiante();
		((Estudiante) persona).mensaje();
		Estudiante estudiante = new Estudiante();
		estudiante.mensaje();
	}
	
	public enum Materia {
		PRUEBAS_AUTOMATIZADAS("Pruebas Automatizadas", 1) {
			@Override
			public String format() {
				return null;
			}
		},
		CALIDAD("Pruebas Automatizadas",2) {
			@Override
			public String format() {
				// TODO Auto-generated method stub
				return null;
			}
		},
		INGLES("Pruebas Automatizadas",3) {
			@Override
			public String format() {
				// TODO Auto-generated method stub
				return null;
			}
		},
		BASE_DE_DATOS("Pruebas Automatizadas",4) {
			@Override
			public String format() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		private String nombreBonito;
		private int id;
		
		private Materia(String nombre, int id) {
			this.nombreBonito = nombre;
			this.id = id;
		}

		public String getNombreBonito() {
			return nombreBonito;
		}

		public int getId() {
			return id;
		}
		
		public abstract String format();
	}
}