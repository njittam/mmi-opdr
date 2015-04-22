package MMI;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;

import javax.swing.JSlider;

/**
 * @author mattijn
 * @author Tijs
 */
public class SliderPane extends Container{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JSlider sRed;
	JSlider sGreen;
	JSlider sBlue;
	JSlider s4;
	public Color c;
	
	/**
	 * 
	 */
	public SliderPane(){
		super();
		this.sRed = new JSlider(0,255,100);
		this.sGreen = new JSlider(0,255,100);
		this.sBlue = new JSlider(0,255,100);
		this.s4 = new JSlider(0,255);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
	    c.weightx = 0.5;
	    c.gridy = 0;
	    this.add(this.sRed, c);
		c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 1;
	    c.weightx = 0.5;
	    c.gridy = 0;
	    this.add(this.sGreen,c);
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 2;
	    c.weightx = 0.5;
	    c.gridy = 0;
	    this.add(this.sBlue,c);
	}
}
