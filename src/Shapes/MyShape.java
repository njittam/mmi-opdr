package Shapes;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import MMI.RandomColor;

public abstract class MyShape {
	protected int xmin = 0;
	protected int xmax = 600;
	protected int ymin = 0;
	protected int ymax = 200;
	Color c = (new RandomColor()).toColor();
	protected int x1, y1;
	public int x2;
	public int y2;
	protected int width, height, startx, starty;

	public MyShape() {
		this(0, 0, 0, 0);
		c = (new RandomColor()).toColor();
	}
	public void setColor(Color c){
		this.c = c;
	}
	public MyShape(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		c = (new RandomColor()).toColor();
	}
	public MyShape(int x1, int y1, int x2, int y2,Color c) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.c = c;
	}
	// test
	public MyShape(int x1, int y1, int x2, int y2, int width, int heigth, int startx, int starty) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.height = heigth;
		this.width = width;
		this.startx = startx;
		this.starty = starty;
		c = (new RandomColor()).toColor();
	}

	public void draw(Graphics2D g) {
		g.setPaint(c);
		width = Math.abs(this.x1 - this.x2);
		height = Math.abs(this.y1 - this.y2);
		startx = Math.min(this.x1, this.x2);
		starty = Math.min(this.y1, this.y2);
		g.setStroke(new BasicStroke(3));
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
	}
	
	public void setCoords(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public abstract boolean contains(int x, int y);
}