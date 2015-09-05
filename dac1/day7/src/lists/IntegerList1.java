package lists;

import java.util.ArrayList;

public class IntegerList1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int[] ---dyn init array
		int[] data = { 10, 20, 1000, 10, 25, 1000, 13 };
		// create empty AL --- def constr --- init capa =10
		ArrayList<Integer> l1 = new ArrayList<>();
		// populate it using array data
		for (int i : data)
			// NO CONVERSION
			l1.add(i);// int--->Integer auto-boxing
		System.out.println("l1 "+l1);
		//addAll
		ArrayList<Integer> l2=new ArrayList<>();
		l2.addAll(l1);
		l1.addAll(4, l2);
		
		System.out.println(l2);
		System.out.println(l1);
		System.out.println(l1.indexOf(1000)+" "+l1.lastIndexOf(1000));
		System.out.println("removed elem "+l1.remove(10));
		System.out.println("replaced elem "+l1.set(0, 2345));
		
		
	}

}
