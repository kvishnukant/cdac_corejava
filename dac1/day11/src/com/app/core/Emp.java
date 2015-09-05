package com.app.core;

import java.io.DataInput;
import java.io.DataOutput;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Emp {
	private int id;
	private String name;
	private double salary;
	private Date joinDate;
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
	}

	@Override
	public String toString() {
		return id + " " + name + " " + salary + "  " + sdf.format(joinDate);
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

	public void writeData(DataOutput out) throws Exception {
		// id
		out.writeInt(id);
		// name
		out.writeUTF(name);
		// sal
		out.writeDouble(salary);
		// doj
		out.writeUTF(sdf.format(joinDate));
	}

	// factory method ---public static methods --- returning class instance.
	public static Emp readData(DataInput in) throws Exception {
		return new Emp(in.readInt(), in.readUTF(), in.readDouble(),
				in.readUTF());
	}
}
