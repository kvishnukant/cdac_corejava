package generics;

public class TestGenerics1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	/*	// non-generic probs
		NonGenerics1 n1=new NonGenerics1(123);
		n1.showDetails();
		int data=(Integer)n1.getRef();
		NonGenerics1 n2=new NonGenerics1("hello");
		n2.showDetails();
		String s=(String) n2.getRef();
		n1=n2;
		data=(Integer)n1.getRef();*/
		Generics1<Integer> g1=new Generics1<Integer>(123);
		int data=g1.getRef();
		g1.showDetails();
		Generics1<String> g2=new Generics1<String>("hello");
		g2.showDetails();
		String s=g2.getRef();
	//	g1=g2;
	}

}
