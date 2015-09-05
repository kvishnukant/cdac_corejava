package char_io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class BufferedTextFileRead {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = null;
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("Enter file name");
			br = new BufferedReader(new FileReader(sc.next()));
			// loop for data read
			String line = null;
			while ((line = br.readLine()) != null)
				System.out.println("Read data " + line);
			System.out.println("data read over....");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				br.close();
			if (sc != null)
				sc.close();
		}
		System.out.println("main over....");

	}

}
