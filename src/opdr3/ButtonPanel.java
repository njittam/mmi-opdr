package opdr3;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
	RectPanel rp;
	JButton b;
	public static int RANDOMCOLOR = 1;
	public static int ADD = 2;
	public static int MOD = 3;
	public ButtonPanel (RectPanel rp, String text, int function) {
		super ();
		this.rp = rp;
		// Add a button to the panel . The argument to the JButton constructor
		// will become the text on the button .
		this.b = new JButton (text);
		this.add (this.b );
		this.b.addActionListener ( new ButtonHandler (this,function));
	}
	public void setText(String text) {
		// TODO Auto-generated method stub
		b.setText(text);
		//b.update(getGraphics());
		b.repaint();
	}
}