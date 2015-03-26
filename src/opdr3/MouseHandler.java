import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;


public class MouseHandler implements MouseListener, MouseMotionListener {
	constants.SHAPE s;
	MyShape ms;
	RectPanel rp;
	constants.modes m;
	public MouseHandler(constants.SHAPE s, RectPanel r){
		super();
		this.s=s;
		this.rp = r;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		PointerInfo a = MouseInfo.getPointerInfo();
		Point point = new Point(a.getLocation());
		SwingUtilities.convertPointFromScreen(point, e.getComponent());
		int x=(int) point.getX();
		int y=(int) point.getY();
		System.out.println("("+x+", "+y+")");
		if (m == constants.modes.TOOL){
			if (s == constants.SHAPE.LINE)
				ms = new MyLine(x,y);
			if (s == constants.SHAPE.ELLIPSE)
				ms = new MyEllipse(x,y);
			if (s == constants.SHAPE.RECT)
				ms = new MyRectangle(x,y);
			if (ms != null)
				rp.addToList(ms);
			rp.repaint();
		}
		if (m == constants.modes.DELETE){
			for(int i = 0; i < rp.shapesList.size(); i++){
				if (((MyShape) rp.shapesList.get(i)).contains(x,y)){
					rp.shapesList.remove(i);
					rp.repaint();
					i = rp.shapesList.size();
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

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
