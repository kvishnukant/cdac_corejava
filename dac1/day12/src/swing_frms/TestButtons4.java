package swing_frms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestButtons4 extends JFrame implements ActionListener {
	private JButton b1, b2, b3;
	private JPanel p1, p2;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestButtons4 t1 = new TestButtons4("Layout Mgr + Event Handling");

	}

	public TestButtons4(String title) {
		setTitle(title);
		setSize(400, 200);
		setLocationRelativeTo(null);
		// getContentPane().setBackground(Color.GRAY);
		// setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p1 = new JPanel();
		p1.setBackground(Color.YELLOW);
		p2 = new JPanel(new GridLayout(1, 3, 40, 10));
		p2.setBackground(Color.GRAY);
		// create btns & add it to panel
		b1 = new JButton("Red");
		b1.addActionListener(this);
		b2 = new JButton("Green");
		b2.addActionListener(this);
		b3 = new JButton("Blue");
		b3.addActionListener(this);
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		add(p1);// center
		add(p2, BorderLayout.SOUTH);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * System.out.println("aP invoked by " +
		 * Thread.currentThread().getName()); System.out.println("Btn pressed "
		 * + e.getActionCommand());
		 */
		Color c = Color.RED;
		String cmd = e.getActionCommand();
		switch (cmd) {
		case "Green":
			c = Color.GREEN;

			break;
		case "Blue":
			c = Color.BLUE;
			break;

		}
		p1.setBackground(c);

	}
}
