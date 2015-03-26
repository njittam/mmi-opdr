package handlers;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import MMI.RectPanel;
import MMI.constants;
import MMI.RandomColor;
import MMI.constants.*;
import Shapes.MyEllipse;
import Shapes.MyLine;
import Shapes.MyRectangle;
import Shapes.MyShape;


public class MouseHandler implements MouseListener, MouseMotionListener {
	public constants.SHAPE s;
	MyShape ms;
	RectPanel rp;
	public constants.modes m;
	public MouseHandler(constants.SHAPE s, RectPanel r){
		super();
		this.s = s;
		this.rp = r;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int x=(int) e.getX();
		int y=(int) e.getY();
		System.out.println("("+x+", "+y+")");
		if (m == constants.modes.TOOL){
			if (s == SHAPE.LINE)
				ms = new MyLine(x,y);
			if (s == SHAPE.ELLIPSE)
				ms = new MyEllipse(x,y);
			if (s == SHAPE.RECT)
				ms = new MyRectangle(x,y);
			if (ms != null)
				rp.addToList(ms);
			rp.repaint();
		}
		if (m == modes.MODE){
			for(int i = rp.shapesList.size()-1; i >= 0; i--){
				if (((MyShape) rp.shapesList.get(i)).contains(x,y)){
					MyShape s = rp.shapesList.get(i);
					rp.shapesList.remove(i);
					s.setColor((new RandomColor()).toColor());
					rp.shapesList.add(i, s);
					rp.repaint();
					i = -1;
				}
			}
		}
		if (m == constants.modes.DELETE){
			for(int i = rp.shapesList.size()-1; i >= 0; i--){
				if (((MyShape) rp.shapesList.get(i)).contains(x,y)){
					rp.shapesList.remove(i);
					rp.repaint();
					i = -1;
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int x=(int) e.getX();
		int y=(int) e.getY();
		if (m == modes.TOOL){
			if (s == SHAPE.LINE)
				ms = new MyLine(x,y,x,y);
			if (s == SHAPE.ELLIPSE)
				ms = new MyEllipse(x,y,x,y);
			if (s == SHAPE.RECT)
				ms = new MyRectangle(x,y,x,y);
			if (ms != null)
				rp.addToList(ms);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		int x=(int) e.getX();
		int y=(int) e.getY();
		if (m == modes.TOOL){
			ms = rp.shapesList.get(rp.shapesList.size() -1);
			ms.x2 = x;
			ms.y2 = y;
			rp.shapesList.remove(rp.shapesList.size() -1);
			rp.shapesList.add(ms);
			rp.repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
