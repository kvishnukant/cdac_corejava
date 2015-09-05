package p1;

public class B extends A {
	private int someData;
	
	public B(int a,int b) {
		super(a);
		someData=b;
	}
	void test()
	{
		//display
		display();
	}
	static void test1()
	{
		//display --- but using A's ref
		A ref=new A(100);
		ref.display();
	}

}
