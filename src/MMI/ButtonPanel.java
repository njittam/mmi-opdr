package MMI;
import handlers.ButtonHandler;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = -697478526173572538L;
		public RectPanel rp;
		JButton b;
		public ButtonPanel (RectPanel rp, String text, constants.functions add) {
			super ();
			this.rp = rp;
			this.b = new JButton (text);
			this.add (this.b );
			this.b.addActionListener ( new ButtonHandler (this,add));
		}
		public void setText(String text) {
			b.setText(text);
			b.repaint();
		}
}