package Shapes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JOptionPane;

import MMI.RandomColor;

public class MyText extends MyShape {
	private String font = "Purisa";
	private final String objectname = "MyText";


	private int size = 14;
	private String text = "Click on edit to change this text";
	
	public MyText(){
		int xmin = super.xmin;
		int ymin = super.ymin;
		xmin = RandomColor.randInt(xmin,xmax-1);
		ymin = RandomColor.randInt(ymin,ymax-1);
		this.x1 =xmin;
		this.x2 = this.x1 + text.length() * (size / 2);
		this.y1 =ymin;
		this.y2 =this.y1 + this.size;
	}

	public MyText(int x1, int y1, int x2, int y2){
		super(x1,y1,x2,y2);
	}
	public MyText(Color c){
		super(c);
	}
	public MyText(int x, int y, String text, Color c) {
		this.x1=x;
		this.x2 = x+2;
		this.y1 = y-2;
		this.y2 = y;
		update();
		this.setColor(c);
		this.setText(text);
	}

	@Override
	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		return x>= Math.min(this.x1,this.x2) && x <= Math.max(this.x1,this.x2) && y >= Math.min(this.y1,this.y2) && y <= Math.max(this.y1,this.y2);
	}

	public void draw(Graphics2D g){
		super.draw(g);
		RenderingHints rh =
				new RenderingHints(RenderingHints.KEY_ANTIALIASING, 
						RenderingHints.VALUE_ANTIALIAS_ON);

		rh.put(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);

		g.setRenderingHints(rh);
		g.setFont(new Font(this.font , Font.PLAIN, this.size));
		this.update();
		g.drawString(this.text, Math.min(super.x1,super.x2), Math.max(super.y1,super.y2));
		//g.drawString(this.text, super.x1, super.y1+(super.height/2));
	}
	public void fix_selectbox(){
		setText(this.text);
	}
	@Override
	public String getObjectName() {
		return this.objectname;
	}

	@Override
	public void oncreate() {
		String text = JOptionPane.showInputDialog("What is the text to dispay?");
		if (text == null)
			this.setText("null");
		else
			this.setText(text);

	}
	public void setCoords(int x1, int y1, int x2, int y2){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		update();
		this.size = this.height;
		fix_selectbox();
	}
	public void setText(String text){
		this.text = text;
		this.x2 = this.x1 + text.length() * (size/2);
	}

}
