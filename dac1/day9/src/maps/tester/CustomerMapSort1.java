package maps.tester;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

import cust_exc.CustomerHandlingException;

import maps.core.Customer;

public class CustomerMapSort1 {

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
			/*
			 * Sort custs as per their email Ids (asc)
			 */
			TreeMap<String, Customer> tm = new TreeMap<>(custs);
			System.out.println("Sorted as per asc email " + tm);
			/*
			 * Sort custs as per their email Ids (desc)
			 */
			// using ano inner class syntax

			TreeMap<String, Customer> tm2 = new TreeMap<>(
					new Comparator<String>() {
						@Override
						public int compare(String s1, String s2) {
							System.out.println("in compare....");
							return s2.compareTo(s1);
						}
					});
			System.out.println("sorted custs as per desc email "+tm2);
			tm2.putAll(custs);
			System.out.println("sorted custs as per desc email again  "+tm2);

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}
}
