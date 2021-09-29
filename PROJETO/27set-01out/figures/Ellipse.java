package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Ellipse extends Figure{
			
	public Ellipse (int x, int y, int w, int h, int r, int g, int b, int rC, int gC, int bC){
		super(x,y,w,h,r,g,b,rC,gC,bC);
	
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
	
	
	public void paint (Graphics g){
		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(new Color(this.r,this.g,this.b));
		g2d.fill(new Ellipse2D.Double(this.x, this.y, this.w, this.h));
		
		g2d.setColor(new Color(this.rC,this.gC,this.bC));
		g2d.draw(new Ellipse2D.Double(this.x,this.y,this.w,this.h));
		
	}
}
