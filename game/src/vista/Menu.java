package vista;

import beans.Agua;
import beans.Electrico;
import beans.Fuego;
import beans.Planta;
import beans.Pokemon;
import modelo.Pokemons;
import util.Registro;
import controlador.Combate;
import lib.Leer;

import java.util.ArrayList;

public class Menu {
	
	public void start() {
        
        int opcion = -1;
        while(opcion != 0) {
        	System.out.println("\n## MUNDO POKEMON ##");
        	opcion = menuPrincipal();
        	switch (opcion) {
        	case 1:
        		accionPokedex();
        		break;
        		
        	case 2:
        		accionCombate();
        		break;
        	}
        }
        
    }
	
	public int menuPrincipal() {
		
    	System.out.println("1.- Pokedex");
    	System.out.println("2.- Combate");
    	System.out.println("0.- Salir");
    	return Leer.entero("A donde desea ir?: ");
    	
	}
	
	public int menuPokedex() {
		
    	System.out.println("1.- Registrar Pokemon nuevo");
    	System.out.println("2.- Mejorar stats de un Pokemon");
    	System.out.println("3.- Liberar Pokemon");
    	System.out.println("4.- Listado de Pokemons disponibles");
    	System.out.println("0.- Volver al menu principal");
    	return Leer.entero("Seleccione una accion: ");
    	
	}
	
	public int menuCombate() {
		
    	System.out.println("1.- Elegir dos Pokemons");
    	System.out.println("2.- Empezar el combate");
    	System.out.println("3.- Registro de combates");
    	System.out.println("0.- Volver al menu principal");
    	return Leer.entero("Seleccione una accion: ");
    	
	}
	
	public void accionPokedex() {
		
		int opcion = -1;
		while(opcion != 0) {
			System.out.println("\n~ BIENVENIDO A LA POKEDEX! ~");
			opcion = menuPokedex();
			switch (opcion) {
	    	case 1:
	    		registrarPokemon();
	    		break;
	    		
	    	case 2:
	    		mejorarPokemon();
	    		break;
	    		
	    	case 3:
	    		liberarPokemon();
	    		break;
	    		
	    	case 4:
	    		listaPokemons();
	    		break;
	    	}
		}
		
	}
	
	public void accionCombate() {
		
        Pokemon[] pokemonsRecogidos = new Pokemon[2];
        Combate pelea = null;
        
		int opcion = -1;
		while(opcion != 0) {
			System.out.println("\n~ BIENVENIDO A LOS COMBATES POKEMON! ~");
			opcion = menuCombate();
	        switch (opcion) {
	    	case 1:
	    		seleccionPokemons(pokemonsRecogidos);
	    		break;
	    		
	    	case 2:
	    		Pokemon pokemon1Recogido = pokemonsRecogidos[0];
	    		Pokemon pokemon2Recogido = pokemonsRecogidos[1];
	    		
	    		luchaPokemon(pelea, pokemon1Recogido, pokemon2Recogido);
	    		break;
	    		
	    	case 3:
	    		System.out.println("\n- HISTORIAL DE COMBATES FINALIZADOS -");
	    		new Registro().leerResultado();
	    		System.out.println();
	    		break;
	    	}
		}
		
	}
	
	public void registrarPokemon() {
		
        Pokemon pokemonNuevo;
        
		System.out.println("\nIntroduzca los datos del Pokemon");
		String nombre = Leer.texto("Nombre: ");
		double altura = Double.parseDouble(Leer.texto("Altura: "));
		double peso = Double.parseDouble(Leer.texto("Peso: "));
		String tipo = Leer.texto("Tipo: ");
		int ps = Leer.entero("Ps: ");
		int ataque = Leer.entero("Ataque: ");
		int defensa = Leer.entero("Defensa: ");
		int velocidad = Leer.entero("Velocidad: ");
		
		switch (tipo) {
        	case "Planta":
        		pokemonNuevo = new Planta(nombre, altura, peso, tipo, ps, ataque, defensa, velocidad);
        		new Pokemons().insertarPokemon(pokemonNuevo);
        		break;

        	case "Fuego":
        		pokemonNuevo = new Fuego(nombre, altura, peso, tipo, ps, ataque, defensa, velocidad);
        		new Pokemons().insertarPokemon(pokemonNuevo);
        		break;

        	case "Agua":
        		pokemonNuevo = new Agua(nombre, altura, peso, tipo, ps, ataque, defensa, velocidad);
        		new Pokemons().insertarPokemon(pokemonNuevo);
        		break;

        	case "Electrico":
        		pokemonNuevo = new Electrico(nombre, altura, peso, tipo, ps, ataque, defensa, velocidad);
        		new Pokemons().insertarPokemon(pokemonNuevo);
        		break;
		}
		
		System.out.println(nombre+" nos acompaniara en esta aventura!\n");
		
	}
	
