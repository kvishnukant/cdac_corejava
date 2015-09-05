package tester;

public class TestStrings1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s="hello";
		s=s.concat("hi");
		s += " hi again...";
		System.out.println(s);
		s.toUpperCase();
		System.out.println(s);

	}

}
