package Shapes;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import MMI.RandomColor;


/**
 * @author mattijn
 * @author Tijs
 */
public class MyEllipse extends MyShape {

	private String objectname = "MyRectangle";
	
	/**
	 * 
	 */
	public MyEllipse() {
		int xmin = super.xmin;
		int xmax = super.xmax;
		int ymin = super.ymin;
		int ymax = super.ymax;
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

	/**
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public MyEllipse(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}
	
	/**
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param width
	 * @param heigth
	 * @param startx
	 * @param starty
	 */
	public MyEllipse(int x1, int y1, int x2, int y2,int width,int heigth, int startx, int starty) {
		super(x1, y1, x2, y2,width,heigth,startx,starty);
	}

	/**
	 * @param x
	 * @param y
	 */
	public MyEllipse(int x, int y) {
		int xmin = super.xmin;
		int xmax = super.xmax;
		int ymin = super.ymin;
		int ymax = super.ymax;
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

	/* (non-Javadoc)
	 * @see Shapes.MyShape#draw(java.awt.Graphics2D)
	 */
	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		Ellipse2D.Double ellip = new Ellipse2D.Double(startx, starty, width,height);
		g.draw(ellip);
	}

	/* (non-Javadoc)
	 * @see Shapes.MyShape#contains(int, int)
	 */
	@Override
	public boolean contains(int x, int y) {
		Ellipse2D.Double ellip = new Ellipse2D.Double(startx, starty, width,height);
		return ellip.intersects(x, y, 1, 1);
	}

	@Override
	public String getObjectName() {
		// TODO Auto-generated method stub
		return this.objectname;
	}
}
