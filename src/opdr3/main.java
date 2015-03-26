package opdr3;

import javax.swing.SwingUtilities;


public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater (new Runnable () {
			public void run () {
				new Window ();
			}
		});

	}

}
