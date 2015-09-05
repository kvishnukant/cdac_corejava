package com.app.banking1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import cust_exc.InvalidInputException;

public class Account {
	// const
	public static final double MIN_BALANCE = 1000;
	public static final String BEGIN_DATE = "1-jan-2011";
	public static final String END_DATE = "31-jul-2013";
	// instance vars
	private int acctId;
	private String type;
	private double balance;
	private Date creationDate;
	private CustomerDetails details;// explicit has-a

	// id generator
	private static int idGenerator;
	private static SimpleDateFormat sdf;
	private static Date beginDate, endDate;
	static {
		try {
			idGenerator = 100;
			sdf = new SimpleDateFormat("dd-MMM-yyyy");
			beginDate = sdf.parse(BEGIN_DATE);
			endDate = sdf.parse(END_DATE);
		} catch (Exception e) {
			System.out.println("err in static init block " + e);
		}
	}

	public Account(String type, double balance, String creationDate)
			throws Exception {
		super();
		validateOpeningBalance(balance);
		this.creationDate = validateDate(creationDate);
		this.type = type;
		this.balance = balance;
		acctId = idGenerator++;

	}

	public void validateOpeningBalance(double bal) throws Exception {
		if (bal < MIN_BALANCE)
			throw new InvalidInputException("Insufficient Opening balance");
	}

	public Date validateDate(String date) throws Exception {
		Date d1 = sdf.parse(date);// creation date
		if (d1.before(beginDate) || d1.after(endDate))
			throw new InvalidInputException("Invalid date");
		return d1;

	}

	public void setDetails(Scanner sc) throws Exception {
		this.details = new CustomerDetails(sc);
	}

	@Override
	public String toString() {
		return "Account Summary \n" + acctId + " type=" + type + ", balance="
				+ balance + "\n Created on =" + sdf.format(creationDate)
				+ "\n " + details;
	}

}
