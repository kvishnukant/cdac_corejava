package tester;

import java.util.Scanner;
import org.*;

public class TestOrgScanner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// sc
		Scanner sc = new Scanner(System.in);
		// accept max no of emps to recruit
		System.out.println("Max no of emps to hire");
		Emp[] emps = new Emp[sc.nextInt()];
		boolean exit = false;
		int counter = 0;
		while (!exit) {
			System.out.println("Enter Your Option \nOptions : 1 : Hire Mgr\n"
					+ "Option 2 : Hire Worker\n"
					+ "Option 3 : Display Org Details\n"
					+ "Option 4 : Display Emp Details \n"
					+ "OPtion 5 : Fire Emp\n" + "Option 6 : Exit");
			switch (sc.nextInt()) {
			case 1: // hire mgr
				if (counter < emps.length) {
					System.out
							.println("Enter Mgr details -- id nm basic bonus");
					emps[counter++] = new Mgr(sc.nextInt(), sc.next(),
							sc.nextDouble(), sc.nextDouble());
				} else
					System.out.println("Recruitment over....");

				break;
			case 2: // hire worker
				if (counter < emps.length) {
					System.out
							.println("Enter Worker details -- id nm basic no rate");
					emps[counter++] = new Worker(sc.nextInt(), sc.next(),
							sc.nextDouble(), sc.nextInt(), sc.nextDouble());
				} else
					System.out.println("Recruitment over....");

				break;

			case 3: // disp org dtls -- info,net sal , bonus OR rate
				for (Emp e : emps) {
					if (e != null) {
						System.out.print(e + "Net sal " + e.computeNetSalary());
						if (e instanceof Mgr)
							System.out.println(" Bonus "
									+ ((Mgr) e).getPerfBonus());
						else
							System.out.println(" Rate "
									+ ((Worker) e).getRate());
					}
				}
				break;
			case 4: // display emp dtls ---
				System.out.println("Enter Emp ID ");
				int id = sc.nextInt();
				boolean found = false;
				for (Emp e : emps) {
					if (e != null)
						if (e.getId() == id) {
							System.out.println(e);
							found = true;
							break;
						}

				}
				if (!found)
					System.out.println("No Emp found with ID = " + id);
				break;
			case 5: // fire emp
				System.out.println("Enter Emp ID to fire");
				id = sc.nextInt();
				found = false;
				for (int i = 0; i < emps.length; i++) {
					if (emps[i] != null)
						if (emps[i].getId() == id) {
							emps[i] = null;
							found = true;
							break;
						}

				}
				if (!found)
					System.out.println("No Emp found for firing with ID = "
							+ id);
				break;
			case 6:
				exit = true;
				break;

			}
		}

		if (sc != null)
			sc.close();
	}

}
