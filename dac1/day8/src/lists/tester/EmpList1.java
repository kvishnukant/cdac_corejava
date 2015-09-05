package lists.tester;

import java.util.ArrayList;
import java.util.Scanner;

import lists.core.Emp;
import static javax.swing.JOptionPane.*;

public class EmpList1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create empty ArrayList of emps
		ArrayList<Emp> emps = new ArrayList<>();
		try {
			// Populate AL --- hire emp
			// open i/p dialog box & keep on hiring emps till 'cancel'
			String line = null;
			while ((line = showInputDialog("Enter Emp Details")) != null) {
				Scanner sc = new Scanner(line);
				emps.add(new Emp(sc.nextInt(), sc.next(), sc.nextDouble(), sc
						.next()));
			}
			//display list contents
			System.out.println("emps via "+emps);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
