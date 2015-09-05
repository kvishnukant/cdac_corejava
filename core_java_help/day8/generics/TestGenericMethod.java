package generics;

import java.util.Arrays;

public class TestGenericMethod {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String [] data={"I","am","new","to","Generics","Methods"};
		
		System.out.println("Middle string elem --  "+ArrayUtils1.getMedian(data));
		Integer [] ints={10,20,30,40,50};
		System.out.println("Middle int elem --  "+ArrayUtils1.getMedian(ints));
		
		System.out.println("Middle double elem --  "+ArrayUtils1.getMedian(new Double[] {1.0,2.0,3.5}));
	
	}
	
	

}
