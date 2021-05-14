package main;

import bbdd.Conexion;
import vista.Menu;

public class Main {

	public static void main(String[] args) {
		// Crea la conexi�n con la base de datos
		Conexion.conectar();
		// Crea la vista por consola del programa
		new Menu().start();
	}

}
