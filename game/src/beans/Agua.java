package beans;

public class Agua extends Pokemon {

	public Agua(String nombre, double altura, double peso, String tipo, int ps, int ataque, int defensa, int velocidad) {
        super(nombre, altura, peso, tipo, ps, ataque, defensa, velocidad);
    }

    public void atacar(Pokemon enemigo) {
    	// Dependiendo del número que se genere, imprime un ataque u otro
        int habilidad = (int) Math.floor(Math.random() * 4 + 1);
        if(habilidad == 1) {
            System.out.println(this.nombre+" usa Aqua Cola contra "+enemigo.getNombre());
        } else if(habilidad == 2) {
            System.out.println(this.nombre+" usa Hidro Bomba contra "+enemigo.getNombre());
        } else if(habilidad == 3) {
            System.out.println(this.nombre+" usa Hidro Pulso contra "+enemigo.getNombre());
        } else if(habilidad == 4) {
            System.out.println(this.nombre+" usa Pistola de Agua contra "+enemigo.getNombre());
        }
        
        // Según el tipo del enemigo, el daño se reduce a la mitad o a un tercio
        int ataquePonderado = 0;
    	if(enemigo.getTipo().equals("Planta")) {
    		ataquePonderado = this.ataque / 3;
    	} else if(enemigo.getTipo().equals("Fuego")) {
    		ataquePonderado = this.ataque / 2;
    	} else if(enemigo.getTipo().equals("Agua")) {
    		ataquePonderado = this.ataque / 2;
    	} else if(enemigo.getTipo().equals("Electrico")) {
    		ataquePonderado = this.ataque / 3;
    	}
    	// Pasa el daño al método de esta clase
        enemigo.danioInflingido(ataquePonderado);
        
    }
    
    public void danioInflingido(int ataque) {
    	// Pasa el daño al método del padre
    	super.danioInflingido(ataque);
    	
    }
    
}
