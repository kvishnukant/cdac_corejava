package generics;

public class TestBoundedGenericmethod {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] data={10,1,4,78,90};
		Pair<Integer> p=ArrayUtils3.minMax(data);
		System.out.println("Min= "+p.getFirst()+"  Max="+p.getSecond());

	}

}
