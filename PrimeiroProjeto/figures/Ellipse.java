package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Ellipse extends Figure{
			
	public Ellipse (int x, int y, int w, int h, Color contorno, Color fundo){
		super(x,y,w,h,contorno,fundo);
	}
	
	public void paint (Graphics g, boolean focused){
		Graphics2D g2d = (Graphics2D) g;
		if (focused) {
		    g2d.setColor(Color.RED);
		    g2d.drawRect(this.x-1, this.y-1, this.w+2, this.h+2);			
		}
		
		g2d.setColor(fundo);
		g2d.fill(new Ellipse2D.Double(this.x, this.y, this.w, this.h));
		
		g2d.setColor(contorno);
		g2d.draw(new Ellipse2D.Double(this.x,this.y,this.w,this.h));
	}
}
