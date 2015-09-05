package com.app.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CustomerComplaint implements Serializable {
	private String email, password, address, platform;
	private ArrayList<String> technologies;
	private String browser;
	private StringBuilder desc;
	private int complaintId;
	private StringBuilder status;
	// for generating random unique complaint ids
	private static ArrayList<Integer> nums;
	private static int index;

	public static void initNumbers() {
		System.out.println("in init nums....");
		// create empty AL
		nums = new ArrayList<>();
		// populate with nums 1----1000
		for (int i = 1; i < 1001; i++)
			nums.add(i);
		// randomize the same
		Collections.shuffle(nums);
		System.out.println("shuffled list " + nums);

	}

	public CustomerComplaint(String email, String password, String address,
			String platform, String browser, String desc,
			ArrayList<String> selectedTechno) {
		super();
		this.email = email;
		this.password = password;
		this.address = address;
		this.platform = platform;
		this.browser = browser;
		this.desc = new StringBuilder(desc);
		technologies = selectedTechno;
		status = new StringBuilder("Pending");
		complaintId = nums.get(index++);

	}

	@Override
	public String toString() {
		return "Hello, " + email + "\n platform=" + platform
				+ "\n technologies=" + technologies + "\n browser=" + browser
				+ "\n Ref Complaint NO =" + complaintId + "complaint status="
				+ status;
	}

	public int getComplaintId() {
		return complaintId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public ArrayList<String> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(ArrayList<String> technologies) {
		this.technologies = technologies;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public StringBuilder getDesc() {
		return desc;
	}

	public void setDesc(StringBuilder desc) {
		this.desc = desc;
	}

	public String getStatus() {
		return status.toString();
	}

	public void setStatus(String status1) {
		this.status = status.replace(0, status.length(), status1);
	}

	public static ArrayList<Integer> getNums() {
		return nums;
	}

	public static void setNums(ArrayList<Integer> nums) {
		CustomerComplaint.nums = nums;
	}

	public static int getIndex() {
		return index;
	}

	public static void setIndex(int index) {
		CustomerComplaint.index = index;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}
	

}
