package opdr3;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;


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
	
	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		Line2D.Double rect = new Line2D.Double(startx, starty, width,height);
		g.draw(rect);
	}
}
