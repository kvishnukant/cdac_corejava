package gui_thrds;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorChangerFrame extends JFrame implements ActionListener,
		Runnable {
	private JPanel p1, p2;
	private JButton strt, stop;
	private Color c;
	private Random r1;
	private boolean exit;
	private Thread t;// DNE

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ColorChangerFrame f1 = new ColorChangerFrame("Testing Thrds...");

	}

	public ColorChangerFrame(String title) {
		super(title);
		setSize(400, 200);
		p1 = new JPanel();
		p1.setBackground(Color.CYAN);
		add(p1);
		p2 = new JPanel(new GridLayout(1, 2, 40, 10));
		strt = new JButton("Start");
		strt.addActionListener(this);
		stop = new JButton("Stop");
		stop.addActionListener(this);
		p2.add(strt);
		p2.add(stop);
		add(p2, BorderLayout.SOUTH);
		r1 = new Random();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == strt) {
			if (t == null) {
				exit = false;
				t = new Thread(this);// new
				t.start();// rdy
			}
		} else
			exit = true;

	}

	private void changeColor() {
		System.out.println("in cC " + Thread.currentThread().getName());
		c = new Color(r1.nextInt(256), r1.nextInt(256), r1.nextInt(256));
		p1.setBackground(c);
	}

	@Override
	public void run() {
		System.out.println(t.getName() + " strted ");
		try {
			while (!exit) {
				changeColor();
				Thread.sleep(450);
			}
		} catch (Exception e) {
			System.out.println("err in aP " + e);
		}

		System.out.println(t.getName() + " over ");
		t = null;
	}

}
