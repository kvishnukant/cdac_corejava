//write sorted (as per name) emp details --- bin file in buffered manner USING 
//advanced streams --- mixed data strm
package bin_io_coll;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import com.app.core.Emp;

public class EmpStoreUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// empty HM
			HashMap<Integer, Emp> hm = new HashMap<>();
			// populate
			hm.put(101, new Emp(101, "abc", 12000, "1-jan-2013"));
			hm.put(10, new Emp(10, "Abc", 16000, "1-dec-2012"));
			hm.put(37, new Emp(37, "dbc", 22000, "14-mar-2013"));
			System.out.println("populated hm " + hm);

			// sort it as per name
			// HM---> Collection<V>
			Collection<Emp> emps = hm.values();
			// sort --- List<T> l1
			ArrayList<Emp> l1 = new ArrayList<>(emps);
			Collections.sort(l1, new Comparator<Emp>() {

				@Override
				public int compare(Emp arg0, Emp arg1) {
					// TODO Auto-generated method stub
					return arg0.getName().compareTo(arg1.getName());
				}

			});
			System.out.println("sorted emps by name " + l1);
			// i/o method -- to dump entire sorted coll to disk.
			writeEmpDetails(l1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main over.....");

	}

	private static <T extends Emp> void writeEmpDetails(Collection<T> c)
			throws Exception {
		try (DataOutputStream dout = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream("emps_info.data")))) {
			for (T t : c)
				t.writeData(dout);
			System.out.println("data write over...");
		}
	}

}
