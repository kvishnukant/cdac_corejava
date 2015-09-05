package tester;

import java.util.Arrays;

import com.app.core.Box;

public class BoxDynInitArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// dyn init of BOx[]
		Box[] boxes = { new Box(1, 2, 3), new Box(11, 12, 13),
				new Box(21, 22, 23) };
		System.out.println(Arrays.toString(boxes));

	}
}
