package io.github.jschenfeld.exercise1.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.github.jschenfeld.exercise1.model.Producto;
import io.github.jschenfeld.exercise1.utils.FileUtils;

public class RegistroProductos {

	private static List<Producto> productos = new ArrayList<>();
	private static final String DATABASE = "productos.csv";

	public RegistroProductos() {
		cargarProductosDesdeArchivo();
	}

	private void cargarProductosDesdeArchivo() {
		List<Map<String, String>> rawData = FileUtils.readCSV(DATABASE);
		for (Map<String, String> record : rawData) {
			Producto producto = new Producto();
			producto.setCodigo(Integer.parseInt(record.get("codigo")));
			producto.setDescripcion(record.get("descripcion"));
			producto.setUnidad(record.get("unidad"));
			producto.setCantidad(Integer.parseInt(record.get("cantidad")));
			productos.add(producto);
		}
	}

	public void agregar(Producto producto) {
		if (null == producto || !producto.valido()) {
			System.out.println("verificar los datos del Producto.");
		} else {
			Producto productoExistente = buscarProductoPorCodigo(producto.getCodigo());
			if (null != productoExistente) {
				System.out.println(String.format("Ya existe un producto con codigo %d.", producto.getCodigo()));
			} else {
				productos.add(producto);
			}
		}
	}

	public void listar() {
		if (productos.isEmpty()) {
			System.out.println("La lista de Productos esta vacia.");
		} else {
			System.out.println("===================================");
			System.out.println("Listar Productos");
			for (Producto producto : productos) {
				System.out.println(producto.toString());
			}
			System.out.println("===================================");
		}
		System.out.println();
	}

	public void eliminar(Integer codigo) {
		Producto productoAeliminar = buscarProductoPorCodigo(codigo);

		if (null == productoAeliminar) {
			System.out.println(String.format("El producto con codigo %d no se encuentra registrado.", codigo));
		} else {
			productos.remove(productoAeliminar);
			System.out.println(String.format("El producto con codigo %d ha sido eliminado.", codigo));
		}
	}

	public static Producto buscarProductoPorCodigo(Integer dni) {
		for (Producto producto : productos) {
			if (producto.getCodigo().equals(dni)) {
				return producto;
			}
		}
		return null;
	}

	public static List<String> validarStock(List<Producto> productos) {
		List<String> errores = new ArrayList<>();
		for (Producto producto : productos) {
			Producto productoStock = buscarProductoPorCodigo(producto.getCodigo());
			if (null == productoStock) {
				String mensaje = String.format("El producto %s no fue encontrado", producto.getCodigo());
				errores.add(mensaje);
			} else if (productoStock.getCantidad() < producto.getCantidad()) {
				String mensaje = String.format("Producto %s insuficiente, se pidio %d %s y en stock hay %d %s",
						productoStock.getCodigo(), producto.getCantidad(), producto.getUnidad(),
						productoStock.getCantidad(), productoStock.getUnidad());
				errores.add(mensaje);
			}
		}
		return errores;
	}

	public static void actualizarStock(List<Producto> productos) {
		// TODO Auto-generated method stub

	}
}