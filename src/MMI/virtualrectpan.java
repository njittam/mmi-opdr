package MMI;

import java.awt.Point;

public class virtualrectpan {
	RectPanel rp;
	private Point virtual_links_boven = new Point();
	private Point virtual_rechts_onder = new Point();
	
	public virtualrectpan(Point vlb, Point vro, RectPanel rp){
		if (vlb.getX() > vro.getX()){
			Point temp = new Point();
			temp.setLocation(vlb.getX(), vlb.getY());
			vlb.setLocation(vro.getX(), vlb.getY());
			vro.setLocation(temp.getX(), vro.getY());
		}
		if (vlb.getY() > vro.getY()){
			Point temp = new Point();
			temp.setLocation(vlb.getX(), vlb.getY());
			vlb.setLocation(vlb.getX(), vro.getY());
			vro.setLocation(vro.getX(), temp.getY());
		}
		this.virtual_links_boven = vlb;
		this.virtual_rechts_onder = vro;
		this.rp = rp;
	}
	
	public Point ToRp(Point p){
		Point temp = new Point();
		temp.setLocation(virtual_rechts_onder);
		temp.setLocation(temp.getX()-this.virtual_links_boven.getX(), temp.getY()-this.virtual_rechts_onder.getY());
		double x = (p.getX() - this.virtual_links_boven.getX()) * rp.getWidth()/temp.getX();
		double y = (p.getY() - this.virtual_links_boven.getY()) * rp.getHeight()/temp.getY();
		p.setLocation(x, y);
		Point p2 = new Point();
		p2.setLocation(x, y);
		return p2;
	}
}
