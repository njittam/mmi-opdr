package opdr3;

import java.awt.Color;
import java.util.Random;


public class RandomColor {
	 Color color;
	static int randInt(int min, int max) {

	    // NOTE: Usually this should be a field rather than a method
	    // variable so that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	    
	}
	
	public String toString(){
		return this.color.toString();
	}
	public Color toColor() {
		return this.color;
	}
	public void newColor(){
		this.color = new Color(randInt(0,255),randInt(0,255),randInt(0,255));
	}
	public RandomColor(){
    this.color = new Color(randInt(0,255),randInt(0,255),randInt(0,255));	
    }
}
