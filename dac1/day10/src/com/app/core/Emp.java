package com.app.core;

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

	public Emp(int id, String name, double salary, String joinDate) throws Exception{
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.joinDate = sdf.parse(joinDate);
	}

	@Override
	public String toString() {
		return id+" "+name+" "+salary+"  "+sdf.format(joinDate);
	}

	public Date getJoinDate() {
		return joinDate;
	}
	
	

}
