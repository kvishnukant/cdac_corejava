package com.app.tester;

import java.util.Scanner;

import com.app.banking.Account;
import static javax.swing.JOptionPane.*;

public class TestAccountUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Account a1 = null;
		// sc
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		while (!exit) {
			try {
				System.out.println("Options : 1 : Create A/C \n"
						+ "2 : Display A/c Summary \n"
						+ "3 : Update Cust Details\n" + "4 : Exit");
				switch (sc.nextInt()) {
				case 1: // create a/c
					// pop up i/p dialog box
					String line = showInputDialog("Enter A/c Dtls type bal date day-mon-yr");
					if (line != null) {
						Scanner sc2 = new Scanner(line);
						a1 = new Account(sc2.next(), sc2.nextDouble(),
								sc2.next());
						line = showInputDialog("Enter Customer Details email pass adr");
						if (line != null) {
							sc2 = new Scanner(line);
							a1.setDetails(sc2.next(), sc2.next(), sc2.next());
							showMessageDialog(null,
									"A/C created & Cust details entered...");
						}

					}
					break;
				case 2: // display a/c summary
					System.out.println(a1);
					break;
				case 3: // update or fix cust details
					line = showInputDialog("Enter Customer Details email pass adr");
					if (line != null) {
						Scanner sc2 = new Scanner(line);
						a1.setDetails(sc2.next(), sc2.next(), sc2.next());
						showMessageDialog(null, "Cust details updated...");
					}
					break;

				case 4:
					exit = true;
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (sc != null)
			sc.close();

	}

}
