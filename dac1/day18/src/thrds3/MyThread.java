//IS A -- Thread
package thrds3;

public class MyThread extends Thread {
	public MyThread(String nm) {
		super(nm);// new -- named thrd
		start();//rdy pool
	}

	@Override
	public void run() {
		System.out.println(getName() + "thrd started ");
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName()
						+ " exec count " + i);
				if (getName().equals("two"))
				{
					System.out.println(getName()+ ": Enter Data ");
					System.in.read();
				}
				Thread.sleep(500);
			}
		} catch (Exception e) {
			System.out.println("err in thrd " + getName() + " " + e);
		}
		System.out.println(getName() + "thrd over");
	}

}
