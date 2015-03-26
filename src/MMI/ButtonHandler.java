package MMI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonHandler implements ActionListener {
	ButtonPanel bp;
	private constants.functions function;
	public ButtonHandler(ButtonPanel bp,constants.functions add){
		this.bp = bp;
		this.function = add;
	}

	public void actionPerformed ( ActionEvent e ) {
		// TODO : add code here that will
		// be ran when the button is clicked
		if (function == constants.functions.RANDOMCOLOR){
			bp.rp.RandomColor();
			//bp.rp.color.newColor();
			//bp.setText(bp.rp.color.toString());
			//bp.rp.repaint();
		}
		if (function == constants.functions.ADD){
			bp.rp.addRandomShape();
		}
		if (function == constants.functions.MOD){
			bp.rp.alterNextShape();
		}
		if (function == constants.functions.TOOL){
			bp.rp.tool();
		}
		if (function == constants.functions.MODE){
			bp.rp.mode();
		}
		if (function == constants.functions.ELLIPSE){
			bp.rp.addRandomEllipse();
		}
		if (function == constants.functions.RECTANGLE){
			bp.rp.addRandomRectangle();
		}
		if (function == constants.functions.LINE){
			bp.rp.addRandomLine();
		}
		if (function == constants.functions.DELETE){
			bp.rp.delete();
		}
	}
}