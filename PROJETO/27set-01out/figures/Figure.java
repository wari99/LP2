package figures;

import java.awt.Graphics;
import java.awt.Color;

import java.awt.Point;

public abstract class Figure{
	public int x, y;
	public int w, h;
	
	public int r, g, b;
	public int rC, gC, bC;
	
	public abstract void paint (Graphics g);
	
//	public Color corcontorno, corfundo;
	
	public Figure (int x, int y, int w, int h, int r, int g, int b, int rC, int gC, int bC){
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
	
	public Figure(){
		
	}

    public boolean clicked (int x, int y) { //mouse event 
        return (this.x<=x && x<=this.x + 
				this.w && this.y<=y && 
				y<=this.y + this.h);
    }
	
}
