package io.github.jschenfeld.app;

public class SwitchExample {

	public static void main(String[] args) {
		int day = 4;
		Days myEnum = Days.getDay(day);
		System.out.println(myEnum.getNombre());
		
		switch (day) {
		case 1:
			System.out.println("Monday");
			break;
		case 2:
			System.out.println("Tuesday");
			break;
		case 3:
			System.out.println("Wednesday");
			break;
		case 4:
			System.out.println("Thursday");
			break;
		case 5:
			System.out.println("Friday");
			break;
		case 6:
			System.out.println("Saturday");
			break;
		case 7:
			System.out.println("Sunday");
			break;
		}
	}

	public enum Days {
		LUNES("Lunes", 1), 
		MARTES("Martes", 2),
		MIERCOLES("Miercoles", 3),
		JUEVES("Jueves", 4);

		private String nombre;
		private int id;

		private Days(String nombre, int id) {
			this.id = id;
			this.nombre = nombre;
		}

		public String getNombre() {
			return nombre;
		}

		public int getId() {
			return id;
		}
		
		public static Days getDay(int id) {
			Days[] array = Days.values();
			for (int i = 0; i < array.length; i++) {
				if(id == array[i].getId()) {
					return array[i];
				}
			}
			return null;
		}
	}
}