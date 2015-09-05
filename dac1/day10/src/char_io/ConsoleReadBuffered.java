package char_io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleReadBuffered {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));) {
			String line = null;
			do {
				System.out.println("Enter data , 'stop' to terminate ");
				System.out.println(line = br.readLine());

			} while (!line.equalsIgnoreCase("stop"));

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
