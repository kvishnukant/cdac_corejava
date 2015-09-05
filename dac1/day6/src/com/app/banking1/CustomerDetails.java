package com.app.banking1;

import java.util.Scanner;

import cust_exc.InvalidInputException;

public class CustomerDetails {

	public static final int MAX_RETRIES = 2;
	private String email, password, address;

	public CustomerDetails(Scanner sc) throws Exception {
		String email = validateEmail(sc);
		String password = validatePassword(sc.next());
		this.email = email;
		this.password = password;
		this.address = sc.next();
	}

	@Override
	public String toString() {
		return "Registered Email=" + email + "current address=" + address;
	}

	public String validateEmail(Scanner sc) throws Exception {
		int counter = 0;
		String em = null;
		boolean exit=false;
		while (!exit) {
			System.out.println("inside while ..."+counter);
			try {
				System.out
						.println("Enter Customer Details -- email password adr");
				em = sc.next();
				if (em.length() < 5 || em.length() > 20 || !em.contains("@"))
					throw new InvalidInputException("Invalid email format");
				exit=true;
			} catch (Exception e) {
				sc.nextLine();
				counter++;
				if (counter > MAX_RETRIES) {
					System.out.println("Max retries over...");
					throw e;
				}
				System.out.println(e.getMessage() + " Pls retry ");
				

			}

		}
		return em;

	}

	public String validatePassword(String pass) throws Exception {
		if (pass.length() < 5 || pass.length() > 10 || !pass.contains("$"))
			throw new InvalidInputException("Invalid Password");
		return pass;

	}

}
