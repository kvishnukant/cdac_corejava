package bin_io_coll;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import com.app.core.Emp;
import static com.app.core.Emp.*;

public class EmpRestoreUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
		// retrieve emps in HM from underlying bin file --- using buffer & mixed
		// data strms
		HashMap<Integer, Emp> emps = restoreEmpData();
		System.out.println("re-stored details "+emps);
		} catch (Exception e )
		{
			e.printStackTrace();
		}
		System.out.println("main over....");

	}

	private static HashMap<Integer, Emp> restoreEmpData() throws Exception {
		HashMap<Integer, Emp> hm = new HashMap<>();
		// chk if correct file exists
		File f1 = new File("emps_info.data");
		if (f1.exists() && f1.isFile() && f1.canRead()) {
			try (DataInputStream din = new DataInputStream(
					new BufferedInputStream(new FileInputStream(f1)))) {
				boolean readOver = false;
				while (!readOver) {
					Emp e = readData(din);
					hm.put(e.getId(), e);
				}

			} catch (Exception e) {
				if (!(e instanceof EOFException)) {
					hm.clear();
					throw e;
				}
				else
					System.out.println("data read over...");
			}

		} else
			System.out.println("invalid data file....");
		return hm;
	}
}
