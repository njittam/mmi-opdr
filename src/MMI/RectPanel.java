package MMI;
import handlers.MouseHandler;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import MMI.constants.*;
import Shapes.MyEllipse;
import Shapes.MyLine;
import Shapes.MyPoint;
import Shapes.MyRectangle;
import Shapes.MyShape;

public class RectPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8421133344664044138L;
	public ArrayList<MyShape> shapesList = new ArrayList<MyShape>();
	public ArrayList<MyPoint> pointList = new ArrayList<MyPoint>();
	private int modn = 1;
	public RandomColor color ;
	public void add_point(int x, int y){
		pointList.add(new MyPoint(x,y));
		this.repaint();
	}
	public void remove_point(int x, int y){
		for (int i = 0; i < pointList.size();i++){
			if (pointList.get(i)== new MyPoint(x,y)){
				pointList.remove(i);
				i--;
			}
		}
		this.repaint();
	}
	public void move_point(){
		//TODO add code
		this.repaint();
	}
	
	constants.SHAPE shape = constants.SHAPE.NONE;
	MouseHandler mh = new MouseHandler(constants.SHAPE.NONE,this);
	public RectPanel(){
		super ();
		this.color = new RandomColor() ;
		this.addMouseListener(mh);
		this.addMouseMotionListener(mh);
	}
	public void addToList(MyShape s){
		this.shapesList.add(s);
		modn=1;
	}
	public void insert_in_list(MyShape s){
		shapesList.remove(shapesList.size() - modn);
		shapesList.add(shapesList.size() - modn + 1,s);
	}
	
	public void raise_modn(){
		modn++;
		if (modn > shapesList.size())
			modn = 1;
		super.repaint();
	}
	@Override
	public void paintComponent ( Graphics g) {
		super . paintComponent (g );
		g.setColor ( this.color.toColor() );	
		Graphics2D g2d = (Graphics2D) g;
		for (MyShape s : shapesList)
			s.draw(g2d);
		for (MyPoint e : pointList){
			e.draw(g2d);
		}
		super.repaint();
	}
	public void RandomColor(){
		mh.m = modes.COLOR;
	}
	MyShape generateShape(){
		int r = RandomColor.randInt(0,2);
		if (r ==0 )
			return new MyRectangle();
		if ( r==1 )
			return new MyLine();
		if ( r==2 )
			return new MyEllipse();
		else return null;
	}
	public void addRandomShape(){
		MyShape r = generateShape();
		modn = 1;
		this.shapesList.add(r);
		this.paint(getGraphics());
		super.repaint();
	}

	public void alterNextShape(){
		MyShape s = generateShape();
		this.insert_in_list(s);
		this.raise_modn();
		super.repaint();
	}
	public void tool(){
		mh.m = modes.TOOL;
		mh.s = shape;
	}
	public void mode(){
		mh.m = modes.MODE;
	}
	public void addRandomLine(){
		shape = SHAPE.LINE;
		
	}
	public void addRandomEllipse(){
		shape = SHAPE.ELLIPSE;
	}
	public void addRandomRectangle(){
		shape = SHAPE.RECT;
	}

	public void delete() {
		// TODO Auto-generated method stub
		mh.m = modes.DELETE;
	}

}