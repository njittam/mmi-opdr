package Shapes;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import MMI.RandomColor;


/**
 * @author mattijn
 * @author Tijs
 */
public class MyLine extends MyShape{

	/**
	 * 
	 */
	private String objectname = "Line";
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
	
	/**
	 * @param x
	 * @param y
	 */
	public MyLine(Color c){
		super(c);
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
	
	/**
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public MyLine(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}

	/* (non-Javadoc)
	 * @see Shapes.MyShape#contains(int, int)
	 */
	@Override
	public boolean contains(int x, int y) {
		Line2D.Double line = new Line2D.Double(x1, y1, x2,y2);
		if (this.line < 5)
			return line.intersects(x-(10/2), y-(10/2), 10, 10);
			else
		return line.intersects(x-(this.line/2), y-(this.line/2), this.line, this.line);
	}
	
	/* (non-Javadoc)
	 * @see Shapes.MyShape#draw(java.awt.Graphics2D)
	 */
	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		Line2D.Double line = new Line2D.Double(x1, y1, x2,y2);
		g.draw(line);
	}

	/* (non-Javadoc)
	 * @see Shapes.MyShape#getObjectName()
	 */
	@Override
	public String getObjectName() {
		return this.objectname;
	}

	@Override
	public void oncreate() {
		// TODO Auto-generated method stub
		
	}
}
