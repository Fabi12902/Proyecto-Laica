package juego;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;

import entorno.Entorno;
import entorno.Herramientas;

public class Layka {
	
		// Variables de instancia
		int x;
		int y;
		Image img1;
		private Proyectil proyectil;
		boolean disparando;
		int height;
		int width;
	    double radio;
		
		public Layka(int x, int y) 
		{
			this.x = x;
			this.y = y;
			img1 = Herramientas.cargarImagen("laika.png");
			this.proyectil = null; //al principio no tiene ningun proyectil
			
			// Obtener el ancho y alto de la imagen para despues sacar un radio aproximado
		    int widthAst = img1.getWidth(null);
		    int heightAst = img1.getHeight(null);
		    this.radio = Math.max(widthAst, heightAst) / 2.0;
		}
		
		public void dibujarse(Entorno entorno)
		{
			entorno.dibujarImagen(img1, this.x, this.y,0);
		}

		 public void moverLaykaIzq() {
			    if (this.x - 20 > 0) { // lo va moviendoa la izq siempre que no salga del borde
			        this.x -= 4;
			    } else { //si llega al borde rebota
			        this.x = 0 + 20;
			    }
			}

		public void moverLaykaDer() {
			   if (this.x + 10 < 800) { // va moviendo a la derecha sin salirse del borde
			       this.x += 4;
			   } else { 
			       this.x =800 - 10;
		    }
		}
		public void moverLaykaAba() {
			   if (this.y + 10 < 600) { // va moviendo abajo sin salirse del borde
			       this.y += 3;
			   } else { 
			       this.y =600 - 10;
		    }
		}
		public void moverLaykaArr() {
			   if (this.y - 20 > 0) { // va moviendo arriba sin salirse del borde
			       this.y -= 3;
			   } else { 
			       this.y = 0 + 10;
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
