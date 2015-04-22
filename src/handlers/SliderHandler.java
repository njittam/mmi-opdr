package handlers;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import MMI.SliderPane;
import MMI.constants.*;

/**
 * @author mattijn
 * @author Tijs
 */
public class SliderHandler implements ChangeListener{
	private sliders s;
	private SliderPane sp;
	
	/**
	 * @param s
	 * @param sp
	 */
	public SliderHandler (sliders s, SliderPane sp){
		this.s = s;
		this.sp = sp;
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
	 */
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
