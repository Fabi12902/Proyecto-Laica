package juego;

import java.awt.Image;

import entorno.Herramientas;

public class Planta {
	// Variables de instancia
	double x;
	double y;
	Image img1;
	
	public Planta(int x, int y) 
	{
		this.x = x;
		this.y = y;
		img1 = Herramientas.cargarImagen("");
	}


}
