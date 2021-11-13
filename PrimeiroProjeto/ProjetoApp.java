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
	ArrayList<Button> buts = new ArrayList<Button>();
	
	Random rand = new Random();
	Point posicaodomouse; Point posicaoatual; Point posicaoanterior;

	Figure focus = null;
    Button focus_but = null;	
	
	ProjetoFrame () {
        this.addWindowListener (
		new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
		}
	});	
	
	buts.add(new Button(1, new Arco(0,0,0,0,Color.PINK,Color.PINK,20,50)));
	buts.add(new Button(2, new Rect(0,0,0,0,Color.PINK,Color.PINK)));
	buts.add(new Button(3, new Ellipse(0,0,0,0,Color.PINK,Color.PINK)));
	buts.add(new Button(4, new Triangulo(0,0,0,0,Color.PINK,Color.PINK)));	
		
	this.addMouseListener(
		new MouseAdapter() {
			public void mousePressed (MouseEvent evt) {
				posicaodomouse = getMousePosition();
				focus = null;
				Color contorno = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
				Color fundo = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));	
									
				for (int i=0; i< buts.size(); i++) {
					if ((focus == null) && (focus_but != null)){
						if(focus_but == buts.get(1)){
							Figure fig = new Rect(posicaodomouse.x, posicaodomouse.y,80,60,fundo,contorno);
							figs.add(fig);
							focus = fig;
							focus_but = null;
						}
						else if(focus_but == buts.get(2)){
							Figure fig = new Ellipse(posicaodomouse.x, posicaodomouse.y,80,60,fundo,contorno);
							figs.add(fig);
							focus = fig;
							focus_but = null;
						}
						else if(focus_but == buts.get(3)){
							Figure fig = new Triangulo(posicaodomouse.x, posicaodomouse.y,80,60,fundo,contorno);
							figs.add(fig);
							focus = fig;
							focus_but = null;
						}
						else if(focus_but == buts.get(4)){
							Figure fig = new Arco(posicaodomouse.x, posicaodomouse.y,80,60,fundo,contorno,rand.nextInt(360),rand.nextInt(360));
							figs.add(fig);
							focus = fig;
							focus_but = null;
						}						
					} repaint();
				}
					
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
				
				for (Button but: buts) {
					if (but.clicked(posicaodomouse.x, posicaodomouse.y)) {
						focus_but = but;
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
			fig.paint(g, false);
		}
		
        if (focus != null) focus.paint(g, true);
		
         for (Button but: this.buts) {
             but.paint(g, but == focus_but);
        }
/*		for (Button but: this.buts) {
			but.paint(g,false);
			if (but ==  focus_but){
				but.paint(g,true);
			}
		}*/		
	}
}
