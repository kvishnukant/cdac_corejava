/**
 * Understanding clone() & Cloneable i/f --- marker / tag i/f --empty i/f 
 * --containing no methods
 *  * Not used frequently in Java API classes or in application dev.
 * Understanding purpose only 
 */
package tester1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestClone {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		A1 ref = new A1(100, "abc", "11/1/2009");

		A1 ref2 = ref.clone();
		System.out.println(ref);
		System.out.println(ref2);
		ref2.setData(200);
		// ref2.modifyName("last_name");
		ref2.acceptDate("1/1/2012");
		System.out.println(ref);
		System.out.println(ref2);

	}

}

class A1 implements Cloneable {
	private int data;
	private String name;
	private Date userDate;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public A1(int data, String name, String s) throws Exception {
		super();
		this.data = data;
		this.name = name;
		userDate = sdf.parse(s);
	}

	@Override
	protected A1 clone() throws CloneNotSupportedException {
		A1 ref = (A1) super.clone();

		ref.userDate = (Date) userDate.clone();
		return ref;

	}

	@Override
	public String toString() {
		return "A1 " + super.toString() + "[data=" + data + "  " + name + "  "
				+ sdf.format(userDate) + "]";
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data += data;
	}

	public String getName() {
		return name.toString();
	}

	
	public void acceptDate(String s) throws Exception {

		userDate.setTime(sdf.parse(s).getTime());
	}

}
