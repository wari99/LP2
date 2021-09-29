package figures;

import java.awt.*;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Triangulo extends Figure{
  
	int x,y;
	int w,h;
	public int[] x1, x2;
  
	Polygon formatriangulo;
	  
	public Triangulo (int x, int y, int w, int h, int r, int g, int b,int rC, int gC, int bC){
		super(x,y,w,h,r,g,b,rC,gC,bC);

		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
		this.r = r;
		this.g = g;
		this.b = b;

		this.rC = rC;
		this.bC = bC;
		this.gC = gC;
		
		int x1[]= { this.x,
					((this.w)/2) + (this.x),
					(this.w) + (this.x)
		};
		
		int x2[]= { this.y, 
					((this.y) - (this.h)),
					this.y
		};
		
		this.formatriangulo = new Polygon (x1, x2, 3); // eixo x eixo y n0 de pts
}
	
	public void paint(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g; 
		
        g2d.setColor(new Color(this.r,this.g,this.b));
        g2d.fillPolygon(this.formatriangulo);
		
        g2d.setColor(new Color(this.rC,this.gC,this.bC));
        g2d.draw(this.formatriangulo);		
		
	}	
}
