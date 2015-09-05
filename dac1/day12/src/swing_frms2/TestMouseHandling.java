package swing_frms2;

import java.awt.Color;
import java.awt.event.*;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestMouseHandling extends JFrame {
	private JPanel p1;
	private Random r1;
	private Color c;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestMouseHandling t1 = new TestMouseHandling(
				"Understanding inner + adapters");

	}

	public TestMouseHandling(String mesg) {
		super(mesg);
		setSize(300, 300);
		setLocationRelativeTo(null);
		// create & add panel
		p1 = new JPanel();
		add(p1);
		r1 = new Random();
		c = Color.WHITE;
		// attach/register mouse listener & mouse motion listener to the current
		// frm
		// new MouseAdapter() --- inst of class which extends from MA

		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent arg0) {
				c = new Color(r1.nextInt(256), r1.nextInt(256), r1.nextInt(256));
				p1.setBackground(c);
			}

		});
		addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Mouse dragged at " + arg0.getPoint());
			}

		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}