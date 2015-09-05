package tester;

import intf.*;

public class TestInterfaces3 implements A,B{

	@Override
	public void display() {
		System.out.println("in display");
		
	}

	@Override
	public void show() {
		System.out.println("in show " +A.DATA);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestInterfaces3 t1=new TestInterfaces3();
		A ref=t1;
		ref.show();
		B ref2=t1;
		ref2.display();

	}
	

}
