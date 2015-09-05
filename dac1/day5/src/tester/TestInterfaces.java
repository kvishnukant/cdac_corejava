package tester;

import intf.Compute;
import shapes.*;

public class TestInterfaces {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// using direct referencing
		// create circle inst & rect inst
		Circle c1 = new Circle(10, 45, 12.34);
		Rect r1 = new Rect(20, 50, 10, 12.56);
		// display details + area & peri
		System.out.println(c1 + " Area " + c1.calcArea() + " Peri "
				+ c1.calcPerimeter());
		System.out.println(r1 + " Area " + r1.calcArea() + " Peri "
				+ r1.calcPerimeter());
		Compute ref;
		ref=c1;//up-casting i/f scenario
		System.out.println(ref + " Area " + ref.calcArea() + " Peri "
				+ ref.calcPerimeter());
		ref=r1;//up-casting i/f scenario
		System.out.println(ref + " Area " + ref.calcArea() + " Peri "
				+ ref.calcPerimeter());
	

	}

}
