package MMI;
import handlers.MouseHandler;
import handlers.MyListener;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;

import wiiusej.Wiimote;
import MMI.constants.Actions;
import MMI.constants.Directions;
import MMI.constants.SHAPE;
import MMI.constants.modes;
import MMI.constants.sliders;
import Shapes.MyEllipse;
import Shapes.MyEllipseFilled;
import Shapes.MyImage;
import Shapes.MyLine;
import Shapes.MyPoint;
import Shapes.MyRectangle;
import Shapes.MyRectangleFilled;
import Shapes.MyShape;
import Shapes.MyText;

/**
 * @author Mattijn
 * @author Tijs
 */
//TODO .csv fixen
//TODO  kleine objecten kunnen selecteren
//TODO layout veranderen?
//TODO stanaard locatie voor nieuwe shapes?
//TODO help functie
public class RectPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3983917049855075714L;
	private ArrayList<constants.Actions> actionsList = new ArrayList<constants.Actions>();
	public RandomColor color ;
	//const values over scroll
	private int color_big_scroll = 1000;
	private int color_small_scroll = 10;
	//null};
	// slider data
	private int colorSlider = 0;
	private String current_mode = "none";
	public boolean drawnewshape= false;

	//const values over de selecteerbox
	private int extend_show_selected = 10;

	public boolean last = false;
	sliders last_changed = sliders.Shape;

	public int lineSlider = 5;
	MouseHandler mh = new MouseHandler(constants.SHAPE.NONE,this);
	private Color modeColor = Color.BLACK;

	private int modn = 1;
	public MyShape newshape = null;

	public String output = "out";
	public int outputint = 0;
	public ArrayList<MyPoint> pointList = new ArrayList<MyPoint>();
	private int selected = 2;
	
	private Color selected_color = Color.RED;
	constants.SHAPE shape = constants.SHAPE.NONE;
	public MyShape[] shapelist_scroll = {
			new MyText(),
			new MyImage(),
			new MyLine(), 
			new MyEllipse(),
			new MyEllipseFilled(),
			new MyRectangle(),
			new MyRectangleFilled()};
	public int shapeSlider = 0;
	/**
	 * 
	 */

	public ArrayList<MyShape> shapesList = new ArrayList<MyShape>();
	private MyShape show_selected = null;
	private boolean started = false; 
	public long StartTime = System.nanoTime();
	private ArrayList<Long> timeList = new ArrayList<Long>();
	//const values over trasbin
	private Directions trash_location = Directions.SOUTH;

	private MyRectangle trashcan = null;
	private Color trashcan_color = Color.BLUE;
	private double trashcan_size  = 0.2; //value between 0.0 and 1.0
	private Color currentColor = trashcan_color;
	public RectPanel(){
		super ();
		this.color = new RandomColor() ;
		this.addMouseListener(mh);
		this.addMouseMotionListener(mh);
		this.setTrashBin(trash_location);
		this.shapesList.add(new MyText());
	}
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
	 * @param x
	 * @param y
	 */
	public void add_point(int x, int y){
		pointList.add(new MyPoint(x,y));
		this.repaint();
	}

	/**
	 * @param s
	 */
	public void add_shape(MyShape s){
		this.shapesList.add(s);
		s.oncreate();
		this.paint(getGraphics());
		super.repaint();
	}
	public void addAction (Actions a){
		if (this.started){
			this.actionsList.add(a);
			timeList.add((int)(System.nanoTime() - this.StartTime)/1000000000l);
		}
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
	public void addRandomLine(){
		shape = SHAPE.LINE;

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
	public void addRandomShape(){
		MyShape s = generateShape();
		modn = 1;
		this.add_shape(s);

	}
	/**
	 * @param s
	 */
	public void addToList(MyShape s){
		this.shapesList.add(s);
		modn=1;
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
	 * @param c
	 */
	public void change_color_of_selected(Color c){
		if (!nothing__selected()){
			MyShape s = shapesList.get(selected);
			s.setColor(c);
			shapesList.set(selected, s);
		}
		else{
			this.currentColor = c;
			this.trashcan_color = c;
		}
		this.repaint();
	}
	/**
	 * @param new_shape
	 */
	public void change_shape_of_selected(MyShape new_shape){
		MyShape ns = this.getCopy(new_shape,this.currentColor);
		if (ns!=null){
			if (!this.nothing__selected()){
				MyShape s = this.getSelected();
				ns.setValues(s.getX1(), s.getY1(), s.getX2(), s.getY2(),s.getColor());
				this.shapesList.remove(this.selected);
				this.shapesList.add( ns);
				this.selected  = this.shapesList.size() -1;
			}else{
				this.shapesList.add(ns);
				this.selected = this.shapesList.size() - 1;
			}
			this.repaint();
		}}

	/**
	 * 
	 */
	public void delete() {
		mh.m = modes.DELETE;
	}

	/**
	 * 
	 */
	public void delete_selected_object(){
		if 	(this.selected >= 0 && this.selected < this.shapesList.size() && this.inTrash(this.shapesList.get(selected))){
			this.addAction(Actions.Delete);
			this.shapesList.remove(selected);
			selected = -1;
		}
	}

	public void Done(){
		this.started = false;
		this.addAction(Actions.Done);
		try {
			PrintWriter writer = new PrintWriter(this.output+this.outputint + ".csv", "UTF-8");
			for (int i = 0; i < this.timeList.size();i++){
				this.timeList.get(i);
				this.actionsList.get(i);
				writer.println(this.timeList.get(i) + "," + this.actionsList.get(i));
			}
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("file error: next line will be tttc");
			System.out.println(System.nanoTime()-this.StartTime);
		}
		this.save();
		int time = (int) ((System.nanoTime() - this.StartTime)/1000000000l);
		JOptionPane.showInputDialog( "time = " + time +"s" );
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
	 * @param g
	 */
	public void drawTrashBin(Graphics2D g2d){
		this.setTrashBin(this.trash_location);
		if (this.trashcan != null){

			this.trashcan.draw(g2d);
		}
	}

	/**
	 * @return
	 */
	MyShape generateShape(){
		int r = RandomColor.randInt(0,this.shapelist_scroll.length - 1);
		MyShape s = this.shapelist_scroll[r];
		if (true){
			Class<?> c = s.getClass();
			try {
				return (MyShape) c.getConstructor().newInstance();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	public MyShape getCopy(MyShape s) {
		Class<?> c = s.getClass();
		Constructor<?> cons;
		try {
			cons = c.getConstructor();
			MyShape copy = (MyShape) cons.newInstance();
			return copy;
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	public MyShape getCopy(MyShape s, Color color) {
		Class<?> c = s.getClass();
		Constructor<?> cons;
		try {
			cons = c.getDeclaredConstructor(Color.class);
			MyShape copy = (MyShape) cons.newInstance(new Object[] {color});
			return copy;
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	public MyShape getSelected() {
		if (!nothing__selected())
			return this.shapesList.get(this.selected);
		else return null;
	}
	public MyShape getShape(int i, int line){
		MyShape s = this.shapelist_scroll[i];
		Class<?> c = s.getClass();

		try {
			MyShape s2 = (MyShape) c.getConstructor().newInstance();
			s2.setLine(line);
			return s2;


		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}



	/**
	 * @param s
	 */
	public void insert_in_list(MyShape s){
		shapesList.remove(shapesList.size() - modn);
		shapesList.add(shapesList.size() - modn + 1,s);
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
	public void mode(){
		mh.m = modes.MODE;
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

	public boolean nothing__selected(){
		return this.selected < 0 ||this.selected >= this.shapesList.size();
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
		//if (this.drawnewshape)
		//	this.newshape.draw(g2d);
		if (trash_location == Directions.SOUTH){
			MyText text = new MyText(3,this.getHeight()-3,this.current_mode, this.modeColor );
			text.draw(g2d);
		}
		//System.out.println("trasbin x1,y1,x2,y2\n");
		//System.out.println("("+this.trashcan.getX1()+ "," + this.trashcan.getY1()+ ',' +this.trashcan.getX2()+ ',' +this.trashcan.getY2()+ ')');
		super.repaint();
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
	/**
	 * 
	 */
	public void RandomColor(){
		mh.m = modes.COLOR;
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

	public void save()
	{
		BufferedImage bImg = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D cg = bImg.createGraphics();
		this.paintAll(cg);
		try {
			if (ImageIO.write(bImg, "png", new File(this.output+".png")))
			{
				System.out.println("-- saved");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

		if (this.selected <0 || this.selected >= this.shapesList.size()){
			this.unselect();
		}else{

			MyShape s = getSelected();
			this.shapesList.remove(s);
			this.shapesList.add(s);
			this.selected = this.shapesList.size() -1;
			this.actionsList.add(Actions.Select);
		}
	}

	public void set_current_mode(String mode){
		this.current_mode = mode;
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
	public void SliderChanged(constants.sliders s){
		this.last_changed = s;
	}

	public void SliderChanged(JSlider Js) {
		switch (this.last_changed){
		case Shape:
			this.shapeSlider = Js.getValue();
			if (this.nothing__selected()){
				this.selected = this.shapesList.size();
				this.newshape = this.getShape(Js.getValue(),this.lineSlider);
				this.drawnewshape =true;
				this.addAction(Actions.Preview);
				repaint();
			} else{
				this.addAction(Actions.Change);
				//System.out.println("blablabla654");
				this.change_shape_of_selected(this.shapelist_scroll[Js.getValue()]);
				this.getSelected().setLine(this.lineSlider);
				repaint();
			}
			break;
		case Line:
			this.lineSlider = Js.getValue();
			this.getSelected().setLine(this.lineSlider);
			break;
		case Color:
			break;
		case None:
			break;
		default:
			break;
		}

	}
	public void start(){

		  JOptionPane.showInputDialog( "Click on OK if you are ready.");

			//this.shapesList.removeAll(this.shapesList);
			if (this.output == "out")
				this.output = JOptionPane.showInputDialog("What is the name of the output file?");
			else
				this.outputint++;
			this.started  = true;
			this.StartTime = System.nanoTime();
			this.addAction(Actions.Start);

	}
	public void copy_selected(){
		MyShape s = this.getCopy(this.getSelected());
		MyShape sel = this.getSelected();
		s.setCoords(sel.getX1(), sel.getY1(), sel.x2, sel.y2);
		s.setColor(sel.getColor());
		s.setLine(sel.getLine());
		this.shapesList.add(s);
		this.selected = this.shapesList.size() -1;
	}
	/**
	 * 
	 */
	public void tool(){
		mh.m = modes.TOOL;
		mh.s = shape;
	}
	public void unselect() {
		this.selected = -1;
		this.drawnewshape = false;
		this.actionsList.add(Actions.Unselect);
	}
}