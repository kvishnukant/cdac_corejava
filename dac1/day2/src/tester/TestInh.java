package tester;
import inh.*;

class TestInh 
{
	public static void main(String[] args) 
	{
		//super cls ref, super cls instance
		//sub cls ref,sub-cls object
		A a1;
		a1=new A(100);
	//	a1.show();
	//	a1.test();
	    B b1;
		b1=new B(1,2);
	//	b1.show();
	//	b1.test();
		A ref;
		ref=b1;//up-casting
	//	ref.show();//dynamic method dispatch
	//	((B)ref).test();//down-casting
		B ref2;
		//if (ref2 instanceof B)
		//{
		ref2=(B)a1;//produces class cast exception
		ref2.show();
		ref2.test();

	/*	}
		else
			System.out.println("illegal type");*/
	
	}
}