	public void mejorarPokemon() {
		
		String nombre = Leer.texto("\nQue Pokemon ha mejorado? ");
		System.out.println("Introduce los nuevos valores");
		int ps = Leer.entero("Ps: ");
		int ataque = Leer.entero("Ataque: ");
		int defensa = Leer.entero("Defensa: ");
		int velocidad = Leer.entero("Velocidad: ");
		
		new Pokemons().modificarPokemon(nombre, ps, ataque, defensa, velocidad);
		
		System.out.println("Todo entrenamiento tiene sus frutos ;P\n");
		
	}
	
	public void liberarPokemon() {
		
		String nombre = Leer.texto("\nA que Pokemon quieres soltar? ");
		
		new Pokemons().eliminarPokemon(nombre);
		
		System.out.println(nombre+" te dice adios <3\n");
		
	}
	
	public void listaPokemons() {
		
		System.out.println("\n- POKEMONS REGISTRADOS EN LA POKEDEX -\n");
        ArrayList<Pokemon> pokemons = new Pokemons().recogerTodosPokemons();
        System.out.println(pokemons.toString()+"\n");
        
	}
	
	public Pokemon[] seleccionPokemons(Pokemon[] pokemonsRecogidos) {
		
        String nombre1 = Leer.texto("\nNombre del Pokemon aliado: ");
        pokemonsRecogidos[0] = new Pokemons().recogerPokemon(nombre1);
        
        if(pokemonsRecogidos[0] != null) {
        	System.out.println(pokemonsRecogidos[0].toString());
        	
        	String nombre2 = Leer.texto("Nombre del Pokemon contrincante: ");
        	pokemonsRecogidos[1] = new Pokemons().recogerPokemon(nombre2);
        	
        	if(pokemonsRecogidos[1] != null) {
        		System.out.println(pokemonsRecogidos[1].toString());
        	} else {
        		System.out.println("Aun no has descubierto a ese Pokemon!\nVe en su busca :)\n");
        	}
        } else {
        	System.out.println("Aun no has descubierto a ese Pokemon!\nVe en su busca :)\n");
        }
        
        return pokemonsRecogidos;
		
	}
	
	public Combate luchaPokemon(Combate pelea, Pokemon pokemon1Recogido, Pokemon pokemon2Recogido) {
		
		if(pokemon1Recogido != null && pokemon2Recogido != null) {
			System.out.println("\n      ~ 3, 2, 1... COMIENZA EL COMBATE! ~\n");
			
			pelea = new Combate(pokemon1Recogido, pokemon2Recogido, 5);
	        
	        System.out.println("Vida inicial de los Pokemons:");
	        System.out.println(pelea.obtenerStats()+"\n");
	        
	        while(pelea.rondaSiguiente()) {
	        	System.out.println(pelea.obtenerStats()+"\n");
	        }
	        System.out.println(pelea.obtenerStats()+"\n");
	        
	        Pokemon ganador = pelea.comprobarGanador();
	        if(ganador != null) {
	        	System.out.println("El poderoso "+ganador.getNombre()+" ha ganado el combate :D\n");
	        	new Registro().resultadoCombate(pokemon1Recogido, pokemon2Recogido, ganador);
	        } else {
	        	System.out.println("Ambos Pokemons se han debilitado :(\n");
	        	new Registro().resultadoCombate(pokemon1Recogido, pokemon2Recogido, null);
	        }
	        System.out.println("Se ha guardado el resultado automaticamente.\n");
		} else {
			System.out.println("\nEl combate no puede comenzar sin pokemons :/\n");
		}
		
        return pelea;
		
	}
	
}
