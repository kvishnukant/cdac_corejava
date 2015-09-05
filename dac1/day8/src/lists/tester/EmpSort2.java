/*
 * Sort emps by ID --- asc order
 */
package lists.tester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import cust_comparator.EmpSalComparator;

import lists.core.Emp;
import static javax.swing.JOptionPane.*;

public class EmpSort2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// dyn init of array of emps
		Emp[] e = { new Emp(101, "abc", 2400, "23-12-2013"),
				new Emp(23, "abc1", 20000, "1-1-2013"),
				new Emp(56, "def", 40000, "20-3-2013") };
		// Arrays.sort(e);
		// Create empty ArrayList of emps
		ArrayList<Emp> emps = new ArrayList<>();
		// populate AL using array data
		for (Emp e1 : e)
			// e1=e[0]....
			emps.add(e1);
		System.out.println("orig list " + emps);
		Collections.sort(emps);

		// display list contents
		System.out.println("sorted  by N.O." + emps);
		Collections.sort(emps, new EmpSalComparator());
		System.out.println("sorted  by C.O." + emps);
		
		

	}
}
