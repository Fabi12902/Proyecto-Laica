package juego;


import java.awt.Color;
import java.awt.Image;

import entorno.*;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	Layka layka;
	Planta[] plantas;
	Auto[] autos;
	Proyectil proyectil;
	BolaFuego bolaFuego;
	int numColumnas = 3; // Número de columnas
	double separacionX = 200; // Espaciado en el eje X
	double[] coordenadasY = new double[numColumnas];
	int dire;
	Color colorFondo = Color.GRAY;
	
	
	// Variables y métodos propios de cada grupo
	Image imgfondo;
	// ...
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Plantas Invasoras - Grupo ... - v1", 800, 600);
		
		// Inicializar lo que haga falta para el juego
		

		imgfondo = Herramientas.cargarImagen("manzana.png") ;
		layka = new Layka (10,10);
		// Generar las coordenadas en el eje Y
		for (int i = 0; i < numColumnas; i++) {
		    coordenadasY[i] = 130; // Valor común en el eje Y
		}
		// ...

		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		entorno.dibujarRectangulo(entorno.ancho() / 2, entorno.alto() / 2, entorno.ancho(), entorno.alto(), 0, colorFondo);
		// Procesamiento de un instante de tiempo
		for (int i = 0; i < numColumnas; i++) {
		    double posX = (i + 1) * separacionX;
		    
		    for (int j = 0; j < 3; j++) {
		        double posY = coordenadasY[i] + (j * 170);
		        entorno.dibujarImagen(imgfondo, posX, posY, 0);
		        
		        // Realizar detección de colisiones con el jugador (o cualquier otro objeto)
		        double jugadorX = layka.getX(); // coordenada X del jugador
		        double jugadorY = layka.getY();// coordenada Y del jugador
		        double jugadorAncho = layka.width;// ancho del jugador
		        double jugadorAlto = layka.height;// alto del jugador

		        double imagenX = posX;
		        double imagenY = posY;
		        double imagenAncho = imgfondo.getWidth(entorno);// ancho de la imagen
		        double imagenAlto = imgfondo.getHeight(entorno);// alto de la imagen

		        if (jugadorX < imagenX + imagenAncho &&
		            jugadorX + jugadorAncho > imagenX &&
		            jugadorY < imagenY + imagenAlto &&
		            jugadorY + jugadorAlto > imagenY) {
		        	
		        	System.out.println("colisioooooooooooon");
		            // Hay una colisión entre el jugador y la imagen en la posición (i, j)
		            // Realiza las acciones necesarias en caso de colisión
		        }
		    }
		}
		if(entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			layka.moverLaykaDer();
			dire = 1;
		}
		if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			layka.moverLaykaIzq();
			dire = 4;
		}

		if (entorno.estaPresionada(entorno.TECLA_ARRIBA)) {	
			layka.moverLaykaArr();
			dire = 2;
		}

		if (entorno.estaPresionada(entorno.TECLA_ABAJO)) {
			layka.moverLaykaAba();
			dire = 3;
		}
	    if (entorno.sePresiono(entorno.TECLA_ESPACIO)) {
	        proyectil = new Proyectil(layka.getX(), layka.getY()); 
	       
	    }
	    // Mueve el proyectil
	    if (proyectil != null) {
	        proyectil.dibujarProyectil(entorno);
	        proyectil.moverProyectil(dire);
	        if (proyectil.getY() < 0 || proyectil.getX()<0) { // Si se va de la pantalla, se elimina
	            proyectil = null;
	        }
	    }
	    
		layka.dibujarse(entorno);

		// ...
		

	}

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
