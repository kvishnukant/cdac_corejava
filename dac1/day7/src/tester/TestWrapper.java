package tester;

public class TestWrapper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer i1=100;//auto-boxing
		int data=i1++;//auto-unboxing,assgn,inc,auto-box
		System.out.println(data+"  "+i1);
		Integer i2=++data;//pre-inc(101)---auto-box
		System.out.println(data+"  "+i2);
		//within byte range -128---127 ---multiple refs refer to the same Object
		//(Integer constant pool)
	/*	Integer ref=-128;//auto-boxing
		Integer ref2=-128;//auto-boxing
		System.out.println(ref==ref2);
		System.out.println(ref.equals(ref2));
	*/	Integer ref=-129;//auto-boxing
		Integer ref2=-129;//auto-boxing
		System.out.println(ref==ref2);
		System.out.println(ref.equals(ref2));
		//understand compiler err
		Double d1=1234;//int---Integer ---XDouble
		d1=1234.0;//double---Double
		d1=(double)123;//double---Double
		
		

	}

}
