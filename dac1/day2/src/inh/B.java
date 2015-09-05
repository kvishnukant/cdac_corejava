package inh;
public class B extends A
{
	private int j;
	public B(int a,int b)
	{
	
	    super(a);
//	i=a;
		j=b;
	}
	public void show()
	{
		System.out.println("in sub-class 's show");
	}
	public void test()
	{
		System.out.println("in sub-class 's test");
	}
}
