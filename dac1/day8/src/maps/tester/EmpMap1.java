package maps.tester;

import java.util.HashMap;
import java.util.Scanner;

import maps.core.Emp;

public class EmpMap1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// create empty map with suitable K & V type
		HashMap<Integer, Emp> emps = new HashMap<>();

		// populate it
		System.out.println("Added "+emps.put(101,
				new Emp(101, "abc", 12000, "1-12-2012")));
		System.out.println("Added "+emps.put(10,
				new Emp(10, "Abc", 2000, "1-12-2013")));
		System.out.println("Added "+emps.put(56,
				new Emp(56, "abc", 12000, "1-12-2012")));
		// chk for duplicates
		System.out.println("Added "+emps.put(101,
				new Emp(101, "abc123", 13000, "1-1-2011")));
		
		// display via toString
		System.out.println("HM via toString "+emps);
		//chk emp record -- i/p id
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		if (emps.containsKey(id))
			System.out.println(emps.get(id));
		else 
			System.out.println("emp not found....");
		if (sc != null)
			sc.close();

	}

}
