package srvrs;

import java.net.*;
import java.util.Date;
import java.io.*;

public class SimpleServer {
	public static final int SERVER_PORT = 5600;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Waiting for clnt conn.");
		try (ServerSocket ss = new ServerSocket(SERVER_PORT, 1);
				Socket ds1 = ss.accept();) {
			System.out.println("accepted cn from "
					+ ds1.getInetAddress().getHostName() + " Clnt port "
					+ ds1.getPort());
			// attach suitable strms
			PrintWriter pw = new PrintWriter(ds1.getOutputStream(),true);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					ds1.getInputStream()));
			// read req
			System.out.println("Clnt sent : " + br.readLine());
			String resp = "Bye for now... @ " + new Date();
			pw.println(resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
