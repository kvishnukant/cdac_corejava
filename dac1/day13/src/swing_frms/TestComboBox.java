package swing_frms;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class TestComboBox extends JFrame implements ActionListener {
	JLabel pic;
//	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		// to get the event source
		if (e.getSource() instanceof JComboBox<?>) {
			JComboBox<?> b1 = (JComboBox<?>) e.getSource();
		//	JComboBox<String> b1 = (JComboBox<String>) e.getSource();
			String s1 = b1.getSelectedItem().toString();
			s1 = "g:/images/" + s1.trim().concat(".gif");
			pic.setIcon(new ImageIcon(s1));
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new TestComboBox("Testing Combo-boxes");

	}

	public TestComboBox(String s) {
		super(s);
		setSize(400, 400);
		setLocationRelativeTo(null);
		// create the combo-box
		String[] lbls = { "earth", "neptune", "uranus", "jupiter", "pluto" };
		JComboBox<String> c1 = new JComboBox<>(lbls);
		
		c1.setEditable(true);
		c1.addActionListener(this);
		add(c1, BorderLayout.NORTH);
		String s1 = c1.getSelectedItem().toString();
		s1 = "g:/images/" + s1.trim().concat(".gif");
	//	System.out.println(s1);
		pic = new JLabel(new ImageIcon(s1));
		add(pic);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
