package swing_frms;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestButtons1 extends JFrame {
	private JButton b1,b2,b3;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestButtons1 t1=new TestButtons1("Layout Mgr + Event Handling");

	}
	public TestButtons1(String title) {
		setTitle(title);
		setSize(400, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));
		//create btns & add it to frm
		b1=new JButton("Red");
		b2=new JButton("Green");
		b3=new JButton("Blue");
		add(b1);
		add(b2);
		add(b3);
		setVisible(true);
		
	}

}
