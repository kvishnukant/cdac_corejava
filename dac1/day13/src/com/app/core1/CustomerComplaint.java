package com.app.core1;

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
	static {
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
			String[] selectedTechno) {
		super();
		this.email = email;
		this.password = password;
		this.address = address;
		this.platform = platform;
		this.browser = browser;
		this.desc = new StringBuilder(desc);
		technologies = new ArrayList<>(Arrays.asList(selectedTechno));
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
	
	

}
