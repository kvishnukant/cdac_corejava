package lists.core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Emp {
	private int id;
	private String name;
	private double sal;
	private Date joinDate;
	// sdf
	private static SimpleDateFormat sdf;
	static {
		sdf = new SimpleDateFormat("dd-MM-yyyy");
	}

	public Emp(int id, String name, double sal, String joinDate)
			throws Exception {
		super();
		this.id = id;
		this.name = name;
		this.sal = sal;
		this.joinDate = sdf.parse(joinDate);
	}

	@Override
	public String toString() {
		return "Emp id=" + id + ", name=" + name + ", sal=" + sal
				+ ", joinDate=" + sdf.format(joinDate);
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}
	

}
