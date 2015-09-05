package test_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestDate2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// SDF
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Join Date -- day-mon-yr");
			Date joinDate = sdf.parse(sc.next());
			// display date
			System.out.println("via Date's toStirng" + joinDate);
			System.out.println("via sdf's format " + sdf.format(joinDate));
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("over...");

	}

}
