package cust_care;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.app.core1.CustomerComplaint;

public class CustomerCareFrame extends JFrame implements ActionListener {
	// labels
	private JLabel[] labels;
	private Box[] hBoxes;

	private String[] names = { "Enter Email", "Enter Password",
			"Choose Address", "Platform", "Technology", "Browser",
			"Complaint Desc", "Log Complaint" };
	private String[] cities = { "Pune", "Mumbai", "Chennai" };
	private JTextField email;
	private JPasswordField pass;
	private JComboBox<String> address;
	private String[] platformNames = { "Win32", "Win64", "Mac", "Solaris" };
	private JRadioButton[] platform;
	private String[] technoNames = { "Java SE", "Java EE", ".NET", "XML",
			"RDBMS" };
	private JCheckBox[] techno;
	private String[] browserNames = { "Chrome", "FireFox", "IE" };
	private JList<String> browsers;
	private JTextArea desc;
	private JButton logComplaint;
	private ButtonGroup bg;
	private HashMap<Integer, CustomerComplaint> complaints;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CustomerCareFrame f1 = new CustomerCareFrame("Testing Swing GUI");

	}

	public CustomerCareFrame(String mesg) {
		initGUIComps(mesg);
		initBL();
	}

	private void initGUIComps(String mesg) {
		setTitle(mesg);
		setSize(500, 600);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(7, 1, 10, 30));
		getContentPane().setBackground(Color.CYAN);
		Font f1 = new Font("Serif", Font.BOLD, 20);
		// create labels
		labels = new JLabel[7];
		hBoxes = new Box[labels.length];
		for (int i = 0; i < 7; i++) {
			labels[i] = new JLabel(names[i]);
			labels[i].setFont(f1);
			hBoxes[i] = Box.createHorizontalBox();
		}
		email = new JTextField(30);
		email.setFont(f1);
		hBoxes[0].add(Box.createHorizontalGlue());
		hBoxes[0].add(labels[0]);
		hBoxes[0].add(email);
		hBoxes[0].add(Box.createHorizontalGlue());

		pass = new JPasswordField(30);
		pass.setFont(f1);
		hBoxes[0].add(labels[1]);
		hBoxes[0].add(pass);
		Box.createVerticalStrut(40);
		Vector<String> addrList = new Vector<>();
		for (int i = 0; i < cities.length; i++)
			addrList.add(cities[i]);
		address = new JComboBox<>(addrList);
		bg = new ButtonGroup();
		hBoxes[1].add(Box.createHorizontalGlue());
		// create RBs
		hBoxes[1].add(Box.createHorizontalStrut(20));
		hBoxes[1].add(labels[2]);
		hBoxes[1].add(Box.createHorizontalGlue());
		hBoxes[1].add(address);
		// 2nd row
		hBoxes[2].add(Box.createHorizontalStrut(20));
		hBoxes[2].add(labels[3]);
		hBoxes[2].add(Box.createHorizontalGlue());
		platform = new JRadioButton[platformNames.length];
		for (int i = 0; i < platformNames.length; i++) {
			platform[i] = new JRadioButton(platformNames[i]);
			platform[i].setFont(f1);
			bg.add(platform[i]);
			hBoxes[2].add(platform[i]);
			hBoxes[2].add(Box.createHorizontalGlue());
		}

		hBoxes[2].add(Box.createHorizontalGlue());
		// 3rd row
		hBoxes[3].add(Box.createHorizontalStrut(20));
		hBoxes[3].add(labels[4]);

		// for techono chkboxes
		techno = new JCheckBox[technoNames.length];
		hBoxes[3].add(Box.createHorizontalStrut(20));
		for (int i = 0; i < technoNames.length; i++) {
			techno[i] = new JCheckBox(technoNames[i]);
			techno[i].setFont(f1);
			hBoxes[3].add(techno[i]);
			hBoxes[3].add(Box.createHorizontalGlue());
		}
		hBoxes[3].add(Box.createHorizontalStrut(20));
		// 4th row

		hBoxes[4].add(Box.createHorizontalStrut(40));
		hBoxes[4].add(labels[5]);
		hBoxes[4].add(Box.createHorizontalGlue());
		browsers = new JList<>(browserNames);
		browsers.setFont(f1);
		JScrollPane jsp = new JScrollPane(browsers);
		hBoxes[4].add(jsp);
		hBoxes[4].add(Box.createHorizontalStrut(40));
		// 5th row
		hBoxes[5].add(Box.createHorizontalGlue());
		hBoxes[5].add(labels[6]);
		// jta -- scrollable
		hBoxes[5].add(Box.createHorizontalStrut(40));
		desc = new JTextArea(10, 50);
		desc.setFont(f1);
		JScrollPane jsp2 = new JScrollPane(desc);
		hBoxes[5].add(jsp2);
		hBoxes[5].add(Box.createHorizontalStrut(40));

		// 6th row
		hBoxes[6].add(Box.createHorizontalGlue());

		logComplaint = new JButton(names[names.length - 1]);
		// attach AL
		logComplaint.addActionListener(this);
		logComplaint.setFont(f1);
		hBoxes[6].add(logComplaint);
		hBoxes[6].add(Box.createHorizontalGlue());
		for (int i = 0; i < hBoxes.length; i++)
			add(hBoxes[i]);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("finally --- "+complaints);
				System.exit(0);
			}
			
		});
		setVisible(true);

	}

	private void initBL() {
		complaints = new HashMap<>();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == logComplaint)
			registerComplaint();

	}

	private void registerComplaint() {

		String em = email.getText();
		String pass1 = new String(pass.getPassword());
		String adr = address.getSelectedItem().toString();
		String plf = bg.getSelection().getActionCommand();
		String[] techs = new String[5];
		int counter = 0;
		for (JCheckBox c : techno)
			if (c.isSelected())
				techs[counter++] = c.getName();
		String brwser = browsers.getSelectedValue();
		String desc1 = desc.getText();
		CustomerComplaint c1 = new CustomerComplaint(em, pass1, adr, plf,
				brwser, desc1, techs);
		complaints.put(c1.getComplaintId(), c1);
		System.out.println("populated map "+complaints);

	}

}
