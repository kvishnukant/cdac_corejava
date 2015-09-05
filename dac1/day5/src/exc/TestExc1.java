package exc;

public class TestExc1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// Business logic
			String[] strings = { "abc", "123", "123.45" };
			System.out.println(Integer.parseInt(strings[1]));
			String s = null;
			System.out.println(s.charAt(0));
			System.out.println("end of try");
		} catch (NumberFormatException e) {
			System.out.println("in catch");
			// exc handling code
			e.printStackTrace(); // cls nm,reason,location
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("in catch2 " + e);

		}
		System.out.println("cntd....");
	}
}
