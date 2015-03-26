package opdr3;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JPanel;

public class RectPanel extends JPanel {
	ArrayList<MyShape> shapesList = new ArrayList<MyShape>();
	private int modn = 1;
	public RandomColor color ;
	public RectPanel(){
		super ();
		this.color = new RandomColor() ;
	}

	@Override
	public void paintComponent ( Graphics g) {
		super . paintComponent (g );
		g.setColor ( this.color.toColor() );
		//g.fillRect (0 , 0 , 0 , 0);	
		Graphics2D g2d = (Graphics2D) g;
		for (MyShape s : shapesList)
			s.draw(g2d);
		super.repaint();
	}
	public void RandomColor(){
		this.color.newColor();
		//setText(this.color.toString());
		this.repaint();
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
		MyShape s = shapesList.get(shapesList.size() - modn);
		s = generateShape();
		shapesList.remove(shapesList.size() - modn);
		shapesList.add(shapesList.size() - modn + 1,s);
		modn++;
		if (modn > shapesList.size())
			modn = 1;
		super.repaint();
	}

}