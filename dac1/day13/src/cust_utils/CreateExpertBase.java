package cust_utils;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class CreateExpertBase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// empty HM
		HashMap<String, String> users = new HashMap<>();
		users.put("abc", "123");
		users.put("abc1", "1234");
		users.put("abc2", "12345");
		try (ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("users.ser"))) {
			out.writeObject(users);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
