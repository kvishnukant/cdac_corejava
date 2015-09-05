package exc;

public class TestFinally2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		System.out.println("1");
		try {
			testMe();
			System.out.println("back in main");
		} catch (RuntimeException e) {
			System.out.println("err " + e + " msg" + e.getMessage());
		} finally {
			System.out.println("in main's finally");
		}
		System.out.println("over..");

	}
	private static void testMe() throws InterruptedException {
		try {
			System.out.println("in try");
			String[] ss = { "aa", "bb" };
			Thread.sleep(1234);
			System.out.println(ss[0]);
			boolean flag = false;
			if (flag)
				return;
			System.out.println("end of try");
		} finally {
			System.out.println("in meth's finally");
		}
		System.out.println("meth end");
	}

}
