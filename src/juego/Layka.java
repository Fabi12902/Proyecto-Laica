package juego;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;

import entorno.Entorno;
import entorno.Herramientas;

public class Layka {
	
		// Variables de instancia
		double x;
		double y;
		Image img1;
		private Proyectil proyectil;
		boolean disparando;
		int height;
		int width;
	    double radio;
	    int dire;
		
		public Layka(int x, int y) 
		{
			this.x = x;
			this.y = y;
			img1 = Herramientas.cargarImagen("laika.png");
			this.proyectil = null; //al principio no tiene ningun proyectil
			
			// Obtener el ancho y alto de la imagen para despues sacar un radio aproximado
		    int width = img1.getWidth(null);
		    int height = img1.getHeight(null);
		    this.radio = Math.max(width, height) / 2.0;
		}
		
		public void dibujarse(Entorno entorno)
		{
			entorno.dibujarImagen(img1, this.x, this.y,0);
		}

		public void mover(int d, Entorno e)
		{

			this.dire=d;

			if (dire ==0)
			{    
				y -= 3;	
			}
			if (dire ==1)
			{
				x += 3;	
			}
			if (dire ==2)
			{
				y += 3;	
			}
			if (dire ==3)
			{
				x -= 3;	
			}

			if(x > e.ancho()) {
				this.x -= 50;
			}
			if (x < -50.0) {
				this.x+=50.0;	
			}
			if(y > e.alto()) {
				this.y-=50.0;
			}
			if (y < -50.0) {
				this.y+=50.0;	
			}
			
		}
		 public void dispararProyectil() {
		        if (proyectil == null) {
		            double xProyectil = this.x; //el x de origen del proyectil sera el x 
		            double yProyectil = this.y; //el y de origen del proyectil sera el y 
		            proyectil = new Proyectil(xProyectil, yProyectil);
		        }
		    }
		
		
		public double getX(){
			return x;
		}
		
		public double getY() {
				return y;
			}
			
		public void setX(double x){
				this.x = x;
			}
			
		public void setY(double y){
				this.y= y;
			}
}
