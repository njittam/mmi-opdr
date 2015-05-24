package Shapes;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import javax.swing.JOptionPane;

public class MyImage extends MyShape {
	private final String objectname = "MyImage";
	private Image img;
	
	public MyImage (){
		
	}
	
	public void draw(Graphics2D g2d){
		super.draw(g2d);
		ImageObserver io = new ImageObserver() {
			
			@Override
			public boolean imageUpdate(Image img, int infoflags, int x, int y,
					int width, int height) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		super.update();
		g2d.drawImage(img, super.startx, super.starty, super.width, super.height, io);
	}
	
	@Override
	public boolean contains(int x, int y) {
		return x>= Math.min(this.x1,this.x2) && x <= Math.max(this.x1,this.x2) && y >= Math.min(this.y1,this.y2) && y <= Math.max(this.y1,this.y2);
	}

	@Override
	public String getObjectName() {
		return this.objectname;
	}

	@Override
	public void oncreate() {
		String name = JOptionPane.showInputDialog("What is the file name?");
        System.out.println( "Hello " + name + '!');
		img =  Toolkit.getDefaultToolkit().getImage(name);
	}

}
