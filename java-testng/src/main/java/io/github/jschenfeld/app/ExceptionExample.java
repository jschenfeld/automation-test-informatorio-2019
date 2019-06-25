package io.github.jschenfeld.app;

import bsh.ParseException;

public class ExceptionExample {

	public static void main(String[] args){
		ExceptionExample example = new ExceptionExample();
		try {
			example.getAlgo();
		} catch (ParseException e) {
			System.out.println("corregi el archivo.");
		}
		
		System.out.println("sigo ejecutando el programa sin el arhivo.");
	}
	
	public String getAlgo() throws ParseException {
		throw new ParseException("no se pudo leer el archivo porque el formato no era el esperado");
	}

}
