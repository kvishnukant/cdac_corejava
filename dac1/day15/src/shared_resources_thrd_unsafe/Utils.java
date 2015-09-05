package shared_resources_thrd_unsafe;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

public class Utils {
	private PrintWriter pw;
	private Random r1;

	public Utils() throws Exception {
		r1 = new Random();
		pw = new PrintWriter(new FileWriter("emps_info.txt"), true);
	}

	public  void writeData(Emp e) throws Exception {
		pw.print("{ " + e.getId());
		Thread.sleep(r1.nextInt(5) + 1);
		pw.print(" " + e.getName());
		Thread.sleep(r1.nextInt(5) + 1);
		pw.print(" " + e.getDeptId());
		Thread.sleep(r1.nextInt(5) + 1);
		pw.println(" " + e.getSalary() + " } ");

	}

	public void cleanUp() {
		if (pw != null)
			pw.close();
	}

}
