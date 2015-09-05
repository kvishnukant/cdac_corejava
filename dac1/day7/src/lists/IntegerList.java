package lists;

import java.util.ArrayList;

public class IntegerList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int[] ---dyn init array
		int[] data={10,20,1000,10,25,1000,13};
		//create empty AL --- def constr --- init capa =10
		ArrayList<Integer> l1=new ArrayList<>();
		//populate it using array data
		for(int i : data)//NO CONVERSION
			l1.add(i);//int--->Integer auto-boxing
		//chk growability
		for(int i=0;i<20;i++)
			l1.add(i);
		//chk power of generics
//		l1.add(123.45);
		//get an elem(ref) from list
		System.out.println(l1.get(0)+"  "+l1.get(l1.size()-1));
		//display AL contents using toString
		System.out.println("AL l1 conts "+l1);
		//check size
		System.out.println("Size ="+l1.size() +" empty "+l1.isEmpty());
		//searching  for a particular elem
		System.out.println(l1.contains(1000)?"Exists":"Doesn't Exist");
		l1.add(5,2345);
		l1.remove(10);
		System.out.println("l1 again "+l1);
		System.out.println("orig val "+l1.set(0, 12345));
		System.out.println("l1 again "+l1);
	}

}




