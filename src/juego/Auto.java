package juego;

import java.awt.Image;

import entorno.Herramientas;

public class Auto {
	// Variables de instancia
	double x;
	double y;
	Image img1;
	
	public Auto(int x, int y) 
	{
		this.x = x;
		this.y = y;
		img1 = Herramientas.cargarImagen("");
	}


}
