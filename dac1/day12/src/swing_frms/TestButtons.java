package swing_frms;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestButtons extends JFrame {
	private JButton b1,b2,b3;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestButtons t1=new TestButtons("Layout Mgr + Event Handling");

	}
	public TestButtons(String title) {
		setTitle(title);
		setSize(400, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//create btns & add it to frm
		b1=new JButton("Red");
		b2=new JButton("Green");
		b3=new JButton("Blue");
		add(b1,BorderLayout.NORTH);
		add(b2,BorderLayout.SOUTH);
		add(b3);
		setVisible(true);
		
	}

}
