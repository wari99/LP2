package figures;

import java.awt.*;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import java.awt.event.MouseEvent;

public class Triangulo extends Figure{
  
	int x, y;
  
	int w, h;
	int r, g, b;
	public int[] x1, x2;
  
	Polygon formatriangulo;
  
	
	public Triangulo (int x, int y, int w, int h, int r, int g, int b){
		super(x,y,w,h);

		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
		this.r = r;
		this.g = g;
		this.b = b;
				
		int x1[]= { this.x,
					((this.w)/2) + (this.x),
					(this.w) + (this.x)
		};
		
		int x2[]= { this.y, 
					((this.y) - (this.h)),
					this.y
		};
		
		this.formatriangulo = new Polygon (x1, x2, 3);
}
	
	public void paint(Graphics g){

		Graphics2D g2d = (Graphics2D) g;
		
        g2d.setColor(new Color(this.r,this.g,this.b));
		g2d.fillPolygon(this.formatriangulo);
		
		g2d.draw(this.formatriangulo);
	
	}
}
