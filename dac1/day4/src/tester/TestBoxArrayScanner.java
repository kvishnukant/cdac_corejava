package tester;

import java.util.Scanner;

import com.app.core.Box;

public class TestBoxArrayScanner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// sc
		Scanner sc = new Scanner(System.in);
		// prompt -- no of boxes
		System.out.println("Enter no of boxes to be made");
		Box[] boxes = new Box[sc.nextInt()];
		System.out.println("default contents of array");
		for (Box b : boxes)
			System.out.println(b);
		// init box dims
		for (int i = 0; i < boxes.length; i++) {
			System.out.println("Enter Box dims #" + i);
			boxes[i] = new Box(sc.nextDouble(), sc.nextDouble(),
					sc.nextDouble());
		}
		// display via for-each loop
		for(Box b : boxes)
		{
			b.displayDims();
			System.out.println("Vol= "+b.calcVolume());
		}
		if (sc != null)
			sc.close();

	}

}
