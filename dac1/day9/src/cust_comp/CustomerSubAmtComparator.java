package cust_comp;

import java.util.Comparator;

import maps.core.Customer;

public class CustomerSubAmtComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer arg0, Customer arg1) {
		// TODO Auto-generated method stub
		if (arg0.getSubscriptionAmt() < arg1.getSubscriptionAmt())
			return -1;
		if (arg0.getSubscriptionAmt() > arg1.getSubscriptionAmt())
			return 1;
		return 0;
	}

}
