package Shapes;

import java.awt.Color;
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
	 * creates an MyPoint object
	 * 
	 * @param x x position
	 * @param y y position
	 */
	public MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
		int r = 3;
		this.x1  = this.x - r;
		this.y1  = this.y - r;
		this.x2  = this.x + r;
		this.y2  = this.y + r;
		this.c = Color.BLACK;
	}

	/** (non-Javadoc)
	 * 
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
