//create 3 -- user thrds (child thrds ) & test concurrency
package thrds6;

public class TestThreads {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// display details of main thrd
		Thread t = Thread.currentThread();
		System.out.println("main details " + t);
		// start child thrds
		MyRunnableTask t1 = new MyRunnableTask("one");
		MyRunnableTask t2 = new MyRunnableTask("two");
		MyRunnableTask t3 = new MyRunnableTask("three");
		for (int i = 0; i < 10; i++) {
			System.out.println(t.getName() + " exec count " + i);
			Thread.sleep(100);
		}
		System.out
				.println("waiting for child thrds to finish exec max for 5 secs");
		System.out.println(t1.getT().isAlive() ? "Alive" : "Dead");
		t1.getT().join(1000);
		t2.getT().join(2000);
		t3.getT().join(2000);
		System.out.println("Interrupting child thrds");
		t1.getT().interrupt();
		t2.getT().interrupt();
		t3.getT().interrupt();
		System.out.println(t1.getT().isAlive() ? "Alive" : "Dead");
		t1.getT().join();
		t2.getT().join();
		t3.getT().join();
		System.out.println(t.getName() + "  over ");

	}

}
