package safe_colls;

public class TestSafeCollections {
	public static void main(String[] args) {
		final NameList nl = new NameList();
		nl.add("abc");
		class NameDropper extends Thread {
			public void run() {
				synchronized (nl) {
					String name = nl.removeFirst();
					System.out.println(name);
				}
			
			}
		}
		Thread t1 = new NameDropper();
		Thread t2 = new NameDropper();
		t1.start();
		t2.start();
	}
}