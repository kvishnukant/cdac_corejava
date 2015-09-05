package clnts;

import java.net.*;
import java.io.*;

public class SimpleClient {

	/**
	 * @param args
	 */
	public static final int SERVER_PORT = 5600;
	public static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {
		try (Socket s1 = new Socket(SERVER_IP, SERVER_PORT)) {
			System.out.println("clnt : Connected to "
					+ s1.getInetAddress().getHostName() + " using local port "
					+ s1.getLocalPort());
			// attach suitable data strms
			PrintWriter pw = new PrintWriter(s1.getOutputStream(),true);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					s1.getInputStream()));
			//send req
			String req="Hello, How r u Srvr?";
			pw.println(req);
			//await resp 
			System.out.println("Server sent : "+br.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
