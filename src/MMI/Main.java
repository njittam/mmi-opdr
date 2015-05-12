package MMI;
import javax.swing.SwingUtilities;

//import org.apache.log4j.PropertyConfigurator;

/**
 * @author mattijn
 * @author Tijs
 */
public class Main {
	public static void main(final String[] args) {
		System.out.println("ḧello world " + args.length);
		SwingUtilities.invokeLater (new Runnable () {
			public void run () {
				System.out.println("ḧello world " + args.length);
				new ConnectMote ();
			}
		});

	}

}
