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
					for (Figure figs: figs) {
						if (figs.clicked(x,y)) {
							focus = figs;
							repaint();
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
					for (Figure figs: figs){
							if (focus == figs) { //se o foco estiver na figura
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
					
					int w = rand.nextInt(70);
					int h = rand.nextInt(70);
					
					int teclapressionada = evt.getKeyCode();
					
					int r1 = rand.nextInt(255);
					int g1 = rand.nextInt(255);
					int b1 = rand.nextInt(255);
					
                    if (evt.getKeyChar() == 'e') {
						/*int r2 = rand.nextInt(255);
						int g2 = rand.nextInt(255);
						int b2 = rand.nextInt(255);
						
						figs.add(new Ellipse (x,y, w,h,r1,g1,b1,r2,g2,b2));*/
						
						figs.add(new Ellipse(posicaodomouse.x,posicaodomouse.y,w,h,r1,g1,b1));
                        repaint();  
                    }
					
					if (evt.getKeyChar() == 'r'){	
						figs.add(new Rect(posicaodomouse.x,posicaodomouse.y,w,h,r1,g1,b1));
						repaint(); 
					}
					
                   /* if (evt.getKeyChar() == 't') {
						int r1 = rand.nextInt(255);
						int g1 = rand.nextInt(255);
						int b1 = rand.nextInt(255);						
						figs.add(new Triangulo(posicaodomouse.x,posicaodomouse.y,w,h,r1,g1,b1));
						repaint();
                    }	*/				
				
                    /*if (evt.getKeyChar() == 'y') {
						int x1 = rand.nextInt(400)+100;
						int y1 = rand.nextInt(250);
						
						int x2 = x1 - 40;
						int y2 = rand.nextInt(300);
						
						int x3 = x2 - 40;
						int y3 = y2;
						
						int x4 = x3 - 40;
						int y4 = y1;
						
						figs.add(new Trapezio(x1,y1, x2,y2, x3,y3, x4,y4));
                        repaint();  
                    }*/
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
