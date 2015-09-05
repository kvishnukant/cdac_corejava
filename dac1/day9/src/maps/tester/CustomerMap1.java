package maps.tester;

import java.util.HashMap;
import java.util.Scanner;

import maps.core.Customer;
import static javax.swing.JOptionPane.*;

public class CustomerMap1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// create empty map of suitable type
			HashMap<String, Customer> custs = new HashMap<>();
			// populate the map by taking user i/p --- i form of ready made i/p
			// dialog box
			String data = null;
			while ((data = showInputDialog("Enter Customer Details em pass amt day-mon-yr")) != null) {
				Scanner sc = new Scanner(data);
				String email = sc.next();
				System.out.println("Added "
						+ custs.put(email,
								new Customer(email, sc.next(), sc.nextDouble(),
										sc.next())));
			}
			System.out.println("Populated Map " + custs);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
