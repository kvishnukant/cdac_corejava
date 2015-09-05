package shared_resources_synched_block;

import java.util.ArrayList;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// Utils cls inst
			Utils u1 = new Utils();
			// thrd names
			String[] names = { "t1", "t2", "t3" };
			// AL<Emp>
			ArrayList<Emp> emps = new ArrayList<>();
			emps.add(new Emp(101, "aa", "RnD", 22000));
			emps.add(new Emp(34, "bb", "HR", 20000));
			emps.add(new Emp(55, "cc", "Sales", 15000));
			// AL<Thread>
			ArrayList<DeptHandler> thrds = new ArrayList<>();
			// for ---
			for (int i = 0; i < emps.size(); i++)
				thrds.add(new DeptHandler(names[i], u1, emps.get(i)));
			//t1-   rdy --- 4 thrds
			System.out.println("main waiting for user's signal");
			System.in.read();
			System.out.println("stopping child thrds....");
			for (DeptHandler t : thrds)
				t.quit();
			
			System.out.println("ensuring no orphans...");
			for(Thread t : thrds)
				t.join();
			//close non-java resource
			u1.cleanUp();
			System.out.println("main over.....");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
