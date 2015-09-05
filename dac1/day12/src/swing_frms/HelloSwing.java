package swing_frms;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloSwing extends JFrame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HelloSwing h1 = new HelloSwing("Testing Swing Appln");

	}

	public HelloSwing(String title) {
		// set up title bar
		super(title);
		// set size
		setSize(400, 200);// w & h
		//centering frame
		setLocationRelativeTo(null);
		// colouring scheme
		// getContentPane() -- rets Container asso with JFrame --- JPanel
		System.out.println("conatiner asso with JFrame  "+getContentPane());
		System.out.println("Invoker thrd "+Thread.currentThread().getName());
		getContentPane().setBackground(Color.CYAN);
		// create Label & add it to frm
		JLabel l1 = new JLabel("Hello Swing", new ImageIcon(
				"g:/images/ani_marv.gif"), JLabel.CENTER);
		l1.setFont(new Font("Verdana", Font.BOLD, 25));
		add(l1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	

	}

}
