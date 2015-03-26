package MMI;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import Shapes.MyShape;


public class MyEllipse extends MyShape {

	public MyEllipse() {
		int xmin = super.xmin;
		int xmax = super.xmax;
		int ymin = super.ymin;
		int ymax = super.ymax;
		int verhor = RandomColor.randInt(0,1);
		xmin = RandomColor.randInt(xmin,xmax-1);
		xmax = RandomColor.randInt(xmin + 1,xmax);
		ymin = RandomColor.randInt(ymin,ymax-1);
		ymax = RandomColor.randInt(ymin + 1,ymax);
		this.x1 = xmin;
		this.x2 = xmax;
		this.x1 = xmin;
		this.y1 = ymin;
		this.y2 = ymax;
	}

	public MyEllipse(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}
	public MyEllipse(int x1, int y1, int x2, int y2,int width,int heigth, int startx, int starty) {
		super(x1, y1, x2, y2,width,heigth,startx,starty);
	}

	public MyEllipse(int x, int y) {
		int xmin = super.xmin;
		int xmax = super.xmax;
		int ymin = super.ymin;
		int ymax = super.ymax;
		int verhor = RandomColor.randInt(0,1);
		xmin = x;
		xmax = RandomColor.randInt(xmin + 1,xmax);
		ymin = y;
		ymax = RandomColor.randInt(ymin + 1,ymax);
		this.x1 = xmin;
		this.x2 = xmax;
		this.x1 = xmin;
		this.y1 = ymin;
		this.y2 = ymax;
	}

	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		Ellipse2D.Double rect = new Ellipse2D.Double(startx, starty, width,height);
		g.draw(rect);
	}

	@Override
	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
}
