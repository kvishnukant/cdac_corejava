package non_generics;

public class NonGeneric {
	private Object ref;

	public NonGeneric(Object ref) {
		super();
		this.ref = ref;
	}

	public Object getRef() {
		return ref;
	}

	public void setRef(Object ref) {
		this.ref = ref;
	}
	void showDetails()
	{
		System.out.println("class type of 'this'"+this.getClass().getName());
		System.out.println("class type of 'ref' "+ref.getClass().getName());
	}
	public static void main(String[] args)
	{
		NonGeneric n1=new NonGeneric(1234);//int--->Integer--->Object
		n1.showDetails();
		int data=(int)n1.getRef();//down-casting,un-boxing--- dis-adv---
		//essential ---down-casting
		NonGeneric n2 =new NonGeneric("1234");//String---Object -- up-casting
		n2.showDetails();
		n1.setRef(123.45);
		n1=n2;
		data=(int)n1.getRef();
		System.out.println(data);
	}
	

	
	
	
	
}
