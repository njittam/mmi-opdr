package MMI;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import motej.Mote;

/**
 * @author mattijn
 * @author Tijs
 */
public class Window extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2325890952970738596L;

	/**
	 * 
	 */
	public Window (Mote mote) {
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
		RectPanel rp = new RectPanel (mote);
		super.getContentPane().add (rp , BorderLayout.CENTER );
		ButtonPane bp = new ButtonPane(rp);
		super.getContentPane().add (bp , BorderLayout.EAST );
		//super.getContentPane().add (new SliderPane() , BorderLayout.NORTH);
		super.setVisible ( true );
	}
}
