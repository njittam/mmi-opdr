package handlers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MMI.ButtonPanel;
import MMI.constants;
import MMI.constants.functions;


/**
 * @author mattijn
 * @author Tijs
 * 
 */
public class ButtonHandler implements ActionListener {
	ButtonPanel bp;
	private constants.functions function;
	/**
	 * @param bp
	 * @param add
	 */
	public ButtonHandler(ButtonPanel bp,functions add){
		this.bp = bp;
		this.function = add;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed ( ActionEvent e ) {
		if (function ==functions.RANDOMCOLOR){
			bp.rp.RandomColor();
		}
		if (function == functions.ADD){
			bp.rp.addRandomShape();
		}
		if (function == functions.MOD){
			bp.rp.alterNextShape();
		}
		if (function == functions.TOOL){
			bp.rp.tool();
		}
		if (function == functions.MODE){
			bp.rp.mode();
		}
		if (function == functions.ELLIPSE){
			bp.rp.addRandomEllipse();
		}
		if (function == functions.RECTANGLE){
			bp.rp.addRandomRectangle();
		}
		if (function == functions.LINE){
			bp.rp.addRandomLine();
		}
		if (function == functions.DELETE){
			bp.rp.delete();
		}
	}
}