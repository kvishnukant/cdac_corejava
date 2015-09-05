package swing_frms;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestButtons3 extends JFrame {
	private JButton b1,b2,b3;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestButtons3 t1=new TestButtons3("Layout Mgr + Event Handling");

	}
	public TestButtons3(String title) {
		setTitle(title);
		setSize(400, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
