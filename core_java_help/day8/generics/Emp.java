package generics;

public class Emp {
	private int id;
	private String name;
	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}


	public String toString() {
		return " [id=" + id + ", name=" + name + "]";
	}
	

}
