package swing_frms3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestMouseHandling extends JFrame {
	private JPanel p1;
	private Random r1;
	private Color c;
	private int x, y;

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
		p1 = new MyPanel();
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

			@Override
			public void mousePressed(MouseEvent arg0) {
				c = new Color(r1.nextInt(256), r1.nextInt(256), r1.nextInt(256));
				x = arg0.getX();
				y = arg0.getY();
				p1.repaint();

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

	// inner custom panel class
	class MyPanel extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			// clrs earlier graphics & fills bg & fg colors as chosen
			super.paintComponent(g);
			
			System.out.println("pC invoked by "
					+ Thread.currentThread().getName());
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(c);
			g2.fillOval(x, y, 30, 30);
		}
	}

}