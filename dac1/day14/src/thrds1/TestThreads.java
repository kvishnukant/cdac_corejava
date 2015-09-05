//create 3 -- user thrds (child thrds ) & test concurrency
package thrds1;

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
			Thread.sleep(1000);
		}	
		System.out.println(t.getName()+"  over ");

	}

}
