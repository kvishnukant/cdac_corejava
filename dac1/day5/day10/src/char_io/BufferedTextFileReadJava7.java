package char_io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class BufferedTextFileReadJava7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Enter file name");
		try (Scanner sc = new Scanner(System.in);
				BufferedReader br = new BufferedReader(
						new FileReader(sc.next()));) {
			String s = null;
			while ((s = br.readLine()) != null)
				System.out.println(s);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main over ");

	}

}
