package Shapes;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import MMI.RandomColor;


public class MyLine extends MyShape{

	public MyLine() {
		int xmin = super.xmin;
		int xmax = super.xmax;
		int ymin = super.ymin;
		int ymax = super.ymax;
		int verhor = RandomColor.randInt(0,1);
		xmin = RandomColor.randInt(xmin,xmax-1);
		xmax = RandomColor.randInt(xmin + 1,xmax);
		ymin = RandomColor.randInt(ymin,ymax-1);
		ymax = RandomColor.randInt(ymin + 1,ymax);
		
		if (verhor == 0){
			this.x1 = xmin;
			this.x2 = xmax;
			this.y1 = ymin;
			this.y2 = y1 + 1;
		}else{
			this.x1 = xmin;
			this.x2 = x1 + 1;
			this.y1 = ymin;
			this.y2 = ymax;
		}
	}
	public MyLine(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}
	public MyLine(int x1, int y1, int x2, int y2,int width,int heigth, int startx, int starty) {
		super(x1, y1, x2, y2,width,heigth,startx,starty);
	}
	
	public MyLine(int x, int y) {
		int xmin = super.xmin;
		int xmax = super.xmax;
		int ymin = super.ymin;
		int ymax = super.ymax;
		int verhor = RandomColor.randInt(0,1);
		xmin = x;
		xmax = RandomColor.randInt(xmin + 1,xmax);
		ymin = y;
		ymax = RandomColor.randInt(ymin + 1,ymax);
		
		if (verhor == 2){
			this.x1 = xmin;
			this.x2 = xmax;
			this.y1 = ymin;
			this.y2 = ymax;
		}else{
			this.x1 = xmin;
			this.x2 = xmax;
			this.y1 = ymin;
			this.y2 = ymax;
		}
	}

	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		Line2D.Double line = new Line2D.Double(x1, y1, x2,y2);
		g.draw(line);
	}
	@Override
	public boolean contains(int x, int y) {
		Line2D.Double line = new Line2D.Double(x1, y1, x2,y2);
		return line.intersects(x-4, y-4, 8, 8);
	}
}
