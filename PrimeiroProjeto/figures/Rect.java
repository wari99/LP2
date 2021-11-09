package figures;

import java.awt.*;

public class Rect extends Figure{
		
    public Rect (int x, int y, int w, int h, Color contorno, Color fundo) {
		super(x,y,w,h,contorno,fundo);
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
 		if (focused) {
		    g2d.setColor(Color.RED);
		    g2d.drawRect(this.x-1, this.y-1, this.w+2, this.h+2);			
		}
		       
		g2d.setColor(fundo);
		g2d.fillRect(this.x, this.y, this.w, this.h);
		
		g2d.setColor(contorno);
		g2d.drawRect(this.x,this.y, this.w,this.h);
    
	}
}
