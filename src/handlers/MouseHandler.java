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
	public int old_x;
	public int old_y;
	public int index;
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
		if (m == modes.COLOR){
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
		if (m == modes.MODE){
			this.old_x = x;
			this.old_y = y;
			for(int i = rp.shapesList.size()-1; i >= 0; i--){
				if (((MyShape) rp.shapesList.get(i)).contains(x,y)){
					this.index = i;
					i = -1;
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO dit moet naar dragged en olx_x en old_y moeten daar geupdate worden
		if (m == modes.MODE){
			index = -1;
		}
		
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
		if (m == modes.MODE){
			int dy= old_y  - e.getY();
			int dx = old_x - e.getX();
			if (index >= 0 && index < rp.shapesList.size()){
				rp.shapesList.get(index).setX1(rp.shapesList.get(index).getX1()-dx);
				rp.shapesList.get(index).setX2(rp.shapesList.get(index).getX2()-dx);
				rp.shapesList.get(index).setY1(rp.shapesList.get(index).getY1()-dy);
				rp.shapesList.get(index).setY2(rp.shapesList.get(index).getY2()-dy);
				rp.repaint();
			}
			this.old_x = x;
			this.old_y = y;
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
