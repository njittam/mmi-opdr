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
	public enum functions2 {None, Select ,Resize ,Move, Color, Shape,Edit};//this and funct_names should be the same size
	public static String[] funct_names = {"None", "Select", "Resize", "Move/ Select",  "color", "add Shape","Edit"};
	public enum  modes {TOOL , MODE, DELETE, COLOR};
	public enum sliders {Color,Shape,Line, None};
	public Color SliderColor;

}
