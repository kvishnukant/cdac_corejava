package tester;

public class TestSB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("hello");
		System.out
				.println("length =" + sb.length() + " capa =" + sb.capacity());
		sb.append(", 12345678");
		sb.append(new A(56789));
		sb.reverse();
		System.out.println(sb + " length " + sb.length() + " capa "
				+ sb.capacity());
	}

}
class A {
	private int data;

	public A(int data) {
		super();
		this.data = data;
	}

	@Override
	public String toString() {
		return "A [data=" + data + "]";
	}

}
