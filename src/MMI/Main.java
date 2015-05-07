package MMI;
import javax.swing.SwingUtilities;

//import org.apache.log4j.PropertyConfigurator;

import wiitracker.driver.Driver;
import wiitracker.ui.MoteFinderUI;
/**
 * @author mattijn
 * @author Tijs
 */
public class Main {
	public static void main(final String[] args) {
		System.out.println("ḧello world " + args.length);
		/*/for (int i = 0; i <args.length; i++)
			System.out.println(args[i]);
		
		Driver d = new Driver();
		PropertyConfigurator.configure("log4j.properties");
		// Workaround for bug in Bluecove which prevents connection
        // to the Wiimote.
        System.setProperty("bluecove.jsr82.psm_minimum_off", "true");
        MoteFinderUI finderUI = new MoteFinderUI();
        finderUI.pack();
        finderUI.setVisible(true);
        try {
            finderUI.setMoteFinder();
        } catch (RuntimeException e) {
            d.errorPopup(finderUI);
            System.exit(1);
        }*/
		SwingUtilities.invokeLater (new Runnable () {
			public void run () {
				new ConnectMote ();
			}
		});

	}

}
