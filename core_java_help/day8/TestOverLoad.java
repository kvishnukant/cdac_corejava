package tester;

public class TestOverLoad {

	/**
	 * @param args
	 * In every case, when an exact match isn't found, the JVM uses the method with the
smallest argument that is wider than the parameter.
	 */
	public static void main(String[] args) {
	//	test(null);
		test(100);
		test1(100,200);

	}
	public static void test(int e)
	{
		System.out.println("5");
	}
	public static void test(double e)
	{
		System.out.println("6");
	}
	public static void test(float e)
	{
		System.out.println("7");
	}

	/*public static void test(String e)
	{
		System.out.println("in string");
	}
	public static void test(Object e)
	{
		System.out.println("in object");
	}
	*/
	
	/*public static void test(Emp e)
	{
		System.out.println("1");
	}
	public static void test(Mgr e)
	{
		System.out.println("2");
	}
	public static void test(HrMgr e)
	{
		System.out.println("3");
	}*/
	/*public static void test(Integer i)
	{
		System.out.println("4");
	}*/
	public static void test1(double d,float e)
	{
		System.out.println("77");
	}
	public static void test1(float d,double e)
	{
		System.out.println("88");
	}
	
}
class Emp
{
	
}
class Mgr extends Emp
{
	
}
class HrMgr extends Mgr
{
	
}
