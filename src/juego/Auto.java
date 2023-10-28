package juego;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import entorno.Herramientas;

import entorno.Entorno;

import java.awt.*;

public class Auto {
    private double x;  // Coordenada x del auto
    private double y; // Coordenada y del auto
    Image imgAutoAba, imgAutoArr, imgAutoIzq, imgAutoDer;
    private int width;  // Ancho del auto
    private int height;  // Alto del auto
    private int velocidad = 4;  // Velocidad de movimiento
    private boolean activa; // Indica si el auto está en juego

    public Auto(double x, double y) {
        this.x = x;
        this.y = y;
        this.activa = true;
        imgAutoAba = Herramientas.cargarImagen("autoaba.png");
        imgAutoArr = Herramientas.cargarImagen("autoarr.png");
        imgAutoIzq = Herramientas.cargarImagen("autoizq.png");
        imgAutoDer = Herramientas.cargarImagen("autoder.png");
        
		// Obtener el ancho y alto de la imagen para despues 
	    //this.width = imgAuto.getWidth(null);
	    //this.height = imgAuto.getHeight(null);
        
    }
    
    public void dibujarAuto(Entorno entorno) {
    	
    	entorno.dibujarImagen(imgAutoDer,this.x,this.y,0,0.20);
    }

    public void move() {
        // Mueve el auto hacia la derecha (o izquierda) a la velocidad especificada
        x += velocidad;
        if (x > 800) {
            x = 800;
            velocidad = -velocidad; // Cambia la dirección invirtiendo la velocidad
        }
        if (x < 0) {
            x = 0;
            velocidad= -velocidad; // Cambia la dirección invirtiendo la velocidad
        }
    }

    public boolean isActive() {
        return activa;
    }

    public void deactivate() {
        activa = false;
    }
    
	public double getX(){
		return x;
	}
	
	public double getY() {
		return y;
		}
}