package MMI;

import handlers.ColorchooserHandler;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ColorChooser extends JFrame  {
    public ColorChooser(RectPanel rp) {
    	super ();
		super.setTitle ("seaching for Motes");
		super.setSize ( new Dimension (840 , 350));
		super . setLocationRelativeTo ( null );
    //    super(new BorderLayout());
        JLabel banner = new JLabel("Welcome to the Tutorial Zone!", JLabel.CENTER);
        banner.setForeground(Color.yellow);
        JColorChooser tcc = new JColorChooser(banner.getForeground());
        add(tcc, BorderLayout.PAGE_END);
        tcc.getSelectionModel().addChangeListener(new ColorchooserHandler(rp));
        this.setVisible(true);
    }
}