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

import cust_care.CustomerComplaint;

public class CustCareServerThreaded extends JFrame {
	public static final int SERVER_PORT = 5000;
	private ServerSocket ss;
	private Socket ds;
	private JTextArea jta;
	private HashMap<String, HashMap<Integer, CustomerComplaint>> complaints;
	private ArrayList<Thread> thrds;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CustCareServerThreaded s1 = new CustCareServerThreaded();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public CustCareServerThreaded() throws Exception {
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
				
			}

		});
		setVisible(true);
	}

	private void initNet() throws Exception {
		try {

			complaints = new HashMap<>();
			thrds=new ArrayList<>();

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
				thrds.add(new ClntHandler(ds));
			}

		} catch (Exception e) {
			if (e instanceof SocketException) {
				System.out.println("Waiting for existing clnts to terminate");
				for(Thread t : thrds)
					t.join();
				System.out.println("all clnt handling over....");
				
			}
			else
				e.printStackTrace();
		}
		System.exit(0);
	}

	// inner class for individual clnt handling
	class ClntHandler extends Thread {
		private Socket ds;
		private ObjectInputStream in;
		private ObjectOutputStream out;

		public ClntHandler(Socket ds) throws Exception {
			this.ds = ds;
			// attach data strms
			out = new ObjectOutputStream(ds.getOutputStream());
			in = new ObjectInputStream(ds.getInputStream());
			jta.append("attached data strms");
			start();
		}

		@SuppressWarnings("unchecked")
		@Override
		public void run() {
			jta.append(getName() + " strted \n");
			try {
				// read center code
				String code = in.readUTF();
				// read hm
				HashMap<Integer, CustomerComplaint> hm = (HashMap<Integer, CustomerComplaint>) in
						.readObject();
				synchronized (complaints) {
					complaints.put(code, hm);

				}
				out.writeUTF("complaints uploaded successfully");
				out.flush();

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
