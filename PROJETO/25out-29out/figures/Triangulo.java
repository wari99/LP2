package figures;

import java.awt.*;

import java.awt.Polygon;

public class Triangulo extends Figure{
	
	public Triangulo (int x, int y, int w, int h, Color contorno, Color fundo){
		super(x,y,w,h,contorno,fundo);	
	}
	
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g; 
		
        g2d.setColor(fundo);
		
		int x1[] = {this.x, ((this.w)/2) + (this.x), (this.w) + (this.x)};
        int y1[] = {(this.y + this.h), (this.y + this.h) - (this.h), (this.y + this.h)};		
		
        g2d.fillPolygon(x1, y1, 3);
		
        g2d.setColor(contorno);
        g2d.drawPolygon(x1, y1, 3);				
	}		
}
