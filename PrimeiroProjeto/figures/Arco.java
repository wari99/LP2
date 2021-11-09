package figures;

import java.awt.*;

public class Arco extends Figure {
	
    public int inicioangulo, finalangulo; 

    public Arco (int x, int y, int w, int h, Color contorno, Color fundo, int inicioangulo, int finalangulo) {
		super(x,y,w,h,contorno,fundo);
        this.inicioangulo = inicioangulo;
        this.finalangulo = finalangulo;
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
		if (focused) {
		    g2d.setColor(Color.RED);
		    g2d.drawRect(this.x-1, this.y-1, this.w+2, this.h+2);			
		}
				
        g2d.setColor(fundo);
        g2d.fillArc(this.x,this.y, this.w,this.h, this.inicioangulo, this.finalangulo);
      
        g2d.setColor(contorno);
        g2d.drawArc(this.x,this.y, this.w,this.h, this.inicioangulo, this.finalangulo);
    }
}
