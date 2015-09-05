package srvrs;

import java.net.*;
import java.util.*;
import java.io.*;

public class NumberServer {
	public static final int SERVER_PORT = 5000;
	private ServerSocket ss;
	private Socket ds;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			NumberServer s1 = new NumberServer();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public NumberServer() throws Exception {
		initNet();
	}

	private void initNet() throws Exception {
		try {
			System.out.println("waiting for clnt conn");
			// ss
			ss = new ServerSocket(SERVER_PORT, 1);
			// ds
			ds = ss.accept();
			System.out.println("cn accepted from "
					+ ds.getInetAddress().getHostName() + " port "
					+ ds.getPort());
			// out
			DataOutputStream out = new DataOutputStream(ds.getOutputStream());
			// in
			ObjectInputStream in = new ObjectInputStream(ds.getInputStream());
			System.out.println("srvr : attached data strms");
			while (true)
				acceptDataNSendResult(in, out);
		} catch (Exception e) {
			if (e instanceof EOFException)
				System.out.println("clnt terminated, closing server....");
			else
				e.printStackTrace();
		} finally {
			if (ds != null)
				ds.close();
			if (ss != null)
				ss.close();
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
		System.out.println("sent resp");

	}

}
