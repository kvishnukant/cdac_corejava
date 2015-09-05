package swing_frms;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestMouseHandling extends JFrame {
	private JPanel p1;

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
		// attach/register mouse listener & mouse motion listener to the current
		// frm
		MyListener m1=new MyListener(p1);
		this.addMouseListener(m1);
		addMouseMotionListener(m1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}

class MyListener implements MouseListener, MouseMotionListener {
	// inst vars
	private Random r1;
	private Color c;
	private JPanel p1;

	public MyListener(JPanel p1) {

		this.p1 = p1;
		// r1
		r1 = new Random();
		c = Color.WHITE;
		System.out.println("in constr of Listener "
				+ Thread.currentThread().getName());

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// display mouse co-ords --- console
		System.out.println("in mouse dragged (" + arg0.getX() + ","
				+ arg0.getY() + ")");

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// change BG clr of panel to randon color
		c = new Color(r1.nextInt(256), r1.nextInt(256), r1.nextInt(256));
		p1.setBackground(c);

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		c = new Color(r1.nextInt(256), r1.nextInt(256), r1.nextInt(256));
		p1.setBackground(c);

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// display mouse co-ords --- console
		System.out.println("in mouse pressed (" + arg0.getX() + ","
				+ arg0.getY() + ")");

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
