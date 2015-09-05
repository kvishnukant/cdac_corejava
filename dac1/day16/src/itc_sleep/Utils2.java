package itc_sleep;

public class Utils2 {
	private Emp e;
	private boolean dataRdy;

	public synchronized void writeData(Emp ref) throws Exception {
		System.out.println("w entered --- " + Thread.currentThread().getName());
		while (dataRdy)
			Thread.sleep(15);
		// produce data
		e = ref;
		System.out.println("Write Data " + e);
		System.out.println("w exited --- " + Thread.currentThread().getName());
		dataRdy=true;
	}

	public synchronized Emp readData() throws Exception {
		System.out.println("r entered --- " + Thread.currentThread().getName());
		while(!dataRdy)
			Thread.sleep(15);
		// consume data
		System.out.println("Read  Data " + e);
	
		System.out.println("r exited --- " + Thread.currentThread().getName());
		dataRdy=false;
		return e;
	}

}
