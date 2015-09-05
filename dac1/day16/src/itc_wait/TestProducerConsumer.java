package itc_wait;


public class TestProducerConsumer {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		Utils2 u=new Utils2();
		String[] nms={"Producer","Consumer"};
		//produce task ---thrd --strt
				Producer p1=new Producer(u);
				Thread t1=new Thread(p1,nms[0]);//new
				t1.start();//rdy
				Thread.sleep(10);	
		Consumer c1=new Consumer(u);
		//Thread(Runnable inst,String nm)
		Thread t2=new Thread(c1,nms[1]);//consumer thrd---new
		t2.start();//rdy pool
		System.out.println("Press enter to exit");
		System.in.read();
		p1.stop();
		c1.stop();
		t1.join();
		t2.join();
		System.out.println("Main over......");
		
		
		

	}

}