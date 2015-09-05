package tester;

class TestOverride
{
	private void test()
	{
		System.out.println("1");
	}
	public static void main(String[] args) {
		TestOverride ref=new B();
		ref.test();

	}

}
class B extends TestOverride
{
	
	private void test()
	{
		System.out.println("2");
	}
}
