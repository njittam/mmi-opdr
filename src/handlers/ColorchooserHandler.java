package handlers;

import javax.swing.JColorChooser;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import MMI.RectPanel;

public class ColorchooserHandler implements ChangeListener{
	RectPanel rp;
	public ColorchooserHandler(RectPanel rp) {
		this.rp = rp;
	}
	@Override
	public void stateChanged(ChangeEvent arg0) {
		ColorSelectionModel cc = (ColorSelectionModel) arg0.getSource();
		rp.change_color_of_selected(cc.getSelectedColor());
	}

}
