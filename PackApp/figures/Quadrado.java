package figures;

import java.awt.*;

public class Quadrado{
	int x, y; // posicao
	int l; // lado do quadrado
	
	public Quadrado (int x, int y, int l){
		this.x = x;
		this.y = y;
		this.l = l;
	}
	

	
	public void paint(Graphics g){

		Graphics2D g2d = (Graphics2D) g;
		g2d.drawRect(this.x, this.y, this.l, this.l);
		
	}
}
