package sets;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class IntegerSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data={10,20,1,23,45,10,20,3456,123};
		//empty HS
		HashSet<Integer> hs=new HashSet<>();
		for (int i : data)
			System.out.println("Added "+hs.add(i));
		System.out.println("HS : "+hs);
		Iterator<Integer> itr=hs.iterator();
		System.out.println("HS via iterator");
		while(itr.hasNext())
			System.out.print(itr.next()+"  ");
		System.out.println();
		hs.add(21);
		hs.add(54);
		System.out.println("HS again "+hs);
		System.out.println("HS contains 10"+hs.contains(10));
		System.out.println("HS remove 3456 "+hs.remove(3456));
		//sort --- asc 
		TreeSet<Integer> ts1=new TreeSet<>(hs);
		System.out.println("Sorted TS asc "+ts1);
		//sort -- desc
		TreeSet<Integer> ts2=new TreeSet<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer arg0, Integer arg1) {
				// TODO Auto-generated method stub
				return arg1.compareTo(arg0);
			}
			
		});
		System.out.println("TS2 "+ts2);
		ts2.addAll(hs);
		System.out.println("TS2 sorted desc  "+ts2);
		
	}

}
