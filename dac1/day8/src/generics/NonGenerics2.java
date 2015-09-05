package generics;

import java.util.ArrayList;
import java.util.Date;

public class NonGenerics2 {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		ArrayList l1=new ArrayList();
		l1.add(123);
		l1.add("abc");
		l1.add(new Date());
		String s=(String)l1.get(0);
		System.out.println(s);
		

	}

}
