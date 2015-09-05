package cust_comp;

import java.util.Comparator;

public class CustomerDescEmailComparator implements Comparator<String> {

	@Override
	public int compare(String arg0, String arg1) {
		System.out.println("in compare....");
		return arg1.compareTo(arg0);
	}

}
