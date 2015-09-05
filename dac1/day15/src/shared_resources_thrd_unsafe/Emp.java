package shared_resources_thrd_unsafe;

public class Emp {
	private int id;
	private String name,deptId;
	private double salary;
	public Emp(int id, String name, String deptId, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.deptId = deptId;
		this.salary = salary;
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
	public double getSalary() {
		return salary;
	}
	
	

}
