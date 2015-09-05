package cust_care;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;

public class CustomerComplaint implements Serializable {
	private static int counter = 1;
	private int id;
	private String name, email, addr, os, details;
	private ArrayList<String> technologies;
	private Date registrationDate;
	
	public CustomerComplaint()
	{
		
	}


	public CustomerComplaint(String name, String email, String addr, String os,
			String details, ArrayList<String> technologies) {
		id = counter++;
		this.name = name;
		this.email = email;
		this.addr = addr;
		this.os = os;
		this.details = details;
		this.technologies = technologies;
		registrationDate = new Date();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Hello " + name
				+ "\n Ur Complaint Ref ID " + id + "\n"
				+ "Complaint registered at " + registrationDate+"\n");
		sb.append("OS - " + os + "\n");
		sb.append("Technologies - " + technologies);
		return sb.toString();
	}

	public int getId() {
		return id;
	}

}
