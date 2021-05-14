package modelo;

import bbdd.Conexion;
import beans.Pokemon;
import beans.Planta;
import beans.Fuego;
import beans.Electrico;
import beans.Agua;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Pokemons {
	
	public void insertarPokemon(Pokemon pokemon) {
		
		// Crea un pokemon nuevo en la base de datos
		String nombre = pokemon.getNombre();
		double altura = pokemon.getAltura();
		double peso = pokemon.getPeso();
		String tipo = pokemon.getTipo();
		int ps = pokemon.getPs();
		int ataque = pokemon.getAtaque();
		int defensa = pokemon.getDefensa();
		int velocidad = pokemon.getVelocidad();

		Conexion.ejecutarUpdate("INSERT INTO pokemons (nombre, altura, peso, tipo, ps, ataque, defensa, velocidad) VALUES ('"+nombre+"', '"+altura+"', '"+peso+"', '"+tipo+"', '"+ps+"', '"+ataque+"', '"+defensa+"', '"+velocidad+"');");
		
	}
	
	public void modificarPokemon(String nombrePokemon, int ps, int ataque, int defensa, int velocidad) {
		
		// Modifica los datos de un pokemon de la base de datos
		Conexion.ejecutarUpdate("UPDATE pokemons SET ps='"+ps+"', ataque='"+ataque+"', defensa='"+defensa+"', velocidad='"+velocidad+"' WHERE nombre='"+nombrePokemon+"';");
		
	}
	
	public void eliminarPokemon(String nombrePokemon) {
		
		// Borra un pokemon de la base de datos
		Conexion.ejecutarUpdate("DELETE FROM pokemons WHERE nombre='"+nombrePokemon+"';");
		
	}

	public Pokemon recogerPokemon(String nombrePokemon) {
		
		// Selecciona un pokemon de la base de datos y lo devuelve según el tipo
        ResultSet resultado = Conexion.ejecutarSentencia("SELECT * FROM pokemons WHERE nombre='"+nombrePokemon+"';");
        
        try {
            if(resultado.next()) {
            	
                String nombre = resultado.getString("nombre");
                double altura = resultado.getDouble("altura");
                double peso = resultado.getDouble("peso");
                String tipo = resultado.getString("tipo");
                int ps = resultado.getInt("ps");
                int ataque = resultado.getInt("ataque");
                int defensa = resultado.getInt("defensa");
                int velocidad = resultado.getInt("velocidad");
                
                switch (tipo) {
                    case "Planta":
                        return new Planta(nombre, altura, peso, tipo, ps, ataque, defensa, velocidad);

                    case "Fuego":
                        return new Fuego(nombre, altura, peso, tipo, ps, ataque, defensa, velocidad);

                    case "Agua":
                        return new Agua(nombre, altura, peso, tipo, ps, ataque, defensa, velocidad);

                    case "Electrico":
                        return new Electrico(nombre, altura, peso, tipo, ps, ataque, defensa, velocidad);
                }
                
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return null;
        
    }

    public ArrayList<Pokemon> recogerTodosPokemons() {
    	
    	// Crea un arraylist donde añade a cada uno de los pokemons de la base de datos, y lo devuelve
        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
        ResultSet resultado = Conexion.ejecutarSentencia("SELECT * FROM pokemons;");
        
        try {
            while(resultado.next()) {
            	
                String nombre = resultado.getString("nombre");
                double altura = resultado.getDouble("altura");
                double peso = resultado.getDouble("peso");
                String tipo = resultado.getString("tipo");
                int ps = resultado.getInt("ps");
                int ataque = resultado.getInt("ataque");
                int defensa = resultado.getInt("defensa");
                int velocidad = resultado.getInt("velocidad");
                
                switch (tipo) {
                    case "Planta":
                        pokemons.add(new Planta(nombre, altura, peso, tipo, ps, ataque, defensa, velocidad));
                        break;
                        
                    case "Fuego":
                        pokemons.add(new Fuego(nombre, altura, peso, tipo, ps, ataque, defensa, velocidad));
                        break;
                        
                    case "Agua":
                        pokemons.add(new Agua(nombre, altura, peso, tipo, ps, ataque, defensa, velocidad));
                        break;
                        
                    case "Electrico":
                        pokemons.add(new Electrico(nombre, altura, peso, tipo, ps, ataque, defensa, velocidad));
                        break;       
                }
                
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return pokemons;
        
    }
	
}
