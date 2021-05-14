package beans;

public class Fuego extends Pokemon {

	public Fuego(String nombre, double altura, double peso, String tipo, int ps, int ataque, int defensa, int velocidad) {
        super(nombre, altura, peso, tipo, ps, ataque, defensa, velocidad);
    }

    public void atacar(Pokemon enemigo) {
    	
    	int habilidad = (int) Math.floor(Math.random() * 4 + 1);
        if(habilidad == 1) {
            System.out.println(this.nombre+" usa Colmillo Igneo contra "+enemigo.getNombre());
        } else if(habilidad == 2) {
            System.out.println(this.nombre+" usa Llamarada contra "+enemigo.getNombre());
        } else if(habilidad == 3) {
            System.out.println(this.nombre+" usa Punio Fuego contra "+enemigo.getNombre());
        } else if(habilidad == 4) {
            System.out.println(this.nombre+" usa Sofoco contra "+enemigo.getNombre());
        }
        
        int ataquePonderado = 0;
        if(enemigo.getTipo().equals("Planta")) {
        	ataquePonderado = this.ataque / 2;
        } else if(enemigo.getTipo().equals("Fuego")) {
        	ataquePonderado = this.ataque / 2;
        } else if(enemigo.getTipo().equals("Agua")) {
        	ataquePonderado = this.ataque / 3;
        } else if(enemigo.getTipo().equals("Electrico")) {
        	ataquePonderado = this.ataque / 3;
        }
        
        enemigo.danioInflingido(ataquePonderado);
        
    }
    
    public void danioInflingido(int ataque) {
    	
    	super.danioInflingido(ataque);
    	
    }
	
}
