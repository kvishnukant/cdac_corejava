package coll_io;

import java.io.*;
import java.util.*;

import com.app.core.Emp;

public class EmpStoreInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// empty HM
			HashMap<Integer, Emp> hm = new HashMap<>();
			hm.put(101, new Emp(101, "abc", 12000, "1-jan-2013"));
			hm.put(10, new Emp(10, "Abc", 16000, "1-dec-2012"));
			hm.put(37, new Emp(37, "dbc", 22000, "14-mar-2013"));
			System.out.println("populated hm " + hm);
			// sort emps as per asc id
			TreeMap<Integer, Emp> tm1 = new TreeMap<>(hm);
			// TM ----> Collection<V>
			Collection<Emp> coll = tm1.values();
			// HashSet<Mgr> ---legal,
			// LinkedList<Worker> -- legal
			// Vector<Person> -- illegal
			storeEmpsById(coll);
			/*
			 * ArrayList<Integer> l1=new ArrayList<>();
			 * l1.add(10);l1.add(20);l1.add(30);
			 */
			// List<Integer> l1=Arrays.asList(1,23,45,56);
			// storeEmpsById(l1);
			storeEmpsByJoinDate(coll);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static <T extends Emp> void storeEmpsById(Collection<T> coll)
			throws Exception {
		try (PrintWriter pw = new PrintWriter(new FileWriter("emps_id.info"),
				true)) {
			for (T t : coll)
				pw.println(t);
			System.out.println("emps info by id written");

		}

	}

	private static <T extends Emp> void storeEmpsByJoinDate(Collection<T> coll)
			throws Exception {
		{
			// coll---LinkedList
			LinkedList<T> l1 = new LinkedList<>(coll);
			Collections.sort(l1, new Comparator<T>() {
				@Override
				public int compare(T o1, T o2) {
					return o1.getJoinDate().compareTo(o2.getJoinDate());
				}

			});
			System.out.println("sorted emp list as per doj " + l1);
			try (PrintWriter pw = new PrintWriter(new FileWriter(
					"emps_doj.info"))) {
				for (T t : l1)
					pw.println(t);
			}
			System.out.println("emp write by doj over...");

		}
	}

}
