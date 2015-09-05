package p2;

import p1.A;

public class C extends A {
	private int data1;

	public C(int data, int data1) {
		super(data);
		this.data1 = data1;
	}
	void test()
	{
		//access data & display
		System.out.println(data);
		display();
		
	}
	void test2()
	{
		//access data & display via A's ref
		A ref=new A(101);
		System.out.println(ref.data);
		ref.display();
		
	}
	
	

}
