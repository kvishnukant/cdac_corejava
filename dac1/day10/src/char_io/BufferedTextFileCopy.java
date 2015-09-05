package char_io;

import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class BufferedTextFileCopy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// prompt for file names
		System.out.println("Enter src file & dest file names");
		try (Scanner sc = new Scanner(System.in);
				BufferedReader br = new BufferedReader(
						new FileReader(sc.next()));
				// pw -- buffered char oriented , appendable,auto-flushable upon
				// new line
				// o/p stream connected to file device.
				PrintWriter pw = new PrintWriter(
						new FileWriter(sc.next(), true), true);) {
			String line = null;
			while ((line = br.readLine()) != null)
				pw.println(line);
			System.out.println("data copy over...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main over...");

	}

}
