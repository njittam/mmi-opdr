package Shapes;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

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
