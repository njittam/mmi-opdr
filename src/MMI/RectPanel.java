package MMI;
import handlers.MouseHandler;
import handlers.MyListener;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import wiiusej.Wiimote;
import MMI.constants.Directions;
import MMI.constants.SHAPE;
import MMI.constants.modes;
import Shapes.MyEllipse;
import Shapes.MyLine;
import Shapes.MyPoint;
import Shapes.MyRectangle;
import Shapes.MyShape;

/**
 * @author Mattijn
 * @author Tijs
 */
/**
 * @author mkreuzen
 *
 */
public class RectPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8421133344664044138L;
	public ArrayList<MyShape> shapesList = new ArrayList<MyShape>();
	public ArrayList<MyPoint> pointList = new ArrayList<MyPoint>();
	private int modn = 1;
	public RandomColor color ;
	
	constants.SHAPE shape = constants.SHAPE.NONE;
	MouseHandler mh = new MouseHandler(constants.SHAPE.NONE,this);
	
	private int selected = 2;
	private MyShape show_selected = null;
	private MyRectangle trashcan = null;
	
	//const values over de selecteerbox
	private int extend_show_selected = 10;
	private Color selected_color = Color.RED;
	
	//const values over trasbin
	private Directions trash_location = Directions.EAST;
	private double trashcan_size  = 0.2; //value between 0.0 and 1.0
	private Color trashcan_color = Color.BLUE;
	
	//const values over scroll
	private int color_big_scroll = 1000;
	private int color_small_scroll = 10;
	private MyShape[] shapelist_scroll = {new MyLine(), new MyEllipse(), new MyRectangle()};
	
	/**
	 * @param mote 
	 * 
	 */
	public RectPanel(Wiimote mote){
		super ();
		this.color = new RandomColor() ;
		this.addMouseListener(mh);
		this.addMouseMotionListener(mh);
		this.setTrashBin(trash_location);
		mote.addWiiMoteEventListeners(new MyListener(this));
	}
	
	/**
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public void resize_selected(int x1, int y1, int x2, int y2){
		if (selected >= 0 && selected < this.shapesList.size()){
			MyShape s = this.shapesList.get(selected);
			s.setCoords(x1,y1,x2,y2);
			this.shapesList.set(selected, s);
		}
		this.repaint();
	}
	
	/**
	 * @param c
	 */
	public void change_color_of_selected(Color c){
		if (selected >= 0 && selected < this.shapesList.size()){
			MyShape s = shapesList.get(selected);
			s.setColor(c);
			shapesList.set(selected, s);
		}
		this.repaint();
	}
	
	/**
	 * @param new_shape
	 */
	public void change_shape_of_selected(MyShape new_shape){
		if (this.selected >= 0 && this.selected < this.shapesList.size()){
			MyShape s= this.shapesList.get(this.selected);
			new_shape.setValues(s.getX1(), s.getY1(), s.getX2(), s.getY2(),s.getColor());
			this.shapesList.set(this.selected, new_shape);
		}else{
			this.shapesList.add(new_shape);
			this.selected = this.shapesList.size() - 1;
		}
		this.repaint();
	}

	/**
	 * @param d
	 * @param c
	 * @return
	 */
	public Color scroll_through_colors(Directions d, Color c){
		int ci = c.getRGB();
		switch (d){
		case NORTH:
			ci += this.color_big_scroll;
			break;
		case SOUTH:
			ci -= this.color_big_scroll;
			break;
		case EAST:
			ci += this.color_small_scroll;
			break;
		case WEST:
			ci += this.color_small_scroll;
			break;
		}
		return new Color(Math.abs(ci % 8388608));
	}
	
	/**
	 * @param d
	 * @param c
	 * @return
	 */
	public MyShape scroll_through_shapes(Directions d, MyShape s){
		int i = -1;
		boolean found = false;
		while (i < this.shapelist_scroll.length || found){
			i++;
			if (this.shapelist_scroll[i].getObjectName()  == s.getObjectName()){
				found = true;
			}
		}
		if  (i == this.shapelist_scroll.length || !found) 
			return s;
		else{
			switch (d){
			case WEST:
				i++;
				break;
			case EAST:
				i--;
				break;
			case NORTH:
				break;
			case SOUTH:
				break;
			default:
				break;
			}
			return this.shapelist_scroll[Math.abs(i % this.shapelist_scroll.length)];
		}
	}
	/**
	 * @param x
	 * @param y
	 */
	public void select_object(int x, int y){
		this.selected = -1;
		for (int i = 0; i < this.shapesList.size(); i++){
			if (this.shapesList.get(i).contains(x, y))
				this.selected = i;
			this.repaint();
		}
	}
	
	/**
	 * @param d
	 */
	public void setTrashBin(Directions d){
		this.trashcan = new MyRectangle();
		switch (d){
		case SOUTH:
			this.trashcan.setX1(0);
			this.trashcan.setX2(this.getWidth());
			this.trashcan.setY2(this.getHeight());
			this.trashcan.setY1(this.getHeight() - (int) (this.getHeight() * this.trashcan_size));
			break;
		case NORTH:
			this.trashcan.setX1(0);
			this.trashcan.setY1(0);
			this.trashcan.setX2(this.getWidth());
			this.trashcan.setY2((int) (this.getHeight() * this.trashcan_size));
			break;
		case EAST:
			this.trashcan.setX1(this.getWidth() - (int)(this.getWidth() * this.trashcan_size));
			this.trashcan.setY1(0);
			this.trashcan.setX2(this.getWidth());
			this.trashcan.setY2(this.getHeight());
			break;
		case WEST:
			this.trashcan.setX1(0);
			this.trashcan.setY1(0);
			this.trashcan.setX2((int) (this.getWidth() * this.trashcan_size));
			this.trashcan.setY2(this.getHeight());
			break;
			
		}
		this.trashcan.setColor(this.trashcan_color);
	}
	
	/**
	 * @param g
	 */
	public void drawTrashBin(Graphics2D g2d){
		this.setTrashBin(this.trash_location);
		if (this.trashcan != null){
			
			this.trashcan.draw(g2d);
		}
	}
	
	/**
	 * @param s
	 * @return
	 */
	public boolean inTrash(MyShape s){
		return this.trashcan.contains(s.getX1(), s.getY1()) && this.trashcan.contains(s.getX2(), s.getY2());
	}

	/**
	 * 
	 */
	public void delete_selected_object(){
		if 	(this.selected >= 0 && this.selected < this.shapesList.size() && this.inTrash(this.shapesList.get(selected))){
			this.shapesList.remove(selected);
			selected = -1;
		}
	}
	
	/**
	 * @param g
	 */
	private void draw_select(Graphics2D g2d){
		this.show_selected = new MyRectangle();

		if (selected >= 0 && selected < this.shapesList.size()){
			MyShape s = this.shapesList.get(selected);
			if (s.getX1() < s.x2  && s.getY1() < s.y2 || s.getX1() == s.getX2() || s.getY1() == s.getY2())
			show_selected.setValues(s.getX1() - this.extend_show_selected, 
									s.getY1() - this.extend_show_selected, 
									s.getX2() + this.extend_show_selected, 
									s.getY2() + this.extend_show_selected,
									selected_color);
			if (s.getX1() < s.x2  && s.getY1() > s.y2)
				show_selected.setValues(s.getX1() - this.extend_show_selected, 
										s.getY1() + this.extend_show_selected, 
										s.getX2() + this.extend_show_selected, 
										s.getY2() - this.extend_show_selected,
										selected_color);
			if (s.getX1() > s.x2  && s.getY1() < s.y2)
				show_selected.setValues(s.getX1() + this.extend_show_selected, 
										s.getY1() - this.extend_show_selected, 
										s.getX2() - this.extend_show_selected, 
										s.getY2() + this.extend_show_selected,
										selected_color);
			if (s.getX1() > s.x2  && s.getY1() > s.y2)
				show_selected.setValues(s.getX1() + this.extend_show_selected, 
										s.getY1() + this.extend_show_selected, 
										s.getX2() - this.extend_show_selected, 
										s.getY2() - this.extend_show_selected,
										selected_color);
		} else{
			this.show_selected = null;
		}
		if (this.show_selected != null){
			this.show_selected.draw(g2d);
		}
	}
	
	/**
	 * @param x
	 * @param y
	 */
	public void add_point(int x, int y){
		pointList.add(new MyPoint(x,y));
		this.repaint();
	}

	/**
	 * @param x
	 * @param y
	 */
	public void remove_point(int x, int y){
		for (int i = 0; i < pointList.size();i++){
			if (pointList.get(i).equals(new MyPoint(x,y))){
				pointList.remove(i);
				i--;
			}
		}
		this.repaint();
	}

	/**
	 * @param x_new
	 * @param y_new
	 * @param x_old
	 * @param y_old
	 */
	public void move_point(int x_new, int y_new, int x_old, int y_old){
		for (int i = 0; i < pointList.size() ; i++){
			if (pointList.get(i).equals(new MyPoint(x_old,y_old))){
				pointList.set(i, new MyPoint(x_new, y_new));
			}
		}
		this.repaint();
	}



	/**
	 * @param s
	 */
	public void addToList(MyShape s){
		this.shapesList.add(s);
		modn=1;
	}

	/**
	 * @param s
	 */
	public void insert_in_list(MyShape s){
		shapesList.remove(shapesList.size() - modn);
		shapesList.add(shapesList.size() - modn + 1,s);
	}

	/**
	 * 
	 */
	public void raise_modn(){
		modn++;
		if (modn > shapesList.size())
			modn = 1;
		super.repaint();
	}
  
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
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
		this.setTrashBin(trash_location);
		this.draw_select(g2d);
		this.drawTrashBin(g2d);
		//System.out.println("trasbin x1,y1,x2,y2\n");
		System.out.println("("+this.trashcan.getX1()+ "," + this.trashcan.getY1()+ ',' +this.trashcan.getX2()+ ',' +this.trashcan.getY2()+ ')');
		super.repaint();
	}

	/**
	 * 
	 */
	public void RandomColor(){
		mh.m = modes.COLOR;
	}

	/**
	 * @return
	 */
	MyShape generateShape(){
		int r = RandomColor.randInt(0,3);
		if (r ==0 )
			return new MyRectangle();
		if ( r==1 )
			return new MyLine();
		if ( r==2 )
			return new MyEllipse();
		if (r == 3)
			return new MyPoint(100,100);
		else return null;
	}

	/**
	 * 
	 */
	public void addRandomShape(){
		MyShape r = generateShape();
		modn = 1;
		this.shapesList.add(r);
		this.paint(getGraphics());
		super.repaint();
	}

	/**
	 * 
	 */
	public void alterNextShape(){
		MyShape s = generateShape();
		this.insert_in_list(s);
		this.raise_modn();
		super.repaint();
	}

	/**
	 * 
	 */
	public void tool(){
		mh.m = modes.TOOL;
		mh.s = shape;
	}

	/**
	 * 
	 */
	public void mode(){
		mh.m = modes.MODE;
	}

	/**
	 * 
	 */
	public void addRandomLine(){
		shape = SHAPE.LINE;

	}

	/**
	 * 
	 */
	public void addRandomEllipse(){
		shape = SHAPE.ELLIPSE;
	}

	/**
	 * 
	 */
	public void addRandomRectangle(){
		shape = SHAPE.RECT;
	}

	/**
	 * 
	 */
	public void delete() {
		// TODO Auto-generated method stub
		mh.m = modes.DELETE;
	}
}