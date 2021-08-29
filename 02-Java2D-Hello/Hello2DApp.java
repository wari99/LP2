import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
		//a) MUDANDO A COR DE FUNDO 
		this.getContentPane().setBackground(Color.gray);
		
        this.setTitle("Java2D - Hello World!");
        this.setSize(350, 350);
        this.setVisible(true);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        
    //a) MUDANDO A COR DA LINHA
        g2d.setPaint(Color.magenta);
        int w = getWidth();
        int h = getHeight();
        g2d.drawLine(0,0, w,h);
        g2d.drawLine(0,h, w,0);
		
		//b) ADICIONANDO UMA PRIMITIVA BASICA
		g2d.setPaint(Color.pink); 
		g2d.drawRect( getWidth()/5 , getHeight()/3, 215, 135); 
		
		//c) OUTRA MODIFICACAO
		g2d.setPaint(Color.lightGray);
		g2d.fillOval(145,200,75,45);
		
		g2d.setPaint(Color.gray);
		g2d.fillOval(145,190, 75,45);

		g2d.setPaint(Color.pink);
		g2d.fillOval(145,160, 75,45);
		
		g2d.setPaint(Color.magenta);
		g2d.fillOval(145,140, 75,45);
		
		g2d.setPaint(Color.gray);
		g2d.fillOval(145,120,75,45);
		
    }
}
