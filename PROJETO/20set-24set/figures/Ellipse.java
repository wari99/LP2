package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.event.MouseEvent;

public class Ellipse extends Figure{
	
	Ellipse2D formaellipse;
	
/*	int rC, gC, bC;*/
	
	public Ellipse (int x, int y, int w, int h, int r, int g, int b){
		super(x,y,w,h,r,g,b);
	
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;

		this.r = r;
		this.g = g;
		this.b = b;
		
/*		
		this.rC = rC;
		this.gC = gC;
		this.bC = bC;*/		
		
		this.formaellipse = new Ellipse2D.Double(this.x, this.y, this.w, this.h);
	}
	
	
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(new Color(this.r, this.g, this.b));
		g2d.fillOval(this.x,this.y,this.w,this.h);
		
//		g2d.setColor(new Color(this.rC,this.gC,this.bC));
//		g2d.draw(new Ellipse2D.Double(this.x,this.y,this.w,this.h));
		g2d.draw(this.formaellipse);
		g2d.fill(new Ellipse2D.Double(this.x, this.y, this.w, this.h));
	}
}
