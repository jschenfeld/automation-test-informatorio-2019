package io.github.jschenfeld.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ColeccionesExample {

	public static void main(String[] args) {
		List<String> nombres = new ArrayList<>();
		nombres.add("Juan");
		nombres.add("Andrea");
		nombres.add("Agustina");
		
		System.out.println("nombre en el indice 1 " + nombres.get(1));
		
		System.out.println("recorrer el array usando indice");
		for (int i = 0; i < nombres.size(); i++) {
			System.out.println(nombres.get(i));
		}
		
		System.out.println("recorrer el array usando indice de atras para adelante");
		for (int i = nombres.size() -1 ; i >= 0; i--) {
			System.out.println(nombres.get(i));
		}
		
		System.out.println("recorrer el array usando foreach");
		for (String nombre : nombres) {
			System.out.println(nombre);
		}
		
		System.out.println("recorrer el array usando iterator");

		Iterator<String> nombresIterator = nombres.iterator();
		while (nombresIterator.hasNext()) {
			System.out.println(nombresIterator.next());
		}
		
		List<String> linkedListNombres = new LinkedList<>();
		linkedListNombres.add("Juan 1");
		linkedListNombres.add("Andrea 1");
		linkedListNombres.add("Agustina 1");
		
		for (String nombre : linkedListNombres) {
			System.out.println(nombre);
		}
		
		Set<Integer> setInt = new HashSet<>();
		setInt.add(1);
		setInt.add(2);
		setInt.add(3);
		
		for (Integer integer : setInt) {
			System.out.println(integer);
		}
		
		Map<String, String> diccionario = new HashMap<>();
		diccionario.put("clave", "valor");
		diccionario.put("clave1", "valor2");

		System.out.println(diccionario.get("clave"));
		Set<String> keys = diccionario.keySet();
		for (String key : keys) {
			System.out.println(diccionario.get(key));
		}
		
		Map<String, String> diccionarioTipoArbol = new TreeMap<>();
		diccionarioTipoArbol.put("clave", "valor");
		diccionarioTipoArbol.put("clave1", "valor2");
 	}
}