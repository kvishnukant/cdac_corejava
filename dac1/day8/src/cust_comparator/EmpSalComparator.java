package cust_comparator;

import lists.core.*;

import java.util.Comparator;

public class EmpSalComparator implements Comparator<Emp> {
	@Override
	public int compare(Emp e1, Emp e2) {
		System.out.println("in compare");
		if (e1.getSal() < e2.getSal())
			return -1;
		if (e1.getSal() > e2.getSal())
			return 1;
		return 0;

	}

}
