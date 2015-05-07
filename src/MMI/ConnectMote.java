package MMI;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import motej.Mote;
import motej.MoteFinder;
import motej.MoteFinderListener;



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
		super . setDefaultCloseOperation (EXIT_ON_CLOSE);
		MoteFinderListener listener = new MoteFinderListener() {
            
            public void moteFound(final Mote mote) {
                    System.out.println("Found mote: " + mote.getBluetoothAddress());
                    mote.rumble(2000l);
                    SwingUtilities.invokeLater (new Runnable () {
            			public void run () {
            				new Window (mote);
            			}
            		});
            }
            
		};   
		MoteFinder finder = MoteFinder.getMoteFinder();
		finder.addMoteFinderListener(listener);
		super.setVisible ( true );
		finder.startDiscovery();
		try {
			Thread.sleep(30000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finder.stopDiscovery();
		super.setTitle ("stopped searching for Motes");
		super.setVisible ( true );
	}
}
