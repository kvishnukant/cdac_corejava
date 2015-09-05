package maps.tester;

import java.util.HashMap;
import java.util.Scanner;

import cust_exc.CustomerHandlingException;

import maps.core.Customer;

public class CustomerMap2 {

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
			// acsept email --- exc or details
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter email to check details");
			String em = sc.next();
			sc.nextLine();

			if (custs.containsKey(em))
				System.out.println(custs.get(em));
			else
				throw new CustomerHandlingException("Customer ID not found....");
			// update ---i/p email & amt
			System.out.println("Enter email & sub amt for upgrade");
			em = sc.next();
			
			if (custs.containsKey(em)) {
				double amt = sc.nextDouble();
				Customer c = custs.get(em);
				c.setSubscriptionAmt(c.getSubscriptionAmt() + amt);
			} else
				throw new CustomerHandlingException(
						"Customer ID not found : can't upgrade....");
			System.out.println("Updated Map "+custs);
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}
}
