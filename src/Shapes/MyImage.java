package Shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import MMI.RandomColor;

public class MyImage extends MyShape {
	private String name = "./eifel.png";
	private final String objectname = "Image";
	
	public MyImage (){
		int xmin = super.xmin;
		int xmax = super.xmax;
		int ymin = super.ymin;
		int ymax = super.ymax;
		xmin = RandomColor.randInt(xmin,xmax-1);
		xmax = RandomColor.randInt(xmin + 1,xmax);
		ymin = RandomColor.randInt(ymin,ymax-1);
		ymax = RandomColor.randInt(ymin + 1,ymax);
		this.x1 =xmin;
		this.x2 =xmax;
		this.y1 =ymin;
		this.y2 =ymax;
	}
	
	@Override
	public boolean contains(int x, int y) {
		return x>= Math.min(this.x1,this.x2) && x <= Math.max(this.x1,this.x2) && y >= Math.min(this.y1,this.y2) && y <= Math.max(this.y1,this.y2);
	}
	public MyImage(Color c){
		super(c);
	}
	public void draw(Graphics2D g2d){
		super.draw(g2d);
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(this.name));
		} catch (IOException e) {
			System.out.println("picture not found.");
		}
		super.update();
		//g2d.drawImage(img, op, this.startx, this.starty);
		g2d.drawImage(img, super.startx, super.starty, super.width, super.height, null);
	}

	@Override
	public String getObjectName() {
		return this.objectname;
	}

	@Override
	public void oncreate() {
		this.name = JOptionPane.showInputDialog("What is the file name?");
        System.out.println( "Hello " + name + '!');
		//img =  Toolkit.getDefaultToolkit().getImage(name);
	}

}
