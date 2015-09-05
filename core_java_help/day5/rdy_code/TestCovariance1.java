package tester;

public class TestCovariance1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Emp m1 = new Mgr();
	}
}
class Emp {

	Emp getBuddy() {
		System.out.println("in super");
		return new Emp();
	}
}
class Mgr extends Emp {

	@Override
	Mgr getBuddy() {
		System.out.println("in sub");
		return new Mgr();
	}

}