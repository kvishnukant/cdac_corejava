package swing_frms;

import java.awt.GridLayout;
import java.util.Properties;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LoginForm extends JFrame implements ActionListener{
	private HashMap<String,User> users;
	private JTextField t1;
	private JPasswordField t2;
	private JLabel l1,l2;
	private JButton login,register;
	
	public static void main(String[] args)
	{
		new LoginForm("GUI+Coll");
	}
	public LoginForm(String title) {
		initGUIComps(title);
		initColl();
	}
	private void initGUIComps(String title)
	{
		setTitle(title);
		setSize(400,200);
		setLocationRelativeTo(null);
		l1=new JLabel("Enter Email");
		l2=new JLabel("Enter Passowrd");
		t1=new JTextField(30);
		t2=new JPasswordField(30);
		login=new JButton("Login");
		login.addActionListener(this);
		register=new JButton("SignUp");
		register.addActionListener(this);
		register.setEnabled(false);
		layoutComps();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	private void layoutComps()
	{
		setLayout(new GridLayout(3,2,40, 30));
		add(l1);add(t1);
		add(l2);add(t2);
		add(login);add(register);
		
		
	}
	private void initColl()
	{
		users=new HashMap<String,User>();
		User[] u={new User("aa","a123", "prefs1"),new User("bb","b123", "prefs2"),new User("cc","c123", "prefs3")};
		for(User u1 : u)
			users.put(u1.getEmail(),u1);
		

				
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		StringBuilder sb=new StringBuilder();
		String email=t1.getText();
		String pass=new String(t2.getPassword());
		if (users.containsKey(email)) {
			User u=users.get(email);
			if (pass.equals(u.getPassword()))
				sb.append("Hello, "+u.getEmail()+" Ur prefs are "+u.getPrefs());
			else
				sb.append("Sorry !!! Invalid Password. Pls Retry");
		}
		else
			sb.append("New User , Pls register....");
		JOptionPane.showMessageDialog(this,sb);
				
			
				
				
		
		
	}
	
}
