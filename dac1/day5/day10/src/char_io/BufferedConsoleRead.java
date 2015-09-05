package char_io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferedConsoleRead {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in))) {
			String s = null;
			do {
				System.out.println("Enter data , 'stop' to terminate");
				s = br.readLine();
				System.out.println("Read Data " + s);
			} while (!s.equalsIgnoreCase("stop"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main over...");

	}

}
