package test_synchro;

public class Utils {
	synchronized void test()
	{
		System.out.println("entered test "+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("exited test "+Thread.currentThread().getName());
	}
	synchronized void testMe()
	{
		System.out.println("entered testMe "+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("exited testMe "+Thread.currentThread().getName());
	}
	 void testMeAgain()
	{
		System.out.println("entered testMeagain "+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("exited testMeagain "+Thread.currentThread().getName());
	}

}
