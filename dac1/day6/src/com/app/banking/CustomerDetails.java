package com.app.banking;

import cust_exc.InvalidInputException;

public class CustomerDetails {
	private String email, password, address;

	public CustomerDetails(String email, String password, String address)
			throws Exception {
		super();
		validateEmail(email);
		validatePassword(password);
		this.email = email;
		this.password = password;
		this.address = address;
	}

	@Override
	public String toString() {
		return "email=" + email + ", address=" + address;
	}

	public void validateEmail(String em) throws Exception {
		if (em.length() < 5 || em.length() > 20 || !em.contains("@"))
			throw new InvalidInputException("Invalid Email format...");

	}
	public void validatePassword(String pass) throws Exception {
		if (pass.length() < 5 || pass.length() > 10 || !pass.contains("$"))
			throw new InvalidInputException("Invalid Password format...");

	}


}
