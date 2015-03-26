package opdr3;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler implements ActionListener {
	ButtonPanel bp;
	private int function;
	public ButtonHandler(ButtonPanel bp,int function){
		this.bp = bp;
		this.function = function;
	}

	public void actionPerformed ( ActionEvent e ) {
		// TODO : add code here that will
		// be ran when the button is clicked
		if (function == bp.RANDOMCOLOR){
			bp.rp.RandomColor();
			//bp.rp.color.newColor();
			//bp.setText(bp.rp.color.toString());
			//bp.rp.repaint();
		}
		if (function == bp.ADD){
			bp.rp.addRandomShape();
		}
		if (function == bp.MOD){
			bp.rp.alterNextShape();
		}
	}
}