package char_io;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class CreateFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter path along with file name to create");
			String path = sc.next();
			File f1 = new File(path);
			if (f1.exists())
				System.out.println("File alrdy exists....");
			else {
				System.out.println(f1.createNewFile() ? "Created"
						: "Failed creation");
				System.out.println("Abs path " + f1.getAbsolutePath());
				System.out.println("File size in bytes " + f1.length());
				System.out.println("Last Modified on"
						+ new Date(f1.lastModified()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
