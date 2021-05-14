package beans;

public class Planta extends Pokemon {

	public Planta(String nombre, double altura, double peso, String tipo, int ps, int ataque, int defensa, int velocidad) {
        super(nombre, altura, peso, tipo, ps, ataque, defensa, velocidad);
    }

    public void atacar(Pokemon enemigo) {
    	// Dependiendo del n�mero que se genere, imprime un ataque u otro
    	int habilidad = (int) Math.floor(Math.random() * 4 + 1);
        if(habilidad == 1) {
            System.out.println(this.nombre+" usa Bomba Germen contra "+enemigo.getNombre());
        } else if(habilidad == 2) {
            System.out.println(this.nombre+" usa Hierba Lazo contra "+enemigo.getNombre());
        } else if(habilidad == 3) {
            System.out.println(this.nombre+" usa Hoja Afilada contra "+enemigo.getNombre());
        } else if(habilidad == 4) {
            System.out.println(this.nombre+" usa Latigazo contra "+enemigo.getNombre());
        }
        
        // Seg�n el tipo del enemigo, el da�o se reduce a la mitad o a un tercio
        int ataquePonderado = 0;
        if(enemigo.getTipo().equals("Planta")) {
        	ataquePonderado = this.ataque / 2;
        } else if(enemigo.getTipo().equals("Fuego")) {
        	ataquePonderado = this.ataque / 3;
        } else if(enemigo.getTipo().equals("Agua")) {
        	ataquePonderado = this.ataque / 2;
        } else if(enemigo.getTipo().equals("Electrico")) {
        	ataquePonderado = this.ataque / 2;
        }
        // Pasa el da�o al m�todo de esta clase
        enemigo.danioInflingido(ataquePonderado);

    }
    
    public void danioInflingido(int ataque) {
    	// Pasa el da�o al m�todo del padre
    	super.danioInflingido(ataque);
    	
    }
	
}
