package main;

import bbdd.Conexion;
import vista.Menu;

public class Main {

	public static void main(String[] args) {
		// Crea la conexión con la base de datos
		Conexion.conectar();
		// Crea la vista por consola del programa
		new Menu().start();
	}

}
