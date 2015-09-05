package tester;
import org.*;

class TestEmpEquals 
{
	public static void main(String[] args) 
	{
		Emp e1=new Emp(101,"abc",12345);
		Emp e2=e1;//new Emp(101,"abc",12345);
		System.out.println(e1.equals(e2));
		System.out.println(e1==e2);

	}
}
