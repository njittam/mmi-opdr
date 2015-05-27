package Shapes;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import MMI.RandomColor;

/**
 * @author Mattijn
 * @author Tijs
 */
public abstract class MyShape {
	protected int xmin = 0;
	protected int xmax = 600;
	protected int ymin = 0;
	protected int ymax = 200;
	Color c = (new RandomColor()).toColor();
	protected int x1, y1;
	public int x2;
	public int y2;
	public int line = 3;
	protected int width, height, startx, starty;

	/**
	 * 
	 */
	public MyShape() {
		int xmin = this.xmin;
		int xmax = this.xmax;
		int ymin = this.ymin;
		int ymax = this.ymax;
		xmin = RandomColor.randInt(xmin,xmax-1);
		xmax = RandomColor.randInt(xmin + 1,xmax);
		ymin = RandomColor.randInt(ymin,ymax-1);
		ymax = RandomColor.randInt(ymin + 1,ymax);
		this.x1 =xmin;
		this.x2 =xmax;
		this.y1 =ymin;
		this.y2 =ymax;
		c = (new RandomColor()).toColor();
	}
	public void setLine (int line){
		this.line = line;
	}
	public MyShape (int line){
		this();
		this.line = line;
	}
	/**
	 * @param c
	 */
	public void setColor(Color c){
		this.c = c;
	}
	
	/**
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public MyShape(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		c = (new RandomColor()).toColor();
	}
	
	/**
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param c
	 */
	public MyShape(int x1, int y1, int x2, int y2,Color c) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;

		update();
		this.c = c;
	}
	public void update(){
		width  = Math.abs(this.x1 - this.x2);
		height = Math.abs(this.y1 - this.y2);
		startx = Math.min(this.x1, this.x2);
		starty = Math.min(this.y1, this.y2);
	
	}

	/**
	 * @param g
	 */
	public void draw(Graphics2D g) {
		g.setPaint(c);
		update();
		g.setStroke(new BasicStroke(this.line));
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
	}
	
	/**
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public void setCoords(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.update();
	}

	/**
	 * @return
	 */
	public int getX1() {
		return x1;
	}

	/**
	 * @param x1
	 */
	public void setX1(int x1) {
		this.x1 = x1;
		update();
	}
	

	/**
	 * @return
	 */
	public int getY1() {
		return y1;
	}

	/**
	 * @param y1
	 */
	public void setY1(int y1) {
		this.y1 = y1;
		update();
	}

	/**
	 * @return
	 */
	public int getX2() {
		return x2;
	}

	/**
	 * @param x2
	 */
	public void setX2(int x2) {
		this.x2 = x2;
update();
	}

	/**
	 * @return
	 */
	public int getY2() {
		return y2;
	}

	/**
	 * @param y2
	 */
	public void setY2(int y2) {
		this.y2 = y2;
		update();
	}

	/**
	 * @param x
	 * @param y
	 * @return
	 */
	public abstract boolean contains(int x, int y);
	
	/**
	 * @return
	 */
	public abstract String getObjectName(); 
	
	/**
	 * @return
	 */
	public Color getColor() {
		return this.c;
	}
	
	/**
	 * @param x12
	 * @param y12
	 * @param x22
	 * @param y22
	 * @param color
	 */
	public void setValues(int x12, int y12, int x22, int y22, Color color) {
		this.setCoords(x12, y12, x22, y22);
		this.setColor(color);	
	}
	public abstract void oncreate();
}