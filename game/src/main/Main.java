package main;

import bbdd.Conexion;
import vista.Menu;

public class Main {

	public static void main(String[] args) {
		Conexion.conectar();
		new Menu().start();
	}

}
