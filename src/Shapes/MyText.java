package Shapes;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class MyText extends MyShape {
	private final String objectname = "MyText";
	private final String text = "Somebody tell me why I'm on my own";
	
	
	private int size = 13;
	private String font = "Purisa";
	public MyText(){
		super(20,20,60,60);
	}
	
	public MyText(int x1, int y1, int x2, int y2){
		super(x1,y1,x2,y2);
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
		g.drawString(this.text, super.x1, super.y1);
	}
	
	
	@Override
	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		return x>= this.x1 && x <= this.x2 && y <= this.y2 && y >= this.y1;
	}

	@Override
	public String getObjectName() {
		return this.objectname;
	}

	@Override
	public void oncreate() {
		// TODO Auto-generated method stub
		
	}

}
