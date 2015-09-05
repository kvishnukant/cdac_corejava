package p1;

public class A {
	protected int data;

	public A(int data) {
		super();
		this.data = data;
	}
	protected void display()
	{
		System.out.println("in disp "+data);
	}
	public void show()
	{
		System.out.println("in show....");
	}

}
