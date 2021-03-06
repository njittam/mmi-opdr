package Shapes;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import MMI.RandomColor;


/**
 * @author mattijn
 * @author Tijs
 */
public class MyEllipse extends MyShape {

	private String objectname = "Ellipse";
	
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
	public MyEllipse(Color c){
		super(c);
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

	/**
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public MyEllipse(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}

	/* (non-Javadoc)
	 * @see Shapes.MyShape#contains(int, int)
	 */
	@Override
	public boolean contains(int x, int y) {
		Ellipse2D.Double ellipse = new Ellipse2D.Double(startx, starty, width,height);
		if (this.line < 5)
		return ellipse.intersects(x-(10/2), y-(10/2), 10, 10);
		else
		return ellipse.intersects(x-(this.line/2), y-(this.line/2), this.line, this.line);
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

	@Override
	public String getObjectName() {
		// TODO Auto-generated method stub
		return this.objectname;
	}

	@Override
	public void oncreate() {
		// TODO Auto-generated method stub
		
	}
}
