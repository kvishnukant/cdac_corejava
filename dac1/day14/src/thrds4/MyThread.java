//IS A -- Thread
package thrds4;

public class MyThread extends Thread {
	public MyThread(String nm) {
		super(nm);// new -- named thrd
		start();//rdy pool
	}

	@Override
	public void run() {
		System.out.println(getName() + "thrd started ");
		int i=0;
		try {
			while(true) {
				System.out.println(Thread.currentThread().getName()
						+ " exec count " + i++);
				Thread.sleep(500);
			}
		} catch (Exception e) {
			System.out.println("err in thrd " + getName() + " " + e);
		}
		System.out.println(getName() + "thrd over");
	}

}
