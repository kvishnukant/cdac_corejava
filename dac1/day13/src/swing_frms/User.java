package swing_frms;

import java.io.Serializable;

public class User implements Serializable{
	private String email,password,prefs;

	public User(String email, String password, String prefs) {
		super();
		this.email = email;
		this.password = password;
		this.prefs = prefs;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", prefs="
				+ prefs + "]";
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPrefs() {
		return prefs;
	}
	
	
	

}
