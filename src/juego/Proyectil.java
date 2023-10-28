package juego;


import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;


public class Proyectil {
	//atributos
    private double x;
    private double y;
    double angulo;
    private static final double velocidad = 10; //para que sea fijo
    private double radio;
    Image imgProyectil;

    //constructor
    public Proyectil(double x, double y) {
        this.x = x;
        this.y = y;
        this.angulo=0;
        imgProyectil = Herramientas.cargarImagen("proyectil.png");
   
        //saco el radio aprox del proyectil para despues usarlo en el metodo de colision
        double ancho=imgProyectil.getWidth(null);
        double alto=imgProyectil.getHeight(null);
               
        this.radio=Math.max(ancho, alto)/2;
        
        

    }
    //metodos del objeto Proyectil
    public void dibujarProyectil(Entorno entorno) {
    	entorno.dibujarImagen(imgProyectil,x,y,angulo);
    }

    public void moverProyectil(int direccion) { 
        switch(direccion) {
        case 1:
        	x += velocidad;
        	break;
        case 2:
        	y -= velocidad;
        	break;
        case 3:
        	y += velocidad;
        	break;
        case 4:
        	x -= velocidad;
        	break;
        }
    }
    
//getters    
    public double getX() {
    	return this.x;
    }
 
    
    public double getY() {
        return this.y;
    }
	
    public double getRadio() {
		return radio;
	}


  


	 

}