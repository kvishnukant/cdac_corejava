package com.app.tester1;

import java.util.Scanner;

import com.app.banking1.*;

public class TestAccountUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// sc
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		Account a1 = null;
		while (!exit) {
			try {
				System.out.println("Enter Option : \n 1: Create Account"
						+ "\n 2 : Display A/c Summary \n"
						+ "\n 3 : Update Cust Details \n" + "4 : Exit \n");
				switch (sc.nextInt()) {
				case 1: // create a/c
					// accept a/c details
					// accpet cust dtls

					System.out.println("Enter A/C details type bal date");
					a1 = new Account(sc.next(), sc.nextDouble(), sc.next());
					
					a1.setDetails(sc);

					break;
				case 2: // display a/c summary
					if (a1 != null)
						System.out.println(a1);
					break;
				case 3:// update customer details
					if (a1 != null) {
						System.out
								.println("Enter Customer Details -- email password adr");
						a1.setDetails(sc);
					}
					break;

				case 4:
					exit = true;
					break;

				}
				// display a/c summary
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}

	}

}
