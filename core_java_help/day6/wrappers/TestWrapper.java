package wrappers;

public class TestWrapper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer i1=100;//auto-boxing
		int data=++i1;//auto-unboxing,inc,assgn
		System.out.println(i1+" "+data);
		Integer i2=new Integer("456");//boxing
		data=i2.intValue();//un-boxing
		System.out.println(data);
		Object d1=100;//auto-boxing,widening(up-casting)
	//	Double d2=(Double)100;
		
	}

}
