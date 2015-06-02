package MMI;

import handlers.SliderHandler;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Hashtable;

import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JSlider;

import MMI.constants.functions2;
import MMI.constants.sliders;

public class ButtonPane2 extends Container {
	public ButtonPane2(RectPanel rp){
		super();
		Container buttons = new Container();
		buttons.setLayout(new GridBagLayout());
		Container resize_move = new Container();
		resize_move.setLayout(new GridBagLayout());
		Container start_stop = new Container();
		start_stop.setLayout(new GridBagLayout());
		Container add_des = new Container();
		add_des.setLayout(new GridBagLayout());
		super.setLayout(new GridBagLayout());
		start_stop = this.addButton(1,0,functions2.End,rp, start_stop);
		start_stop = this.addButton(0, 0, functions2.Start, rp, start_stop);
		buttons = this.addButton(0,200,functions2.Color,rp, buttons);
		
		resize_move = this.addButton(0,0,functions2.Resize,rp, resize_move);
		resize_move = this.addButton(1,0,functions2.Move,rp, resize_move);
		add_des = this.addButton(0,6, functions2.Shape,rp,add_des);
		add_des = this.addButton(1, 6, functions2.unselect, rp, add_des);
		//this.addButton(0,4,functions2.Select,rp);
		buttons = this.addButton(0, 7, functions2.Edit, rp, buttons);
		JColorChooser cc = new JColorChooser();
		JSlider shape = new JSlider(0, rp.shapelist_scroll.length -1);
		shape.setMajorTickSpacing(1);
		shape.setToolTipText("shapes");
		shape.setPaintTicks(true);
		shape.setValue(0);
		Hashtable<Integer, JLabel> labels = new Hashtable<Integer, JLabel>();
		for (int i = 0 ; i < rp.shapelist_scroll.length;i++){
			labels.put(i,new JLabel(rp.shapelist_scroll[i].getObjectName()));
		}
		shape.setLabelTable(labels);
		shape.setPaintLabels(true);
	    JSlider line = new JSlider(0, 100);
		line.setMinorTickSpacing(1);
		line.setMajorTickSpacing(5);
		line.setPaintTicks(true);
		line.setValue(3);
		line.setToolTipText("linethickness");
		GridBagConstraints c1 = new GridBagConstraints();
		c1.fill = GridBagConstraints.BOTH;
	    c1.gridx = 0;
	    c1.weightx = 0.5;
	    c1.gridy = 0;
		buttons.add(resize_move,c1);
		c1.fill = GridBagConstraints.BOTH;
	    c1.gridx = 100;
	    c1.weightx = 0.5;
	    c1.gridy = 0;
		buttons.add(start_stop,c1);
		c1.gridx = 1;
		buttons.add(add_des, c1);
		this.add(buttons);
		this.addSlider(1,0,shape,sliders.Shape,rp);
		this.addSlider(2,0,line,sliders.Line,rp);
		
	}
	
	public void addButton(int y, int x, functions2 f,RectPanel rp ){
		ButtonPanel b = new ButtonPanel (rp, constants.funct_names[f.ordinal()],f);
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = x;
	    c.weightx = 0.5;
	    c.gridy = y;
		this.add (b,c);
	}
	
	public Container addButton(int y, int x, functions2 f,RectPanel rp ,Container ct){
		ButtonPanel b = new ButtonPanel (rp, constants.funct_names[f.ordinal()],f);
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
	    c.gridx = x;
	    c.weightx = 0.5;
	    c.gridy = y;
		ct.add (b,c);
		return ct;
	}
	public void addSlider(int y, int x, JSlider s,sliders s2,RectPanel rp){
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
	    c.gridx = x;
	    c.weightx = 0.5;
	    c.gridy = y;
	    s.addChangeListener(new SliderHandler(s2 ,rp));
		this.add (s,c);
	}
}
