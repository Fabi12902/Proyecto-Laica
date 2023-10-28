package juego;


import entorno.Entorno;


import java.awt.Color;

public class BolaFuego {
    private double x;
    private double y;
    private double velocidad;
    double angulo;
    double diametro;
    double radio;

   
    public BolaFuego(double x, double y) {
        this.x = x;
        this.y = y;
        this.velocidad = 4;
        this.angulo=0;
        this.radio=5;
      	  
      
    }

	public void dibujarBolaFuego(Entorno entorno) {
        entorno.dibujarCirculo(x, y, 10, Color.ORANGE);
   
    }
    
    public boolean colisionConLayka(Layka laika) {
        // Verificar si hay una colisión entre el item y la nave
        double distancia = Math.sqrt(Math.pow(x - laika.getX(), 2) + Math.pow(y - laika.getY(), 2));
        double sumaRadios = radio + laika.getRadio();
            
        if (distancia <= sumaRadios) {
          
            return true;
        }
        
        return false;
    }

    public void moverBola() {
        this.y += this.velocidad;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
    
    public double getRadio() {
    	return this.radio;
    	}
}