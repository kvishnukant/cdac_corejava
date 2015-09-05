package tester;

import shapes.Circle;
import shapes.Rect;
import intf.Compute;

public class TestInterfaces2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Compute[] refs = { new Circle(1, 100, 10), new Rect(20, 45, 12, 13) };
		for (Compute c : refs) {
			System.out.println(c + " area " + c.calcArea() + " peri "
					+ c.calcPerimeter()); 
			if (c instanceof Circle)
			System.out.println("rad "+((Circle)c).getRadius());
			else 
				System.out.println("height "+((Rect)c).getHeight());
				
		}

	}

}
