package serial;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import static serial.Emp.*;



public class EmpStoreInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("emps_info.ser"))) {
			// empty HM
			// populate the same
			HashMap<Integer, Emp> hm = new HashMap<>();
			// populate
			hm.put(101, new Emp(101, "abc", 12000, "1-jan-2013"));
			hm.put(10, new Emp(10, "Abc", 16000, "1-dec-2012"));
			hm.put(37, new Emp(37, "dbc", 22000, "14-mar-2013"));
			//set adr of all emps
			hm.get(101).setAdr("Pune", "IN", "12345");
			hm.get(10).setAdr("Mumbai", "IN", "23456");
			hm.get(37).setAdr("Goa", "IN", "34567");
			System.out.println("populated hm " + hm);
			System.out.println("counter = "+getCounter());
			System.out.println("sdf=" +getSdf());

			// Using adv streams extract state of collection & store it in bin
			// file.
			out.writeObject(hm);
			System.out.println("wrote data.....");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
