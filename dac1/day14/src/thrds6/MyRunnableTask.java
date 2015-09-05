//Represents runnable task -- to be attached with thrd
package thrds6;

public class MyRunnableTask implements Runnable {
	private Thread t;

	public MyRunnableTask(String nm) {
		// t--- doesn't exist
		t = new Thread(this, nm);// t -- new
		t.start();//t -- rdy
	}

	@Override
	public void run() {
		System.out.println(t.getName() + "thrd started ");
		int i = 0;
		boolean exit = false;
		while (!exit) {
			try {

				System.out.println(Thread.currentThread().getName()
						+ " exec count " + i++);
				Thread.sleep(500);

			} catch (Exception e) {
				System.out.println("err in thrd " + t.getName() + " " + e);
			}
		}
		System.out.println(t.getName() + "thrd over");
	}

	public Thread getT() {
		return t;
	}
	
}
