//sort custs as per subscription amount
package maps.tester;

import java.util.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

import cust_comp.CustomerDescEmailComparator;
import cust_comp.CustomerSubAmtComparator;
import cust_exc.CustomerHandlingException;

import maps.core.Customer;

public class CustomerMapSort3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// create empty map of suitable type
			HashMap<String, Customer> custs = new HashMap<>();
			// populate the map by taking user i/p --- i form of ready made i/p
			// dialog box
			System.out.println("Added "
					+ custs.put("a@gmail", new Customer("a@gmail", "a123", 500,
							"1-12-2012")));
			System.out.println("Added "
					+ custs.put("A@gmail", new Customer("A@gmail", "x123", 600,
							"21-12-2013")));
			System.out.println("Added "
					+ custs.put("xbc@gmail", new Customer("xbc@gmail", "Y123",
							1500, "11-1-2011")));
			System.out.println("Added "
					+ custs.put("xbc@gmail", new Customer("xbc@gmail", "XY123",
							1700, "11-11-2011")));

			System.out.println("Populated Map " + custs);
			// sort custs as per sub amt
			//get collection view of a map
			Collection<Customer> coll=custs.values();
			Vector<Customer> v1=new Vector<>(coll);
			Collections.sort(v1, new CustomerSubAmtComparator());
			System.out.println("Sorted custs as per sub amt "+v1);
			System.out.println("Map contents "+custs);
		
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println(e.getMessage());
		}

	}
}
