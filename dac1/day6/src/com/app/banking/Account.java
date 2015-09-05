package com.app.banking;

import java.text.SimpleDateFormat;
import java.util.Date;

import cust_exc.InvalidInputException;

public class Account {
	// consts
	public static final double MIN_BALANCE = 1000;
	public static final String DATE_FORMAT = "dd-MMM-yyyy";
	public static final String BEGIN_DATE = "1-jan-2012";
	public static final String END_DATE = "31-jul-2013";
	// static members
	private static SimpleDateFormat sdf;
	private static int idCounter;
	private static Date beginDate, endDate;
	// instance vars
	private int acctId;
	private String type;
	private double balance;
	private Date creationDate;
	private CustomerDetails details;// explicit has-a

	static {
		idCounter = 500;
		sdf = new SimpleDateFormat(DATE_FORMAT);
		try {
			beginDate = sdf.parse(BEGIN_DATE);
			endDate = sdf.parse(END_DATE);
		} catch (Exception e) {
			System.out.println("err in static init block " + e);
		}
	}

	public Account(String type, double balance, String creationDate)
			throws Exception {
		super();
		validateBalance(balance);
		this.creationDate = validateDate(creationDate);
		acctId = idCounter++;
		this.type = type;
		this.balance = balance;

	}

	public void validateBalance(double bal) throws Exception {
		if (bal < MIN_BALANCE)
			throw new InvalidInputException("Insufficient opening balance");
	}

	public Date validateDate(String date) throws Exception {
		Date d1 = sdf.parse(date);
		if (d1.before(beginDate) || d1.after(endDate))
			throw new InvalidInputException("Invalid Creation Date");
		return d1;

	}

	public void setDetails(String em, String pass, String adr) throws Exception {
		this.details = new CustomerDetails(em, pass, adr);
	}

	@Override
	public String toString() {
		return "Account Summary " + acctId + " type=" + type + " balance="
				+ balance + " \n Created on =" + sdf.format(creationDate)
				+ "\n Cust Details =" + details;
	}

}
