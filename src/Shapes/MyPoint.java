package Shapes;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 * @author mattijn
 * @author Tijs
 */
public class MyPoint extends MyShape {

	public int x;
	public int y;
	
	/**
	 * @param x
	 * @param y
	 */
	public MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
		this.x1  = this.x - 1;
		this.y1  = this.y - 1;
		this.x2  = this.x + 1;
		this.y2  = this.y + 1;
	}

	/* (non-Javadoc)
	 * @see Shapes.MyShape#contains(int, int)
	 */
	@Override
	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		return false;
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
	
	/**
	 * @param myPoint
	 * @return
	 */
	public boolean equals(MyPoint myPoint) {
		return this.x == myPoint.x && this.y == myPoint.y;
	}

}
