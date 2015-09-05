package com.app.core;

import static cust_utils.IOUtils.*;
import static javax.swing.JOptionPane.*;
import java.awt.GridLayout;
import java.util.Collection;
import java.util.Properties;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ExpertLoginForm extends JFrame implements ActionListener {
	private HashMap<String, String> users;
	private HashMap<Integer, CustomerComplaint> complaints;
	private JTextField t1;
	private JPasswordField t2;
	private JLabel l1, l2;
	private JButton login;

	public static void main(String[] args) {
		new ExpertLoginForm("GUI_Coll_IO");
	}

	public ExpertLoginForm(String title) {
		initGUIComps(title);
		initBL();
	}

	private void initGUIComps(String title) {
		setTitle(title);
		setSize(400, 200);
		setLocationRelativeTo(null);
		l1 = new JLabel("Enter Email");
		l2 = new JLabel("Enter Passowrd");
		t1 = new JTextField(30);
		t2 = new JPasswordField(30);
		login = new JButton("Login");
		login.addActionListener(this);
		layoutComps();
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				//save updated complaint map
				storeInfo(complaints);
				System.exit(0);
				
			}
			
		});
		setVisible(true);
	}

	private void layoutComps() {
		setLayout(new GridLayout(3, 2, 40, 30));
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(login);

	}

	private void initBL() {
		users = restoreExpertInfo();
		complaints = restoreInfo();

	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		String email = t1.getText();
		String pass = new String(t2.getPassword());
		// validate expert
		if (users.containsKey(email) && users.get(email).equalsIgnoreCase(pass)) {
			String platform = showInputDialog("Enter Expertise in Platform");
			// hm--- coll
			Collection<CustomerComplaint> coll = complaints.values();
			for (CustomerComplaint c : coll)
				if (c.getPlatform().equalsIgnoreCase(platform)
						&& c.getStatus().equalsIgnoreCase("pending")) {
					c.setStatus("serviced");
					System.out.println("serviced "+c);
				}

		}
		else
			showMessageDialog(this, "Invalid Login , Pls retry....");

	}

}
