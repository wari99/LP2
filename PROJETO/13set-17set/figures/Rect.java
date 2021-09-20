public class Rect extends Figure{
	
    int x, y;
    int w, h;
	
	int r, g, b;
	
	int rC, gC, bC;

    public Rect (int x, int y, int w, int h, int r, int g, int b, int rC, int gC, int bC) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
		
		this.r = r;
		this.g = g;
		this.b = b;
		
		this.rC = rC;
		this.bC = bC;
		this.gC = gC;
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
		g2d.setColor(new Color(this.r,this.g,this.b));
		g2d.fillRect(this.x, this.y, this.w, this.h);
		
		g2d.setColor(new Color(this.rC, this.gC, this.bC));
		g2d.drawRect(this.x,this.y, this.w,this.h);
    
	}
}
