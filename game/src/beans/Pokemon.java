package beans;

public abstract class Pokemon {

	String nombre;
    double altura;
    double peso;
    String tipo;
    int ps;
    int ataque;
    int defensa;
    int velocidad;
    
    public Pokemon(String nombre, double altura, double peso, String tipo, int ps, int ataque, int defensa, int velocidad) {
        this.nombre = nombre;
        this.altura = altura;
        this.peso = peso;
        this.tipo = tipo;
        this.ps = ps;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public double getAltura() {
        return this.altura;
    }
    
    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    public double getPeso() {
        return this.peso;
    }
    
    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public int getPs() {
        return this.ps;
    }
    
    public void setPs(int ps) {
        this.ps = ps;
    }
    
    public int getAtaque() {
        return this.ataque;
    }
    
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    
    public int getDefensa() {
        return this.defensa;
    }
    
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
    
    public int getVelocidad() {
        return this.velocidad;
    }
    
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public abstract void atacar(Pokemon enemigo);
    
    public void danioInflingido(int ataque) {
    	
    	this.ps = this.ps - ataque > 0 ? this.ps - ataque : 0;
    }
    
    @Override
    public String toString() {
        return "[ Nombre: "+nombre+", Altura: "+altura+"m, Peso: "+peso+"kg, Tipo: "+tipo+", PS: "
        +ps+", Ataque: "+ataque+", Defensa: "+defensa+", Velocidad: "+velocidad+" ]\n";
    }
	
}
