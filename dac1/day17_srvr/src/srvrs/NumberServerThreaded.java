package srvrs;

import java.net.*;
import java.util.*;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class NumberServerThreaded extends JFrame {
	public static final int SERVER_PORT = 5000;
	private ServerSocket ss;
	private Socket ds;
	private JTextArea jta;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			NumberServerThreaded s1 = new NumberServerThreaded();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public NumberServerThreaded() throws Exception {
		initGUI();
		initNet();
	}

	private void initGUI() {
		setTitle("Number Server....");
		setSize(400, 400);
		setLocationRelativeTo(null);
		jta = new JTextArea(40, 80);
		jta.setFont(new Font("Serif", Font.BOLD, 25));
		JScrollPane jsp = new JScrollPane(jta);
		add(jsp);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				if (ss != null)
					try {
						ss.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				System.exit(0);
			}

		});
		setVisible(true);
	}

	private void initNet() throws Exception {
		try {

			// ss
			ss = new ServerSocket(SERVER_PORT, 1);
			while (true) {
				jta.append("waiting for clnt conn\n");
				// ds
				ds = ss.accept();
				jta.append("cn accepted from "
						+ ds.getInetAddress().getHostName() + " port "
						+ ds.getPort() + "\n");
				// create separate thrd for entire clnt handling
				new ClntHandler(ds);
			}
			
		} catch (Exception e) {
			if (e instanceof SocketException)
				System.out.println("Shutting down server...");
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private void acceptDataNSendResult(ObjectInputStream in,
			DataOutputStream out) throws Exception {
		// de-serialization ---
		HashSet<Integer> hs = (HashSet<Integer>) in.readObject();
		String cmd = in.readUTF();
		double result = 0;
		switch (cmd) {
		case "add":
			for (int i : hs)
				result += i;
			break;
		case "multiply":
			result = 1;
			for (int i : hs)
				result *= i;
			break;

		default:
			break;
		}
		// send resp to clnt
		out.writeDouble(result);
		jta.append("sent resp\n");

	}

	// inner class for individual clnt handling
	class ClntHandler extends Thread {
		private Socket ds;
		private ObjectInputStream in;
		private DataOutputStream out;

		public ClntHandler(Socket ds) throws Exception{
			this.ds = ds;
			// attach data strms
			out = new DataOutputStream(ds.getOutputStream());
			in = new ObjectInputStream(ds.getInputStream());
			jta.append("attached data strms");
			start();
		}

		@Override
		public void run() {
			jta.append(getName() + " strted \n");
			try {
				while (true)
					acceptDataNSendResult(in, out);
			} catch (Exception e) {
				if (e instanceof EOFException)
					jta.append("clnt terminated , closing clnt handler thrd....");
				else
					e.printStackTrace();
			} finally {
				if (ds != null)
					try {
						ds.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			}
			jta.append(getName() + " over \n");
		}
	}

}
