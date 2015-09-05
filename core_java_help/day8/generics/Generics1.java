package generics;

public class Generics1<T> {
	private T ref;

	public Generics1(T ref) {
		
		this.ref = ref;
	}

	public T getRef() {
		return ref;
	}
	
	public void showDetails()
	{
		System.out.println(getClass().getName());
		System.out.println("Ref's details "+ref.getClass().getName());
	}

}
