package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Ellipse extends Figure{
	int x, y;
	int w, h;
	
	int r, g, b; 

	int rC, gC, bC;
	
	public Ellipse (int x, int y, int w, int h, int r, int g, int b, int rC, int gC, int bC){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;

		this.r = r;
		this.g = g;
		this.b = b;
		
		this.rC = rC;
		this.gC = gC;
		this.bC = bC;			
	}
	
	
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(new Color(this.r, this.g, this.b));
		g2d.fillOval(this.x,this.y,this.w,this.h);
		
		g2d.setColor(new Color(this.rC,this.gC,this.bC));
		g2d.draw(new Ellipse2D.Double(this.x,this.y,this.w,this.h));
	}
}
