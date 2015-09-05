package thrd_safe_jcomps;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SwingFrame extends JFrame implements ActionListener{
	private JPanel p1,p2;
	private JLabel l1,l2,l3;
	private JTextField t1,t2,t3;
	private JButton b1;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame f1=new SwingFrame("GUI+Net");

	}
	public SwingFrame(String title) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				initGUI();
				
			}
		});
		
	
	}
	private void initGUI()
	{
		System.out.println("Invoker of initGUI "+Thread.currentThread());
		setTitle("Thread Safe Handling");
		setSize(400, 200);
	//	Font f1=new Font("Serif", Font.BOLD, 20);
		l1=new JLabel("Enter Nums");
		l2=new JLabel("Enter Command");
		l3=new JLabel("Result");
		t1=new JTextField(40);
		t2=new JTextField(40);
		t3=new JTextField(40);
		t3.setEditable(false);
		b1=new JButton("Send");
		b1.addActionListener(this);
		p1=new JPanel(new GridLayout(3, 2, 20, 40));
		p2=new JPanel();
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p1.add(l3);
		p1.add(t3);
		p2.add(b1);
		add(p1);
		add(p2,BorderLayout.SOUTH);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		setVisible(true);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
