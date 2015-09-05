package clnts;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashSet;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NumberClient extends JFrame implements ActionListener {
	private JPanel p1, p2;
	private JLabel l1, l2, l3;
	private JTextField t1, t2, t3;
	private JButton b1;
	private Socket s1;
	private ObjectOutputStream out;
	private DataInputStream in;

	public static final int SERVER_PORT = 5000;
	public static final String SERVER_IP = "127.0.0.1";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			JFrame f1 = new NumberClient("GUI+Net");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public NumberClient(String title) throws Exception {
		initGUI(title);
		initBL();
	}

	private void initGUI(String mesg) {
		setTitle(mesg);
		setSize(400, 200);
		// Font f1=new Font("Serif", Font.BOLD, 20);
		l1 = new JLabel("Enter Nums");
		l2 = new JLabel("Enter Command");
		l3 = new JLabel("Result");
		t1 = new JTextField(40);
		t2 = new JTextField(40);
		t3 = new JTextField(40);
		t3.setEditable(false);
		b1 = new JButton("Send");
		b1.addActionListener(this);
		p1 = new JPanel(new GridLayout(3, 2, 20, 30));
		p2 = new JPanel();
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p1.add(l3);
		p1.add(t3);
		p2.add(b1);
		add(p1);
		add(p2, BorderLayout.SOUTH);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				if (s1 != null)
					try {
						s1.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				System.exit(0);
			}

		});
		setVisible(true);

	}

	private void initBL() throws Exception {
		s1 = new Socket(SERVER_IP, SERVER_PORT);
		setTitle("conn to srvr");
		out = new ObjectOutputStream(s1.getOutputStream());
		out.flush();
		// in
		in = new DataInputStream(new BufferedInputStream(s1.getInputStream()));
		setTitle("clnt : attached data strms");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// empty HS
		t3.setText("");
		HashSet<Integer> hs = new HashSet<>();
		try (Scanner sc = new Scanner(t1.getText())) {
			// populate the same from t1's data
			while (sc.hasNextInt())
				hs.add(sc.nextInt());
			System.out.println("HS " + hs);
			// read cmd & upload the same to srvr
			out.writeObject(hs);
			out.writeUTF(t2.getText());
			out.flush();
			// await resp --- place it on t3 -- EDT blocked till resp is rcvd
			t3.setText("Res " + in.readDouble());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
