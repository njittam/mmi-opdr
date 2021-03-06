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


/**
 * @author mattijn
 *  @author Tijs
 */
public class MouseHandler implements MouseListener, MouseMotionListener {
	public int index;
	public constants.modes m;
	MyShape ms;
	public int old_x;
	public int old_y;
	RectPanel rp;
	public constants.SHAPE s;
	
	/**
	 * @param s
	 * @param r
	 */
	public MouseHandler(constants.SHAPE s, RectPanel r){
		super();
		this.s = s;
		this.rp = r;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		int x=(int) e.getX();
		int y=(int) e.getY();
		if (e.isShiftDown() && e.isControlDown())
			return;
		//System.out.println("("+x+", "+y+")");
		//System.out.println("trasbin x1,y1,x2,y2\n");
		if (m == constants.modes.TOOL||e.isShiftDown()){
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
		else if (m == modes.COLOR){
			rp.change_color_of_selected((new RandomColor().toColor()));
			rp.repaint();
			/*for(int i = rp.shapesList.size()-1; i >= 0; i--){
				if (((MyShape) rp.shapesList.get(i)).contains(x,y)){
					MyShape s = rp.shapesList.get(i);
					rp.shapesList.remove(i);
					s.setColor((new RandomColor()).toColor());
					rp.shapesList.add(i, s);
					rp.repaint();
					i = -1;
				}
			}*/
		}
		else if (m == constants.modes.DELETE){
			for(int i = rp.shapesList.size()-1; i >= 0; i--){
				if (((MyShape) rp.shapesList.get(i)).contains(x,y)){
					rp.shapesList.remove(i);
					rp.repaint();
					i = -1;
				}
			}
		}else
			this.rp.select_object(x, y);
		rp.repaint();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		int x=(int) e.getX();
		int y=(int) e.getY();
		if (e.isShiftDown() && e.isControlDown())
			return;
		if (m == modes.TOOL||e.isShiftDown()){
			rp.addAction(Actions.Resize);
			MyShape s = rp.getSelected();
			rp.resize_selected(s.getX1(), s.getY1(), x, y);
//			ms = rp.shapesList.get(rp.shapesList.size() -1);
//			ms.x2 = x;
//			ms.y2 = y;
//			rp.shapesList.remove(rp.shapesList.size() -1);
//			rp.shapesList.add(ms);
//			rp.repaint();
		}
		if (m == modes.MODE|| e.isControlDown()){
			rp.addAction(Actions.Move);
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

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int x=(int) e.getX();
		int y=(int) e.getY();
		if (e.isShiftDown() && e.isControlDown())
			return;
		if (m == modes.TOOL||e.isShiftDown()){
			if (s == SHAPE.LINE)
				ms = new MyLine(x,y,x,y);
			if (s == SHAPE.ELLIPSE)
				ms = new MyEllipse(x,y,x,y);
			if (s == SHAPE.RECT)
				ms = new MyRectangle(x,y,x,y);
			if (ms != null)
				rp.addToList(ms);
		}
		if (m == modes.MODE || e.isControlDown()){
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

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO dit moet naar dragged en olx_x en old_y moeten daar geupdate worden
		if (e.isShiftDown() && e.isControlDown())
			return;
		if (m == modes.MODE|| e.isControlDown()){
			index = -1;
		}
		rp.delete_selected_object();
		
	}

}
