package itc_wait_notify;

public class Utils2 {
	private Emp e;
	private boolean dataRdy;

	public  void writeData(Emp ref) throws Exception {
		System.out.println("w entered --- " + Thread.currentThread().getName());
		while (dataRdy)
			wait();
		// produce data
		e = ref;
		System.out.println("Write Data " + e);
		System.out.println("w exited --- " + Thread.currentThread().getName());
		dataRdy = true;
		notify();
	}

	public  Emp readData() throws Exception {
		System.out.println("r entered --- " + Thread.currentThread().getName());
		while (!dataRdy)
			wait();
		// consume data
		System.out.println("Read  Data " + e);

		System.out.println("r exited --- " + Thread.currentThread().getName());
		dataRdy = false;
		notify();
		return e;
	}

}
