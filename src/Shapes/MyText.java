package Shapes;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class MyText extends MyShape {
	private final String objectname = "MyText";
	private final String text = "";
	private int size = 13;
	private String font = "Purisa";
	public void draw(Graphics2D g){
		super.draw(g);
		this.x1 = 50;
		this.y1 = 150;
		this.x2 = 63;
		this.y2 = 180;
		RenderingHints rh =
	            new RenderingHints(RenderingHints.KEY_ANTIALIASING, 
	            RenderingHints.VALUE_ANTIALIAS_ON);

	        rh.put(RenderingHints.KEY_RENDERING,
	               RenderingHints.VALUE_RENDER_QUALITY);

	        g.setRenderingHints(rh);

	        g.setFont(new Font(font , Font.PLAIN, size));
		g.drawString("Somebody tell me why I'm on my own", super.x1, super.y1);
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

}
