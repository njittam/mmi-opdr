package handlers;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import MMI.RectPanel;
import MMI.SliderPane;
import MMI.constants.sliders;

/**
 * @author mattijn
 * @author Tijs
 */
public class SliderHandler implements ChangeListener{
	private sliders s;
	private RectPanel rp;
	
	
	public SliderHandler(sliders s, RectPanel rp) {
		this.rp = rp;
		this.s =s;
	}

	/* (non-Javadoc)
	 * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		rp.SliderChanged(s);
		System.out.println(e.getSource());
		System.out.println((JSlider) e.getSource());
		rp.SliderChanged((JSlider) e.getSource());
	}
}
