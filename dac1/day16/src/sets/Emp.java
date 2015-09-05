package sets;

public class Emp {
	private int id;
	private String name,deptId;
	private double sal;
	public Emp(int id, String name, String deptId, double sal) {
		super();
		this.id = id;
		this.name = name;
		this.deptId = deptId;
		this.sal = sal;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDeptId() {
		return deptId;
	}
	public double getSal() {
		return sal;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", deptId=" + deptId
				+ ", sal=" + sal + "]";
	}
	@Override
	public boolean equals(Object o)
	{
		System.out.println("in equals");
		if (o instanceof Emp)
			return id==((Emp) o).id;
		return false;
		
	}
	@Override
	public int hashCode()
	{
		System.out.println("in hash code");
		//poorly written hash function --- FOR UNDERSTANDING PURPOSE ONLY
	//	return 23*id;
		return id % 10;
		
	}
	
	

}
