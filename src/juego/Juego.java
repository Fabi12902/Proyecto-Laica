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
	
	
	// Variables y métodos propios de cada grupo
	Image imgfondo;
	// ...
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Plantas Invasoras - Grupo ... - v1", 800, 600);
		
		// Inicialzar lo que haga falta para el juego
		imgfondo = Herramientas.cargarImagen("Red-Sports-Car-on-Road-Pixel-Art-Graphics-59568274-1.jpg") ;
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
		// Procesamiento de un instante de tiempo
        entorno.dibujarImagen(imgfondo, 0, 0, 0.5);

		if (entorno.sePresiono(entorno.TECLA_ESPACIO)) {
			
			proyectil = new Proyectil();
		}

		// ...
		

	}

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
