package coll_io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

import com.app.core.Emp;

public class RestoreEmpInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			HashMap<Integer, Emp> hm = restoreEmps();
			System.out.println("Resotred info " + hm);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static HashMap<Integer, Emp> restoreEmps() throws Exception {
		// empty HM
		HashMap<Integer, Emp> emps = new HashMap<>();
		// check file meta data
		File f1 = new File("emps_id.info");
		if (f1.exists() && f1.isFile() && f1.canRead()) {
			try (BufferedReader br = new BufferedReader(new FileReader(f1))) {
				String s = null;
				Scanner sc = null;
				int id = 0;
				while ((s = br.readLine()) != null) {
					sc = new Scanner(s);
					id = sc.nextInt();
					emps.put(id,
							new Emp(id, sc.next(), sc.nextDouble(), sc.next()));
				}
			}
		} else
			System.out.println("data read failed --- invalid file");

		return emps;
	}

}
