package handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import MMI.ButtonPanel;
import MMI.ColorChooser;
import MMI.RectPanel;
import MMI.constants.Actions;
import MMI.constants.functions2;
import Shapes.MyShape;

public class ButtonHandler2 implements ActionListener{

	private ButtonPanel bp;
	private functions2 function;
	RectPanel rp;

	public ButtonHandler2(ButtonPanel bp,functions2 add, RectPanel rp){
		this.bp = bp;
		this.function = add;
		this.rp = rp;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch(function){
		case Shape:
			//rp.set_current_mode("shape");
			if (rp.drawnewshape){
				rp.addToList(rp.newshape);
				rp.drawnewshape = false;
			}else{
				MyShape s = rp.getShape(rp.shapeSlider,rp.lineSlider);
				rp.change_shape_of_selected(s);
			}
			break;
		case Edit:
			//rp.set_current_mode("Edit");
			rp.getSelected().oncreate();
			break;
		case Move:
			rp.set_current_mode("Move/ Select");
			rp.mode();
			break;
		case Resize:
			rp.set_current_mode("Resize");
			rp.tool();
			break;
		case Color:
			//rp.set_current_mode("Color");
			//ColorChooser cc = ;
			rp.addAction(Actions.Color);
			SwingUtilities.invokeLater (new Runnable (){
				public void run (){;
				new ColorChooser(rp);
				}
		    });
			break;
		case End:
			rp.addAction(Actions.Done);
			rp.Done();
			break;
		case None:
			break;
		case Select:
			break;
		case Start:
			
			rp.start();
			rp.addAction(Actions.Start);
			break;
		default:
			break;
			
		}
			
			
	}

}
