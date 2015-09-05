package test_synchro;

public class Tester2 {
	static boolean exit;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		final Utils u1 = new Utils();
		final Utils u2 = new Utils();
		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				while (!exit)
					u1.test();

			}
		};
		Runnable r2 = new Runnable() {

			@Override
			public void run() {
				while (!exit)
					u2.testMe();

			}
		};
		Thread t1 = new Thread(r1, "t1");
		Thread t2 = new Thread(r2, "t2");
		t1.start();
		Thread.sleep(100);
		t2.start();
		System.out.println("Press Enter to STOP");
		System.in.read();
		System.out.println("Stopping child thrds....");
		exit = true;
		System.out.println("ensuring no orphans...");
		t1.join();
		t2.join();
		System.out.println("main over.....");

	}

}
