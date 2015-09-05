package swing_frms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestButtons2 extends JFrame {
	private JButton b1, b2, b3;
	private JPanel p1, p2;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestButtons2 t1 = new TestButtons2("Layout Mgr + Event Handling");

	}

	public TestButtons2(String title) {
		setTitle(title);
		setSize(400, 200);
		setLocationRelativeTo(null);
	//	getContentPane().setBackground(Color.GRAY);
//		setLayout(new FlowLayout(FlowLayout.CENTER, 40, 10));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p1 = new JPanel();
		p1.setBackground(Color.YELLOW);
		p2 = new JPanel(new GridLayout(1, 3, 40, 10));
		p2.setBackground(Color.GRAY);
		// create btns & add it to panel
		b1 = new JButton("Red");
		b2 = new JButton("Green");
		b3 = new JButton("Blue");
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		add(p1);//center
		add(p2, BorderLayout.SOUTH);
		setVisible(true);

	}

}
