package juego;


import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

import entorno.*;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	Manzana [] manzanitas;
	Layka layka;
    Planta [] plantaslist;
	Auto [] autos;
	Proyectil proyectil;
	boolean proyectilenpantalla; 
	BolaFuego bolaFuego;
	int numColumnas = 3; // Número de columnas
	double separacionX = 200; // Espaciado en el eje X
	double[] coordenadasY = new double[numColumnas];
	int dire, direpr;
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
		manzanitas = new Manzana[6];
		for (int i = 0; i < manzanitas.length; i++) {
			int columnas = 3;
			int filas = 3;
			int x = (i % columnas) * 230 + 165; // Distribuir horizontalmente.
			int y = (i / filas) * 230 + 170;  // Distribuir verticalmente.
			manzanitas[i] = new Manzana(x, y, 1); 
		}
		plantaslist = new Planta[4];
	    for (int i= 0; i < plantaslist.length; i++) {
	        int x = 50 ;/* Calcula una posición x aleatoria o específica */;
	        int y = 50;/* Calcula una posición y aleatoria o específica */;
	        plantaslist[i] = new Planta(x, y);
	    }
		autos = new Auto[4];
	    for (int i= 0; i < autos.length; i++) {
	        int x = 50 ;/* Calcula una posición x aleatoria o específica */;
	        int y = 250;/* Calcula una posición y aleatoria o específica */;
	        autos[i] = new Auto(x, y);
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
		if (entorno.estaPresionada(entorno.TECLA_DERECHA) && restriccionm(manzanitas,layka) != 1) {
			layka.mover(1, this.entorno);
			dire = 1;
			

		}
		if (entorno.estaPresionada(entorno.TECLA_ARRIBA) && restriccionm(manzanitas,layka) != 0) {
			layka.mover(0, this.entorno);
			dire = 2;

		}	

		if (entorno.estaPresionada(entorno.TECLA_ABAJO)&& restriccionm(manzanitas,layka) != 2) {
			layka.mover(2, this.entorno);
			dire = 3;

		}

		if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)&& restriccionm(manzanitas,layka) != 3 ) {
			layka.mover(3, this.entorno);
			dire = 4;

		}

		for (int i=0; i < manzanitas.length;i++) {
			manzanitas[i].dibujarse(entorno);
		}
	    if (entorno.sePresiono(entorno.TECLA_ESPACIO)) {
	        proyectil = new Proyectil(layka.getX(), layka.getY()); 
	        direpr = dire;
	    }
	    // Mueve el proyectil
	    if (proyectil != null) {
	        proyectil.dibujarProyectil(entorno);
	        proyectil.moverProyectil(direpr);
	        if (proyectil.getY() < 0 || proyectil.getX()<0) { // Si se va de la pantalla, se elimina
	            proyectil = null;
	        }
	    }
	    
		layka.dibujarse(entorno);
		System.out.println(layka.width);
		
	    for (Planta planta : plantaslist) {
	        planta.move();
	        planta.dibujarPlanta(entorno);
	    }
	    for (Auto auto : autos) {
	        auto.move();
	        auto.dibujarAuto(entorno);
	    }

		// ...
		

	}
	private int restriccionm(Manzana[] m, Layka a) {
		for(int i=0; i < m.length;i++) {
			if(restriccion(m[i],a) < 5){
				 return restriccion(m[i],a);
			}
		}
		return 5;
	}

	public int restriccion(Manzana m, Layka a) {
		double zona1=m.x-m.ancho/2;
		double zona2=m.y-m.alto/2;
		double zona0=m.y+m.alto/2;
		double zona3=m.x+m.ancho/2;
		if(a.y > zona2 && a.y < zona0 && a.x > zona1-20 && a.x < zona3) {
			return 1;
		}
		if(a.y > zona2 && a.y < zona0 && a.x > zona1 && a.x < zona3+20) {
			return 3;
		}
		if(a.y > zona2-20 && a.y < zona0 && a.x > zona1 && a.x < zona3) {
			return 2;
		}
		if(a.y > zona2 && a.y < zona0+20 && a.x > zona1 && a.x < zona3) {
			return 0;
		}
		return 5;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
