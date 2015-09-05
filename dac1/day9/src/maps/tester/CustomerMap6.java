//understand API for Collection view of Map
package maps.tester;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import cust_exc.CustomerHandlingException;

import maps.core.Customer;

public class CustomerMap6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// create empty map of suitable type
			HashMap<String, Customer> custs = new HashMap<>();
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
			// to extract Key from map
			Set<String> keys = custs.keySet();
			// disp all keys
			for (String s : keys)
				System.out.print(s + " ");
			System.out.println();
			// to extract vals from map
			Collection<Customer> c = custs.values();
			// disp all vals
			for (Customer c1 : c)
				System.out.println(c1);
			// to extract keys & vals --- in 1 step
			// Map -- outer i/f
			// Map.Entry --- statically nested i/f
			// rets set of entries --- Map.Entry
			Set<Map.Entry<String, Customer>> entries = custs.entrySet();
			for (Map.Entry<String, Customer> e : entries) {
				System.out.println("Key " + e.getKey() + " value "
						+ e.getValue());
			}
			//modify the values
			for (Map.Entry<String, Customer> e : entries)  {
				if (e.getKey().equals("a@gmail"))
				e.setValue(new Customer("xxx","abc", 123, "1-12-2012"));
			}
			System.out.println("Map again "+custs);
			

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}
}
