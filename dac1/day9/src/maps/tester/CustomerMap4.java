package maps.tester;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import cust_exc.CustomerHandlingException;

import maps.core.Customer;

public class CustomerMap4 {

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
			// display all keys from map -- for-each
			Set<String> keys = custs.keySet();
			System.out.println("Keys ---");
			for (String s : keys)
				System.out.print(s + "  ");
			// display all custs details from map --- for-each
			System.out.println("\n Values ");
			Collection<Customer> coll = custs.values();
			for (Customer c : coll)
				System.out.println(c);
			// display all key+val --- using single for-each
			Set<Map.Entry<String, Customer>> entries = custs.entrySet();
			for (Map.Entry<String, Customer> m : entries)
				System.out.println("Key " + m.getKey() + " Value "
						+ m.getValue());

			System.out.println("Populated Map " + custs);
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}
}
