package handlers;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import MMI.SliderPane;
import MMI.constants.*;

public class SliderHandler implements ChangeListener{
	private sliders s;
	private SliderPane sp;
	public SliderHandler (sliders s, SliderPane sp){
		this.s = s;
		this.sp = sp;
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		switch (s){
		case GREEN:
			
			break;
		case RED:
			
			break;
		case BLUE:
			
			break;
			
		}
		
	}
}
