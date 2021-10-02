package figures;

import java.awt.Graphics;
import java.awt.Color;

import java.awt.Point;

public abstract class Figure{
	public int x, y;
	public int w, h;
	
	public Color contorno;
	public Color fundo;

	public abstract void paint (Graphics g);
	
	public Figure (int x, int y, int w, int h, Color contorno, Color fundo){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;

		this.contorno = contorno;
		this.fundo = fundo;
	}
	
	public Figure(){
		
	}
	
    public boolean clicked (int x, int y) { 
        return (this.x<=x && x<=this.x + 
				this.w && this.y<=y && 
				y<=this.y + this.h);
    }
	
}
