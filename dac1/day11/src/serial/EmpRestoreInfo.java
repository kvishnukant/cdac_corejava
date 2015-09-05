package serial;

import static serial.Emp.getCounter;
import static serial.Emp.getSdf;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class EmpRestoreInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// retrieve emp details from bin file using advanced Object
		// streams(de-serializer)
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				"emps_info.ser"))) {
			System.out.println("Re-constrcuted Map " + in.readObject());
			System.out.println("counter = "+getCounter());
			System.out.println("sdf=" +getSdf());


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
