package MMI;

import handlers.ColorchooserHandler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;

public class ColorChooser extends JFrame  {
    public ColorChooser(RectPanel rp, final JButton b) {
    	super ();
		super.setTitle ("ColorChooser");
		super.setSize ( new Dimension (440 , 350));
		super . setLocationRelativeTo ( null );
		this.setAlwaysOnTop( true );
		this.setResizable(false);
		this.setUndecorated(true);
		b.setVisible(false);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				b.setVisible(true);
			}
		});
		this.getRootPane().setWindowDecorationStyle(JRootPane.COLOR_CHOOSER_DIALOG);
    //    super(new BorderLayout());
        JLabel banner = new JLabel("Welcome to paint!", JLabel.CENTER);
        banner.setForeground(Color.yellow);
        JColorChooser tcc = new JColorChooser(banner.getForeground());
        add(tcc, BorderLayout.PAGE_END);
        tcc.getSelectionModel().addChangeListener(new ColorchooserHandler(rp));
        this.setVisible(true);
    }
}