package figures;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.geom.Arc2D;
import java.awt.geom.Arc2D.Double;

public class Arco extends Figure {
	
    public int inicioangulo, finalangulo; // nao esta no super();

    public Arco (int x, int y, int w, int h, int r, int g, int b,int rC, int gC, int bC, int inicioangulo, int finalangulo) {
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
		
        this.inicioangulo = inicioangulo;
        this.finalangulo = finalangulo;

    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(new Color(this.r,this.g,this.b));
        g2d.fillArc(this.x,this.y, this.w,this.h, this.inicioangulo, this.finalangulo);
      
        g2d.setColor(new Color(this.rC,this.gC,this.bC));
        g2d.drawArc(this.x,this.y, this.w,this.h, this.inicioangulo, this.finalangulo);
    }
}
