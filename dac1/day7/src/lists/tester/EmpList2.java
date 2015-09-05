package lists.tester;

import java.util.ArrayList;
import java.util.Scanner;

import lists.core.Emp;
import static javax.swing.JOptionPane.*;

public class EmpList2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// dyn init of array of emps
		Emp[] e = { new Emp(101, "abc", 2400, "23-12-2013"),
				new Emp(23, "abc1", 20000, "1-1-2013"),
				new Emp(56, "def", 40000, "20-3-2013") };
		// Create empty ArrayList of emps
		ArrayList<Emp> emps = new ArrayList<>();
		//populate AL using array data
		for(Emp e1 : e)//e1=e[0]....
			emps.add(e1);
		
		// display list contents
		System.out.println("emps via " + emps);
		System.out.println("emps via for-each");
		//for-each -- implicit iterator 
		for (Emp ee : emps) //ee=itr.next()
			System.out.println(ee);
		//Check if a particular emp record exists.
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Emp id");
		System.out.println(emps.contains(sc.nextInt())?"exists":"doesn't");

	}
}




