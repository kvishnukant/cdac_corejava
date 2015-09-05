package serial;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Emp implements Serializable {
	private int id;
	private String name;
	private double salary;
	private Date joinDate;
	private transient Address adr;
	private static int counter;
	private static SimpleDateFormat sdf;
	static {
		sdf = new SimpleDateFormat("dd-MMM-yyyy");
	}

	public Emp(int id, String name, double salary, String joinDate)
			throws Exception {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.joinDate = sdf.parse(joinDate);
		counter++;
	}

	@Override
	public String toString() {
		return id + " " + name + " " + salary + "  " + sdf.format(joinDate)
				+ " " + adr;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public static SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setAdr(String city, String co, String code) {
		this.adr = new Address(city, co, code);
	}

	public static int getCounter() {
		return counter;
	}
	

}
