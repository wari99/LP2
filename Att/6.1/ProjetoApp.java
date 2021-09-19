// Adaptando o codigo para usar uma lista única de Figures. 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.geom.*;

import figures.*;


class ProjetoApp {
    public static void main (String[] args) {
        ProjetoFrame frame = new ProjetoFrame();
        frame.setVisible(true);
    }
}

class ProjetoFrame extends JFrame {
	
	//new
	
	ArrayList<Figure> figs = new ArrayList<Figure>();
	Random rand = new Random();
	
    ProjetoFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    if (evt.getKeyChar() == 'e') {
                        int x = rand.nextInt(350);
                        int y = rand.nextInt(350);
                        int w = rand.nextInt(50);
                        int h = rand.nextInt(50);
						
						figs.add(new Ellipse (x,y, w,h));
                        repaint();  
                    }
					
					if (evt.getKeyChar() == 'r'){
						int x = rand.nextInt(350);
						int y = rand.nextInt(350);
						int w = rand.nextInt(50);
						int h = rand.nextInt(50);

						figs.add(new Rect(x,y,w,h));
						repaint(); 
					}
					
                    if (evt.getKeyChar() == 't') {
						int x1 = rand.nextInt(350);
						int y1 = rand.nextInt(350);
						
						int x2 = rand.nextInt(350);
						int y2 = rand.nextInt(350);
						
						int x3 = rand.nextInt(350);
						int y3 = rand.nextInt(350);
						
                        figs.add(new Triangulo(x1,y1, x2,y2, x3,y3));
                        repaint();  
                    }					
				
                    if (evt.getKeyChar() == 'y') {
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
