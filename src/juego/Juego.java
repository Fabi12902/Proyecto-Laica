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
		imgfondo = Herramientas.cargarImagen("manzana.png") ;
		layka = new Layka (10,10);
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
        //entorno.dibujarImagen(imgfondo, 0, 0, 0);

		if (entorno.sePresiono(entorno.TECLA_ESPACIO)) {
			
			proyectil = new Proyectil();
		}
		if(entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			layka.mover(3);
		}
		if (entorno.estaPresionada(entorno.TECLA_ARRIBA)) {
			layka.mover(2);
		}

		if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			layka.mover(1);
		}

		if (entorno.estaPresionada(entorno.TECLA_ABAJO)) {
			layka.mover(4);
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
