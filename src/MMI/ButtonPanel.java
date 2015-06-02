package MMI;
import handlers.ButtonHandler;
import handlers.ButtonHandler2;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author mattijn
 * @author Tijs
 */
public class ButtonPanel extends JPanel {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = -697478526173572538L;
		JButton b;
		public RectPanel rp;
		
		/**
		 * @param rp
		 * @param text
		 * @param add
		 */
		public ButtonPanel (RectPanel rp, String text, constants.functions add) {
			super ();
			this.rp = rp;
			this.b = new JButton (text);
			this.add (this.b );
			this.b.addActionListener ( new ButtonHandler (this,add));
		}
			public ButtonPanel (RectPanel rp, String text, constants.functions2 add) {
				super ();
				this.rp = rp;
				this.b = new JButton (text);
				this.add (this.b );
				this.b.addActionListener ( new ButtonHandler2 (this,add,rp));
			}
		/**
		 * @param text
		 */
		public void setText(String text) {
			b.setText(text);
			b.repaint();
		}
}