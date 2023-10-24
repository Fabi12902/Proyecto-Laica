package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Layka {
	
		// Variables de instancia
		int x;
		int y;
		private int direccion; //1 izquierda 2 Arriba 3 Derecha 4 Abajo.
		Image img1;
		boolean disparando;
		
		public Layka(int x, int y) 
		{
			this.x = x;
			this.y = y;
			direccion = 1;
			img1 = Herramientas.cargarImagen("laika.png");
		}
		
		public void dibujarse(Entorno entorno)
		{
			entorno.dibujarRectangulo(x, y, y, x, direccion, null);
		
			entorno.dibujarImagen(img1, 100, 100, 0);
		}

		public void mover(int direccion) {
		switch (direccion)
		{
		case 1:{
			x= x-1;
			break;
		}
		case 2:
		{
			y=y-1;
			break;
		}
		case 3:
		{
			x=x+1;
			break;
		}
		case 4:
		{
			y=y+1;
			break;
		}
		
		}
		
		
	}
		
		public int getX(){
			return x;
		}
		
		public int getY() {
				return y;
			}
			
		public void setX(int x){
				this.x = x;
			}
			
		public void setY(int y){
				this.y= y;
			}
}
