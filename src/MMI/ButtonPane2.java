package MMI;

import handlers.SliderHandler;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Dictionary;

import javax.swing.JColorChooser;
import javax.swing.JSlider;

import MMI.constants.functions2;
import MMI.constants.sliders;

public class ButtonPane2 extends Container {
	public ButtonPane2(RectPanel rp){
		super();
		super.setLayout(new GridBagLayout());
		this.addButton(0,0,functions2.Color,rp);
		this.addButton(0,1,functions2.Shape,rp);
		this.addButton(0,2,functions2.Resize,rp);
		this.addButton(0,3,functions2.Move,rp);
		this.addButton(0,4,functions2.Select,rp);
		this.addButton(0, 5, functions2.Edit, rp);
		JColorChooser cc = new JColorChooser();
		JSlider shape = new JSlider(0, rp.shapelist_scroll.length -1);
		shape.setMajorTickSpacing(1);
		shape.setToolTipText("shapes");
		shape.setPaintTicks(true);
		System.out.println( cc.getColor());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 1;
	    c.weightx = 0.5;
	    c.gridy = 0;
		//this.add(cc, c);
	    JSlider line = new JSlider(0, 100);
		line.setMinorTickSpacing(1);
		line.setMajorTickSpacing(5);
		line.setPaintTicks(true);
		line.setValue(3);
		line.setToolTipText("linethickness");
		this.addSlider(1,4,shape,sliders.Shape,rp);
		this.addSlider(1,5,line,sliders.Line,rp);
	}
	
	public void addSlider(int x, int y, JSlider s,sliders s2,RectPanel rp){
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = x;
	    c.weightx = 0.5;
	    c.gridy = y;
	    s.addChangeListener(new SliderHandler(s2 ,rp));
		this.add (s,c);
	}
	
	public void addButton(int x, int y, functions2 f,RectPanel rp ){
		ButtonPanel b = new ButtonPanel (rp, constants.funct_names[f.ordinal()],f);
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = x;
	    c.weightx = 0.5;
	    c.gridy = y;
		this.add (b,c);
	}
}
