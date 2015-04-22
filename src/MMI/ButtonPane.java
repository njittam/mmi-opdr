package MMI;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JSlider;


/**
 * @author mattijn
 * @author Tijs
 */
public class ButtonPane extends Container{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2709054303160292658L;

	/**
	 * @param rp
	 */
	public ButtonPane(RectPanel rp){
		super();
		super.setLayout(new GridBagLayout());
		ButtonPanel newCollorButton = new ButtonPanel (rp," Change Color! ", constants.functions.RANDOMCOLOR);
		ButtonPanel addButton = new ButtonPanel (rp, " Add ", constants.functions.ADD);
		ButtonPanel modButton = new ButtonPanel (rp, " Mod ", constants.functions.MOD);
		ButtonPanel toolButton = new ButtonPanel(rp, " Tool ", constants.functions.TOOL);
		ButtonPanel modeButton = new ButtonPanel(rp, " Mode ", constants.functions.MODE);
		ButtonPanel lineButton = new ButtonPanel(rp, " Line ", constants.functions.LINE);
		ButtonPanel rectButton = new ButtonPanel(rp, " Rectangle ", constants.functions.RECTANGLE);
		ButtonPanel elipButton = new ButtonPanel(rp, " Ellipse ", constants.functions.ELLIPSE);
		ButtonPanel deleButton = new ButtonPanel(rp, " Delete ", constants.functions.DELETE);
		JSlider s = new JSlider ();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
	    c.weightx = 0.5;
	    c.gridy = 0;
		this.add (newCollorButton,c );
		c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 1;
	    c.gridy = 0;
	    c.weightx = 0.5;
	    this.add(addButton  , c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
	    c.gridx = 2;
	    c.gridy = 0;
		this.add(modButton  , c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
	    c.gridx = 0;
	    c.gridy = 1;
		this.add(toolButton  , c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
	    c.gridx = 1;
	    c.gridy = 1;
		this.add(modeButton  , c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
	    c.gridx = 2;
	    c.gridy = 1;
		this.add(deleButton  , c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
	    c.gridx = 0;
	    c.gridy = 2;
	    this.add(lineButton  , c);
	    c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
	    c.gridx = 1;
	    c.gridy = 2;
		this.add(elipButton  , c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
	    c.gridx = 2;
	    c.gridy = 2;
		this.add(rectButton  , c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
	    c.gridx = 0;
	    c.gridy = 3;
	    SliderPane sp = new SliderPane();
		this.add(sp  , c);		
		
	}
}
