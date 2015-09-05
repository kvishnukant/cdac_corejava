package params_passing;

import java.util.Arrays;

class TestParamPassing4 {
	public static void main(String[] args) {
		int[] myData = { 1, 2, 3, 4, 5 };
		/*int[] newData */myData= doubleIt(myData);

		System.out.println("Orig data - " + Arrays.toString(myData));
		System.out.println("New data - " + Arrays.toString(myData));
	}
	static int[] doubleIt(int[] ints) {
		int[] tmp = new int[ints.length * 2];
		for (int i = 0; i < ints.length; i++) {
			tmp[i] = ints[i] * 2;
		}
		return tmp;
	}
}
