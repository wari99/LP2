import ivisible.IVisible;
import figures.Figure;
import java.awt.*;

public class Button implements IVisible {
    public int idx;
    private Figure fig;
	
    public Button (int idx, Figure fig) {
/*    this.idx = idx;
	this.fig = fig;
	this.fig.x = 20
	this.fig.y = 20
	this.fig.w = 
	this.fig.h = */
    }

    public boolean clicked (int x, int y) {
	return (20<=x && x<=20+40 && 20+this.idx*40<=y && y<=20+this.idx*40+40);
    }

    public void paint (Graphics g, boolean focused) {
	Graphics2D g2d = (Graphics2D) g;

	if (focused) {
	    g2d.setColor(Color.BLACK);
	}
	else {
	    g2d.setColor(Color.GRAY);
	}
	g2d.fillRect(20, 20+this.idx*40, 40, 40);

	g2d.setColor(Color.WHITE);
	g2d.drawRect(20, 20+this.idx*40, 40, 40);

	this.fig.paint(g, false);
    }
}
