package shared_resources_synched_methods;

public class DeptHandler extends Thread {
	private boolean exit;
	private Utils u;
	private Emp e;

	public DeptHandler(String nm, Utils u, Emp e) {
		// this --- new
		super(nm);// new
		this.u = u;
		this.e = e;
		start();// rdy
	}

	@Override
	public void run() {
		System.out.println(getName() + " strted ");
		try {
			while (!exit) {
				u.writeData(e);
				Thread.sleep(500);
			}
		} catch (Exception e) {
			System.out.println("err in " + getName() + "  " + e);
		}
		System.out.println(getName() + " over ");
	}

	public void quit() {
		exit = true;
	}

}
