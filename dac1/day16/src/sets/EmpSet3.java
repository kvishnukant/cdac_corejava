//tester for HS based upon comp PK
package sets;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class EmpSet3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashSet<Emp2> hs = new HashSet<>();
		System.out.println("Added " + hs.add(new Emp2(10, "abc", "HR", 12000)));
		System.out.println("Added " + hs.add(new Emp2(10, "bc", "RnD", 23000)));
		System.out.println("Added " + hs.add(new Emp2(70, "xbc", "HR", 1000)));
		System.out.println("Added " + hs.add(new Emp2(20, "AAA", "HR", 17000)));
		System.out.println("HS " + hs);

		System.out.println("Added " + hs.add(new Emp2(10, "AAA", "HR", 17000)));
		System.out.println("HS again " + hs);
		//sort emps as per sal --- w/o modifying Emp2 class
		TreeSet<Emp2> ts1=new TreeSet<>(new Comparator<Emp2>() {

			@Override
			public int compare(Emp2 arg0, Emp2 arg1) {
				// TODO Auto-generated method stub
				if (arg0.getSal() < arg1.getSal())
					return -1;
				if (arg0.getSal() > arg1.getSal())
					return 1;
				return 0;
				
			}
			
		});
		ts1.addAll(hs);
		System.out.println("Emps sorted as per sal "+ts1);
		//update sal of emp --- i/p id & dept id --- hs

	}

}
