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
import java.awt.Graphics;
import java.awt.Color;
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
	Point posicaoatual;
	Point posicaoanterior;
	Figure focus = null;
	int aux1, aux2;
	
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
					
				for (Figure fig: figs) {
					if (fig.clicked(evt.getX(),evt.getY())) { 	
						focus = fig; 
						figs.add(focus);				
						figs.remove(focus);		
						repaint();
						break;
					}
					else {
						focus = null;
					}
				}
				posicaoanterior = evt.getPoint();
				repaint();			
				
			}
		}
	);
	
		this.addMouseMotionListener(
			new MouseMotionAdapter(){
				public void mouseDragged (MouseEvent evt) {
					for (Figure fig: figs){
						if (focus == fig) {
							posicaoatual = evt.getPoint();									
							int dx = (int) (posicaoatual.getX() - posicaoanterior.getX());
							int dy = (int) (posicaoatual.getY() - posicaoanterior.getY());
							focus.drag(dx, dy);
							posicaoanterior = posicaoatual;
							
							
							repaint();									
						}
					}					
				}
				
			}
		);
		
        	this.addKeyListener ( 
            		new KeyAdapter() {
						public void keyPressed (KeyEvent evt) {
							posicaodomouse = getMousePosition();
							
							int x = posicaodomouse.x;
							int y = posicaodomouse.y;
							int w = 80;
							int h = 60;
							
							int inicioangulo = rand.nextInt(360);
							int finalangulo = rand.nextInt(360);			

							Color contorno = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
							Color fundo = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));	
							
							if (evt.getKeyChar() == 'e') {		
								figs.add(new Ellipse(x,y,w,h,fundo,contorno));
							}
							else if(evt.getKeyChar() == 'r'){	
								figs.add(new Rect(x,y,w,h,fundo,contorno));
							}
							else if (evt.getKeyChar() == 't') {				
								figs.add(new Triangulo(x,y,w,h,fundo,contorno));
							}
							else if (evt.getKeyChar() == 'y') {
								figs.add(new Arco(x,y,w,h,fundo,contorno,inicioangulo,finalangulo));
							}	repaint();
						
							if (focus != null){
								if (evt.getKeyChar() == 'z' ){
									focus.fundo = new Color(rand.nextInt(255),rand.nextInt(255), rand.nextInt(255));
								}
								if (evt.getKeyChar() == 'x' ){
									focus.contorno = new Color(rand.nextInt(255),rand.nextInt(255), rand.nextInt(255));
								} repaint();
							}	
							
							if(evt.getKeyChar() == 'f') {	
								figs.add(focus);
								figs.remove(focus);
								focus = null;
							}
							
							if (evt.getKeyCode() == evt.VK_DELETE) {
								figs.remove(focus);
								focus = null;
							}
							else if (evt.getKeyChar() == '+'){
								focus.w = focus.w + 10;
								focus.h = focus.h + 10;
							}
							else if(evt.getKeyChar() == '-') {
								if (focus != null && (focus.w > 40 || focus.h > 45)){
								focus.w = focus.w - 10;
								focus.h = focus.h - 10;
								}
							}

							if (focus != null){
								if (evt.getKeyCode() == KeyEvent.VK_UP) {
									focus.y -= 5;
								}
								else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
									focus.y += 5;
								}
								else if  (evt.getKeyCode() == KeyEvent.VK_LEFT){
									focus.x -= 5;
								} 
								else if  (evt.getKeyCode() == KeyEvent.VK_RIGHT){
									focus.x += 5;
								}
							}
						}
					}
		);	repaint();
	this.setTitle("Projeto LP2");
	this.setSize(550, 550);
	this.getContentPane().setBackground(new Color(228, 182, 222));	
}

	public void paint (Graphics g) {
		super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
		
		for (Figure fig: this.figs){
			fig.paint(g);
		}
		if (focus != null){
		    g2d.setColor(Color.RED);
		    g2d.drawRect(focus.x-1, focus.y-1, focus.w+2, focus.h+2);
		}
	}
}
