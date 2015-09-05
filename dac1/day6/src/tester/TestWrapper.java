package tester;

public class TestWrapper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer i1 = 100;// auto-boxing
		i1++;// auto-unboxing,inc,auto-boxing
		System.out.println(i1);
		Object ref = 100;// auto-boxing(int-->Integer)--->up-casting(Integer--->Object)
	//	Double data=123;//int-->Integer ----X Double

	}

}
