package lists.core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Emp implements Comparable<Emp> {
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

	public Emp(int id) {
		super();
		this.id = id;
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

	@Override
	public boolean equals(Object o) {
		System.out.println("in equals");
		if (o instanceof Emp)
			return id == ((Emp) o).id;
		return false;
	}

	@Override
	public int compareTo(Emp e) {
		System.out.println("in compare to");
		/*
		 * return id-e.id;//Cls room eg ONLY
		 *//*if (id < e.id)
			return 1;
		if (id == e.id)
			return 0;
		return -1;*/
		//sorted as per asc date.
		return joinDate.compareTo(e.joinDate);

	}

	public int getId() {
		return id;
	}

}
