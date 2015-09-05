package serial;

import java.io.Serializable;

public class Address// implements Serializable 
{
	private String city,country,zipCode;

	public Address(String city, String country, String zipCode) {
		super();
		this.city = city;
		this.country = country;
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", country=" + country + ", zipCode="
				+ zipCode + "]";
	}
	

}
