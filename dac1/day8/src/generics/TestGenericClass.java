package generics;

public class TestGenericClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String [] data={"I","am","new","to","Generics"};
		Pair<String> p=ArrayUtils.minMax(data);
		System.out.println("Min= "+p.getFirst());
		System.out.println("Max= "+p.getSecond());

	}

}
