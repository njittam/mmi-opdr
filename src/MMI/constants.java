package MMI;

import java.awt.Color;

/**
 * @author mattijn
 * @author Tijs
 */
public class constants {
	public enum Actions {Add,Change, Color, Delete, Done,Move,Preview, Resize,Select, Start, Unselect, Edit, Copy }; 
	public enum Directions {EAST,NORTH,SOUTH,WEST};
	public enum functions { ADD, DELETE , ELLIPSE, LINE, MOD ,MODE , RANDOMCOLOR, RECTANGLE ,TOOL };
	public enum functions2 {Color,Copy, Edit ,End ,Move, None, Resize,Select,Shape,Start, unselect};//this and funct_names should be the same size
	public enum  modes {COLOR , DELETE, MODE, TOOL}
	public enum SHAPE {ELLIPSE,LINE,NONE,RECT};
	public enum sliders {Color,Line,None, Shape};
	public static String[] funct_names = {"Color","Copy","Edit" ,"Done" , "Move / Select","None", "Resize" ,"Select","Add Shape","Start","Deselect"};
	public Color SliderColor;;

}
