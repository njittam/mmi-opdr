package MMI;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import wiiusej.WiiUseApiManager;
import wiiusej.Wiimote;





public class ConnectMote extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConnectMote() {
		// ’super ’ calls a function inherited from the parent class ( JFrame )
		super ();
		super.setTitle ("seaching for Motes");
		super.setSize ( new Dimension (840 , 350));
		super . setLocationRelativeTo ( null );
		// Determines what should happen when the frame is closed
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		int nMotes = 0;
		Wiimote mote;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setVisible ( true );
		while (nMotes == 0){
			Wiimote[] motes = WiiUseApiManager.getWiimotes(1, true);
			nMotes = motes.length;
			if (nMotes != 0)
			{
				mote = motes[0];
			}
		}
		super.setDefaultCloseOperation(HIDE_ON_CLOSE);
		SwingUtilities.invokeLater (new Runnable (){
					public void run (){
						Wiimote[] motes = WiiUseApiManager.getWiimotes(1, true);
						new Window(motes [0]);
					}
			});
	}
}
