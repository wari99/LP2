package figures;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;
import ivisible.IVisible;

public abstract class Figure implements IVisible{
	public int x, y;
	public int w, h;
	
	public Color contorno;
	public Color fundo;

	public abstract void paint (Graphics g, boolean focused);
	
	public Figure (int x, int y, int w, int h, Color contorno, Color fundo){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;

		this.contorno = contorno;
		this.fundo = fundo;	
	}
    public void drag (int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }	
	
    public boolean clicked (int x, int y) { //mouse event 
        return (this.x<=x && x<=this.x + 
				this.w && this.y<=y && 
				y<=this.y + this.h);
    }
	
}
