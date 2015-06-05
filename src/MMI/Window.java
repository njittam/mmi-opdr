package MMI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JRootPane;

import wiiusej.Wiimote;

/**
 * @author mattijn
 * @author Tijs
 */
public class Window extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2325890952970738596L;

	public Window () {
		// ’super ’ calls a function inherited from the parent class ( JFrame )
		super ();
		System.out.println("ḧello world ");
		//Wiimote[] motes = WiiUseApiManager.getWiimotes(1, true);
		System.out.println("ḧello world " );
		super.setTitle (" paint ");
		super.setSize ( new Dimension (840 , 350));
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getWidth());
		int ySize = ((int) tk.getScreenSize().getHeight());
		super.setSize(xSize,ySize);
		//this.setUndecorated(true);
		//this.getRootPane().setWindowDecorationStyle(JRootPane.ERROR_DIALOG);
		//this.setResizable(false);
		// Make sure the window appears in the middle of your screen
		super . setLocationRelativeTo ( null );
		// Determines what should happen when the frame is closed
		super . setDefaultCloseOperation (EXIT_ON_CLOSE);
		// Chooses a certain layout type for the elements in this frame
		super . getContentPane (). setLayout ( new BorderLayout ());
		RectPanel rp = new RectPanel ();
		rp.setBackground(Color.WHITE);
		super.getContentPane().add (rp , BorderLayout.CENTER );
		ButtonPane bp = new ButtonPane(rp);
		ButtonPane2 bp2 = new ButtonPane2(rp);
		super.getContentPane().add (bp2 , BorderLayout.NORTH);
		//super.getContentPane().add (new SliderPane() , BorderLayout.NORTH);
		super.setVisible ( true );
	}
	/**
	 * 
	 */
	public Window (Wiimote mote) {
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
