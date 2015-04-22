package MMI;
import javax.swing.SwingUtilities;


/**
 * @author mattijn
 * @author Tijs
 */
public class Main {
	public static void main(final String[] args) {
		SwingUtilities.invokeLater (new Runnable () {
			public void run () {
				new Window ();
			}
		});

	}

}
