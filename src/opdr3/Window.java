package opdr3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
public class Window extends JFrame{
	public Window () {
		// ’super ’ calls a function inherited from the parent class ( JFrame )
		super ();
		super.setTitle (" Callbacks ");
		super.setSize ( new Dimension (840 , 350));
		// Make sure the window appears in the middle of your screen
		super . setLocationRelativeTo ( null );
		// Determines what should happen when the frame is closed
		super . setDefaultCloseOperation (EXIT_ON_CLOSE);
		// Chooses a certain layout type for the elements in this frame
		super . getContentPane (). setLayout ( new BorderLayout ());
		RectPanel rp = new RectPanel ();
		ButtonPanel newCollorButton = new ButtonPanel (rp," Change Color! ", ButtonPanel.RANDOMCOLOR);
		ButtonPanel addButton = new ButtonPanel (rp, " Add ", ButtonPanel.ADD);
		ButtonPanel modButton = new ButtonPanel (rp, " Mod ", ButtonPanel.MOD);
		super.getContentPane().add (rp , BorderLayout.CENTER );
		ButtonPane bp = new ButtonPane();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
	    c.weightx = 0.5;
	    c.gridy = 0;
		bp.add (newCollorButton,c );
		c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 1;
	    c.gridy = 0;
	    c.weightx = 0.5;
	    bp.add(addButton  , c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
	    c.gridx = 2;
	    c.gridy = 0;
		bp.add(modButton  , c);
		super.getContentPane().add (bp , BorderLayout.NORTH );
		super.setVisible ( true );
	}
}
