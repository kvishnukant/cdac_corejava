//create 3 -- user thrds (child thrds ) & test concurrency
package thrds5;

public class TestThreads {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		//display details of main thrd
		Thread t=Thread.currentThread();
		System.out.println("main details "+t);
		//start child thrds
		MyThread t1=new MyThread("one");
		MyThread t2=new MyThread("two");
		MyThread t3=new MyThread("three");
		for (int i = 0; i < 10; i++) {
			System.out.println(t.getName()
					+ " exec count " + i);
			Thread.sleep(100);
		}	
		System.out.println("waiting for child thrds to finish exec max for 5 secs");
		System.out.println(t1.isAlive()?"Alive":"Dead");
		t1.join(1000);
		t2.join(2000);
		t3.join(2000);
		System.out.println("Interrupting child thrds");
		t1.interrupt();
		t2.interrupt();
		t3.interrupt();
		System.out.println(t1.isAlive()?"Alive":"Dead");
		t1.join();
		t2.join();
		t3.join();
		System.out.println(t.getName()+"  over ");

	}

}
