//2.2
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;


class PaintApp {
	public static void main (String[] args){
		PaintFrame frame = new PaintFrame();
		frame.setVisible(true);
		
	}
}

class PaintFrame extends JFrame{
	Ellipse e1, e2, e3;
	
	PaintFrame(){
		this.addWindowListener(
			new WindowAdapter() {
				public void windowClosing (WindowEvent e) {
					System.exit(0);
				}
			}
		);
		this.setTitle("Painting Figures");
		this.setSize(350,350);
	
		this.e1 = new Ellipse(200,100,80,160,
							48, 226, 253  ,
						    232, 246, 42 );
							
		this.e2 = new Ellipse(110,100,170,50,
							97, 120, 196  ,
							252, 184, 255);
		this.e3 = new Ellipse(50,170,180,20,
							88, 51, 137,
							124, 199, 139 );							   
	}
	
	public void paint (Graphics g){
		super.paint(g);
		this.e1.paint(g);
		this.e2.paint(g);
		this.e3.paint(g);
	}
}

class Ellipse{
	int x, y;
	int w, h;
	
	int r,g,b;                 //RGB valores
	int backr, backg, backb;  //RGB fundo
	
	Ellipse (int x, int y, int w, int h, int r, int g, int b, int backr, int backg, int backb){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.r = r; this.g = g; this.b = b; 
		this.backr = backr; this.backg = backg; this.backb = backb; 
	}
	

	void paint (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(new Color(this.r, this.g, this.b));
		g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
		
		g2d.setColor(new Color(this.backr, this.backg, this.backb));
		g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
	}

}
