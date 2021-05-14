package controlador;

import beans.Pokemon;

public class Combate {

	Pokemon pokemon1;
    Pokemon pokemon2;
    int rondas;

    public Combate(Pokemon pokemon1, Pokemon pokemon2, int rondas) {
    	
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.rondas = rondas;
        
    }
    
    public void empezarCombate(int rondasTotales) {
    	
    	this.rondas = rondasTotales;
    	
    }

    public Pokemon comprobarGanador() {
    	
    	// Compara la vida de ambos pokemons y devuelve el pokemon con mayor vida
    	int pokemon1Ps = pokemon1.getPs();
    	int pokemon2Ps = pokemon2.getPs();
    	if(pokemon1Ps > pokemon2Ps && pokemon1Ps > 0) {
    		return pokemon1;
    	} else if(pokemon2Ps > pokemon1Ps && pokemon2Ps > 0) {
    		return pokemon2;
    	}
    	
    	return null;
    	
    }
    
    public boolean rondaSiguiente() {
    	
    	// Los pokemons tienen un 50% de atacar antes que el otro
    	// Si un pokemon debilita al otro, este último no realizará ataque
    	// Habrá siguiente ronda mientras la vida de ambos pokemons sea mayor que 0
    	boolean haySiguiente = false;
    	this.rondas -= 1;
    	
    	if(Math.random() > 0.5) {
    		pokemon1.atacar(pokemon2);
    		if(pokemon2.getPs() > 0) {
    			pokemon2.atacar(pokemon1);
    		}
    		haySiguiente = pokemon1.getPs() > 0 && pokemon2.getPs() > 0;
    	} else {
    		pokemon2.atacar(pokemon1);
    		if(pokemon1.getPs() > 0) {
    			pokemon1.atacar(pokemon2);
    		}
    		haySiguiente = pokemon2.getPs() > 0 && pokemon1.getPs() > 0;
    	}
    	
    	return this.rondas <= 0 ? false : haySiguiente;
    	
    }
    
    public String obtenerStats() {
    	
    	String pokemon1Stats = pokemon1.getNombre()+" --> "+pokemon1.getPs()+"ps";
    	String pokemon2Stats = pokemon2.getNombre()+" --> "+pokemon2.getPs()+"ps";
    	return "\t- "+pokemon1Stats+"\t- "+pokemon2Stats;
    	
    }
    
}
