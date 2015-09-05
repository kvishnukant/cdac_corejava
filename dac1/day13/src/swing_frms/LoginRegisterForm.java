package swing_frms;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginRegisterForm extends JFrame implements ActionListener {
	private HashMap<String, User> users;
	private JTextField t1;
	private JPasswordField t2;
	private JLabel l1, l2;
	private JButton login, register;
	private RegisterDialog regDialog;

	public static void main(String[] args) {
		new LoginRegisterForm("GUI+Coll");
	}

	public LoginRegisterForm(String title) {
		initGUIComps(title);
		initColl();
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
		register = new JButton("SignUp");
		register.addActionListener(this);
		layoutComps();
		regDialog = new RegisterDialog();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void layoutComps() {
		setLayout(new GridLayout(3, 2, 40, 30));
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(login);
		add(register);

	}

	private void initColl() {
		users = new HashMap<String, User>();
		User[] u = { new User("aa", "a123", "prefs1"),
				new User("bb", "b123", "prefs2"),
				new User("cc", "c123", "prefs3") };
		for (User u1 : u)
			users.put(u1.getEmail(), u1);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == login) {
			StringBuilder sb = new StringBuilder();
			String email = t1.getText();
			String pass = new String(t2.getPassword());
			if (users.containsKey(email)) {
				User u = users.get(email);
				if (pass.equals(u.getPassword()))
					sb.append("Hello  " + u.getEmail() + ",  Ur prefs are "
							+ u.getPrefs());
				else
					sb.append("Sorry !!! Invalid Password. Pls Retry");
			} else
				sb.append("New User , Pls register....");
			JOptionPane.showMessageDialog(this, sb);
		} else
			regDialog.setVisible(true);

	}

	// inner class for Custom Dialog
	class RegisterDialog extends JDialog {
		private JTextField t1, t3;
		private JPasswordField t2;
		private JLabel l1, l2, l3;
		private JButton add, cancel;

		RegisterDialog() {
			// public JDialog(Frame owner, String title,boolean modal)
			super(LoginRegisterForm.this, "Register New User", true);
			setSize(400, 200);
			initComps();
		}

		private void initComps() {
			l1 = new JLabel("User Email");
			l2 = new JLabel("Enter Password");
			l3 = new JLabel("Enter Prefs");
			t1 = new JTextField(30);
			t2 = new JPasswordField(30);
			t3 = new JTextField(30);
			add = new JButton("Add User");
			add.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
				
					String email = t1.getText();
					if (users.containsKey(email)) {
						JOptionPane.showMessageDialog(RegisterDialog.this,"Email ID alrdy exists, Please Retry sign-up !!!!");
				
					} else {
						users.put(email,
								new User(email, new String(t2.getPassword()),
										t3.getText()));
						JOptionPane.showMessageDialog(RegisterDialog.this,"User registered Successfully");
						setVisible(false);
					}
					clearFields();

				}
			});
			cancel = new JButton("Cancel");
			cancel.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {

					setVisible(false);
					clearFields();
				}
			});
			// lay out components
			setLayout(new GridLayout(4, 2, 40, 20));
			add(l1);
			add(t1);
			add(l2);
			add(t2);
			add(l3);
			add(t3);
			add(add);
			add(cancel);

		}
		private void clearFields()
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
		}
	}

}
