package Shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import MMI.RandomColor;

public class MyRectangleFilled extends MyShape {

	/**
	 * 
	 */
	private String objectname = "Rectangle Filled";
	public MyRectangleFilled() {
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
	public  MyRectangleFilled(Color c){
		super(c);
	}
	/**
	 * @param x
	 * @param y
	 */
	public MyRectangleFilled(int x, int y) {
		int xmin = x;
		int xmax = super.xmax;
		int ymin = y;
		int ymax = super.ymax;
		xmax = RandomColor.randInt(xmin + 1,xmax);
		ymax = RandomColor.randInt(ymin + 1,ymax);
		this.x1 =xmin;
		this.x2 =xmax;
		this.y1 =ymin;
		this.y2 =ymax;
	}
	
	
	/**
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public MyRectangleFilled(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}

	/* (non-Javadoc)
	 * @see Shapes.MyShape#contains(int, int)
	 */
	@Override
	public boolean contains(int x, int y) {
		Rectangle2D.Double rect = new Rectangle2D.Double(startx, starty, width, height);
		return rect.intersects(x-2, y-2, 4, 4);
	}

	/* (non-Javadoc)
	 * @see Shapes.MyShape#draw(java.awt.Graphics2D)
	 */
	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		Rectangle2D.Double rect = new Rectangle2D.Double(startx, starty, width, height);
		g.fill(rect);
	}

	/* (non-Javadoc)
	 * @see Shapes.MyShape#getoObjectName()
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