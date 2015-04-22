package MMI;
import java.awt.Color;
import java.util.Random;


/**
 * @author Mattijn
 * @author Tijs
 */
public class RandomColor {
	 Color color;
	
	 /**
	 * @param min
	 * @param max
	 * @return
	 */
	public static int randInt(int min, int max) {

	    // NOTE: Usually this should be a field rather than a method
	    // variable so that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	    
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return this.color.toString();
	}
	
	/**
	 * @return
	 */
	public Color toColor() {
		return this.color;
	}
	
	/**
	 * 
	 */
	public void newColor(){
		this.color = new Color(randInt(0,255),randInt(0,255),randInt(0,255));
	}
	
	/**
	 * 
	 */
	public RandomColor(){
		this.color = new Color(randInt(0,255),randInt(0,255),randInt(0,255));	
    }
}
