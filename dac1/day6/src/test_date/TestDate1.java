package test_date;

import java.util.Date;

public class TestDate1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		Date d1=new Date();
		System.out.println(d1);
		//formatted printing --- for Date time handling --- java.util.Formatter
		System.out.printf("Current Date %tD %n",d1);
		Thread.sleep(2000);
		Date d2=new Date();
		System.out.println(d1.before(d2)?"Before":"After");
		System.out.println("compare To result "+d1.compareTo(d2));
		System.out.println("ms o/p "+d1.getTime());
		

	}

}
