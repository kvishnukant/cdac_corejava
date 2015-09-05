//remove by Object ref
package lists.tester;

import java.util.ArrayList;
import java.util.Scanner;

import cust_excs.EmpNotFoundException;

import lists.core.Emp;
import static javax.swing.JOptionPane.*;

public class EmpList6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// dyn init of array of emps
			Emp[] e = { new Emp(101, "abc", 2400, "23-12-2013"),
					new Emp(23, "abc1", 20000, "1-1-2013"),
					new Emp(56, "def", 40000, "20-3-2013") };
			// Create empty ArrayList of emps
			ArrayList<Emp> emps = new ArrayList<>();
			// populate AL using array data
			for (Emp e1 : e)
				// e1=e[0]....
				emps.add(e1);

			// display list contents
			System.out.println("emps via " + emps);
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter emp id to fire");
			Emp e1 = new Emp(sc.nextInt());
		    boolean removed=emps.remove(e1);
			if (!removed)
				throw new EmpNotFoundException("Emp with ID " + e1.getId()
						+ " Not found....");
			
			System.out.println("Updated List upon removal" + emps);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
