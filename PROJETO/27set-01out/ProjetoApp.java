import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.geom.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import figures.*;

class ProjetoApp {
	public static void main (String[] args) {
	ProjetoFrame frame = new ProjetoFrame();
	frame.setVisible(true);
	}
}

class ProjetoFrame extends JFrame {
	ArrayList<Figure> figs = new ArrayList<Figure>();
	Random rand = new Random();

	Point posicaodomouse;
	Figure focus = null;	
	
	ProjetoFrame () {
        this.addWindowListener (
		new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
		}
	}
	);
		
		
	this.addMouseListener(
			new MouseAdapter() {
			public void mousePressed (MouseEvent evt) { 
				focus = null;
				int x = evt.getX();
				int y = evt.getY();
				
				for (Figure fig: figs) {
					if (fig.clicked(x,y)) { 
						focus = fig; 
						figs.add(focus);
						figs.remove(focus);														repaint();
						break;
					}
					else {
						focus = null;
						repaint();
					}				
				}
			}
		}
	);
		
		this.addMouseMotionListener(
			new MouseMotionAdapter(){
				public void mouseDragged (MouseEvent evt) {
					for (Figure fig: figs){
						if (focus == fig) { //se o foco estiver na figura
							focus.x = evt.getX() - focus.w;
							focus.y = evt.getY() - focus.h;
							repaint();									
						}
					}
				}
			}
		);
		
        	this.addKeyListener ( 
            		new KeyAdapter() {
                		public void keyPressed (KeyEvent evt) {
					Point posicaodomouse = getMousePosition();
					
					int w = rand.nextInt(70)+10;
					int h = rand.nextInt(70)+10;
	
					int r1 = rand.nextInt(255);
					int g1 = rand.nextInt(255);
					int b1 = rand.nextInt(255);
					
					int r2 = rand.nextInt(255);
					int g2 = rand.nextInt(255);	
					int b2 = rand.nextInt(255);
					
                    			int inicioangulo = rand.nextInt(360);
                    			int finalangulo = rand.nextInt(360);			
						
					if (evt.getKeyChar() == 'e') {		
						figs.add(new Ellipse(posicaodomouse.x,posicaodomouse.y,w,h,r1,g1,b1,r2,g2,b2));
						repaint();  
					}
					
					else if(evt.getKeyChar() == 'r'){	
						figs.add(new Rect(posicaodomouse.x,posicaodomouse.y,w,h,r1,g1,b1,r2,g2,b2));
						repaint(); 
					}
					
					else if (evt.getKeyChar() == 't') {				
						figs.add(new Triangulo(posicaodomouse.x,posicaodomouse.y,w,h,r1,g1,b1,r2,g2,b2));
						repaint();
					}
					
					else if (evt.getKeyChar() == 'y') {
						figs.add(new Arco(posicaodomouse.x,posicaodomouse.y,w,h,r1,g1,b1,r2,g2,b2, inicioangulo, finalangulo));
						repaint();
					}	

					if (evt.getKeyCode() == evt.VK_DELETE) {
						figs.remove(focus);
						focus = null;
						repaint();
					}
					
					else if (evt.getKeyChar() == '+'){
						focus.w = focus.w + 10;
						focus.h = focus.h + 10;
						repaint();
					}
					
					if(evt.getKeyChar() == '-') {		
						focus.w = focus.w - 10;
						focus.h = focus.h - 10;
						repaint();
					}		

				}
			}
		);
		
	
	this.setTitle("Projeto LP2");
	this.setSize(550, 550);
}

	public void paint (Graphics g) {
		super.paint(g);
		
		for (Figure fig: this.figs){
			fig.paint(g);
		}
	}
}


