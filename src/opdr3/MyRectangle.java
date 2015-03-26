package opdr3;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class MyRectangle extends MyShape {

	public MyRectangle() {
		int xmin = super.xmin;
		int xmax = super.xmax;
		int ymin = super.ymin;
		int ymax = super.ymax;
		xmin = RandomColor.randInt(xmin,xmax-1);
		xmax = RandomColor.randInt(xmin + 1,xmax);
		ymin = RandomColor.randInt(ymin,ymax-1);
		ymax = RandomColor.randInt(ymin + 1,ymax);
		this.x1 =xmin;
		this.x2 =xmax;
		this.y1 =ymin;
		this.y2 =ymax;
	}

	public MyRectangle(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}
	public MyRectangle(int x1, int y1, int x2, int y2,int width,int heigth, int startx, int starty) {
		super(x1, y1, x2, y2,width,heigth,startx,starty);
	}
	
	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		Rectangle2D.Double rect = new Rectangle2D.Double(startx, starty, width,
				height);
		g.draw(rect);
	}

}