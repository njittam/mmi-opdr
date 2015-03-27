package MMI;
import javax.swing.SwingUtilities;


public class Main {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		SwingUtilities.invokeLater (new Runnable () {
			public void run () {
				new Window ();
			}
		});

	}

}
//Iets leuks.