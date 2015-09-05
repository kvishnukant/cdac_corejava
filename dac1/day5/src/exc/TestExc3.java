package exc;

public class TestExc3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// Business logic
			String[] strings = { "abc", "123", "123.45" };
			System.out.println(Integer.parseInt(strings[0]));
			String s = null;
			System.out.println(s.charAt(0));
			System.out.println("end of try");
		}
		/*
		 * catch (ArrayIndexOutOfBoundsException e) {
		 * System.out.println("in catch"); }
		 */catch (Exception e) {
			if (e instanceof ArrayIndexOutOfBoundsException)
				System.out.println("1");
			else
				System.out.println("in catch-all " + e);

		}

		System.out.println("cntd....");
	}
}
