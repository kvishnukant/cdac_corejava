package generics;

public class NonGenerics1 {
	private Object ref;

	public NonGenerics1(Object ref) {
		super();
		this.ref = ref;
	}

	public Object getRef() {
		return ref;
	}

	public void setRef(Object ref) {
		this.ref = ref;
	}
	public void showDetails()
	{
		System.out.println(getClass().getName());
		System.out.println("Ref's details "+ref.getClass().getName());
	}

}
