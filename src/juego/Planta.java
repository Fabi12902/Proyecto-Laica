package juego;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import entorno.Herramientas;

import entorno.Entorno;

import java.awt.*;

public class Planta {
    private int x;  // Coordenada x de la planta
    private int y; // Coordenada y de la planta
    Image imgPlanta;
    private int width;  // Ancho de la planta
    private int height;  // Alto de la planta
    private int velocidad = 2;  // Velocidad de movimiento
    private boolean activa; // Indica si la planta está en juego
    ArrayList <BolaFuego> bolaFuego; 
    long tiempoUltimoLanzamiento; //indica el ultimo lanzamiento

    public Planta(int x, int y) {
        this.x = x;
        this.y = y;
        this.activa = true;
        this.tiempoUltimoLanzamiento = System.currentTimeMillis();
        imgPlanta = Herramientas.cargarImagen("planta.png");
        
		// Obtener el ancho y alto de la imagen para despues 
	    int width = imgPlanta.getWidth(null);
	    int height = imgPlanta.getHeight(null);
        
    }
    
    public void dibujarPlanta(Entorno entorno) {
    	entorno.dibujarImagen(imgPlanta, this.x, this.y,0, 0.09);
    }

    public void move() {
        // Mueve la planta hacia la derecha (o izquierda) a la velocidad especificada
        x += velocidad;

        // Verifica si la planta ha alcanzado el borde derecho de la pantalla
        if (x > 800) {
            // Si la planta llega al borde derecho, puedes hacer que rebote
            // Cambia la dirección y ajusta la posición para evitar que se salga de la pantalla
            x = 800;
            velocidad = -velocidad; // Cambia la dirección invirtiendo la velocidad
        }

        // Verifica si la planta ha alcanzado el borde izquierdo de la pantalla
        if (x < 0) {
            // Si la planta llega al borde izquierdo, puedes hacer que rebote
            // Cambia la dirección y ajusta la posición para evitar que se salga de la pantalla
            x = 0;
            velocidad= -velocidad; // Cambia la dirección invirtiendo la velocidad
        }
    }
    public void lanzarBolaFuego() {
        long tiempoActual = System.currentTimeMillis();
        long tiempoTranscurridoLanzamiento = tiempoActual - tiempoUltimoLanzamiento;

        if (tiempoTranscurridoLanzamiento >= 2000) {
            bolaFuego.add(new BolaFuego(this.x+2, this.y));
            tiempoUltimoLanzamiento = tiempoActual;
        }
    }

    public Rectangle getBounds() {
        // Devuelve un rectángulo que representa el área ocupada por la planta
        return new Rectangle(x, y, width, height);
    }


    public boolean isActive() {
        return activa;
    }

    public void deactivate() {
        activa = false;
    }
}