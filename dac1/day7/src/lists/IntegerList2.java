package lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class IntegerList2 {

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
		System.out.println("l1 via toStirng :"+l1);
		//display all elems via Iterator
		System.out.println("l1 via Iterator ");
		Iterator<Integer> itr=l1.iterator();
		itr.next();
		itr.remove();
		// ILS exc itr.remove();
		
		//un-comment next line to chk IllegalStateExc
	//	itr.remove();
//		l1.remove(0);
		l1.set(0,1234);//no errs --- no structrual modifications to the list
		while(itr.hasNext())
			System.out.print(itr.next()+"  ");
		//un-comment to understand NOSuchEelemExc
	//	System.out.println(itr.next());
		
		//remove all elems > 30 --- itearator 
		itr=l1.iterator();
		while(itr.hasNext()) {
			if (itr.next() > 30)
				itr.remove();
		}
		l1.add(123);
		itr=l1.iterator();
		while(itr.hasNext())
			System.out.print(itr.next()+"  ");
	
		System.out.println("l1 after remove "+l1);
		//display elems of list in reverse manner
		System.out.println("\n l1 contents in reverse manner ");
		ListIterator<Integer> litr=l1.listIterator(l1.size());
		while(litr.hasPrevious())
			System.out.print(litr.previous()+" ");
		//Sorting via ready made API --- java.util.Collections 
		//Utility class (helper class) --- sort,display,shuffle,synchronization
		//Collection Vs Collections Vs Collection Frmwork
		//public static void sort(List<T> l1)
		System.out.println("orig list "+l1);
		Collections.sort(l1);
		System.out.println("sorted as per Natural ordering criteria "+l1);
		
		
	
		
		}

}




