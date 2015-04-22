package MMI;

import java.awt.Color;

/**
 * @author mattijn
 * @author Tijs
 */
public class constants {
	public enum Directions {NORTH,EAST,SOUTH,WEST}; 
	public enum SHAPE {NONE,LINE,RECT,ELLIPSE};
	public enum functions { TOOL, RANDOMCOLOR , ADD, MOD, ELLIPSE ,LINE , RECTANGLE, MODE ,DELETE };
	public enum  modes {TOOL , MODE, DELETE, COLOR};
	public enum sliders {RED,BLUE,GREEN};
	public Color SliderColor;

}
