package sets;

import java.util.HashSet;

public class EmpSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashSet<Emp> hs = new HashSet<>();
		System.out.println("Added " + hs.add(new Emp(101, "abc", "HR", 12000)));
		System.out.println("Added " + hs.add(new Emp(10, "bc", "RnD", 23000)));
		System.out.println("Added " + hs.add(new Emp(54, "xbc", "HR", 1000)));
		System.out.println("Added " + hs.add(new Emp(78, "AAA", "HR", 17000)));
		System.out.println("HS " + hs);

		System.out.println("Added " + hs.add(new Emp(78, "AAA", "HR", 17000)));
		System.out.println("HS again " + hs);

	}

}
