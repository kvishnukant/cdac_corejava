package maps.core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
	private String email, password;
	private double subscriptionAmt;
	private Date subscriptionDate;
	// sdf
	private static SimpleDateFormat sdf;
	static {
		sdf = new SimpleDateFormat("dd-MM-yyyy");
	}

	public Customer(String email, String password, double subscriptionAmt,
			String subscriptionDate) throws Exception {
		super();
		this.email = email;
		this.password = password;
		this.subscriptionAmt = subscriptionAmt;
		this.subscriptionDate = sdf.parse(subscriptionDate);
	}

	@Override
	public String toString() {
		return "Customer email=" + email + ", subscriptionAmt="
				+ subscriptionAmt + ", subscriptionDate="
				+ sdf.format(subscriptionDate);

	}

	public double getSubscriptionAmt() {
		return subscriptionAmt;
	}

	public void setSubscriptionAmt(double subscriptionAmt) {
		this.subscriptionAmt = subscriptionAmt;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Date getSubscriptionDate() {
		return subscriptionDate;
	}
	

}
