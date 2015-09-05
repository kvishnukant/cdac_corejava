//generic class syntax
package generics;
//T = type of the class 
public class Generic<T> {
	private T ref;
	public Generic(T ref) {
		super();
		this.ref = ref;
	}

	public T getRef() {
		return ref;
	}

	public void setRef(T ref) {
		this.ref = ref;
	}
	void showDetails()
	{
		System.out.println("class type of 'this'"+this.getClass().getName());
		System.out.println("class type of 'ref' "+ref.getClass().getName());
	}
	public static void main(String[] args)
	{
	   //g1 --- 
		Generic<Integer> g1=new Generic<>(1234);//int---Integer (auto-boxing)
		g1.showDetails();
		int data=g1.getRef();//Integer--->int ---auto-unboxing 
		//NO NEED of explicit down-casting
		Generic<String> g2=new Generic<>("1234");
		g2.showDetails();
	//	g1=g2;
		g2.setRef("1234");
		
	}
	

	
	
	
	
}
