//composite PK -- involving id & dept ID
package sets;

public class Emp2 {
	private int id;
	private String name,deptId;
	private double sal;
	public Emp2(int id, String name, String deptId, double sal) {
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
	/*@Override
	public boolean equals(Object o)
	{
		System.out.println("in equals");
		if (o instanceof Emp2)
			return id==((Emp2) o).id;
		return false;
		
	}
	@Override
	public int hashCode()
	{
		System.out.println("in hash code");
		//poorly written hash function --- FOR UNDERSTANDING PURPOSE ONLY
	
	//	return id % 10;
	return 23*id;
		
	}*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deptId == null) ? 0 : deptId.hashCode());
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp2 other = (Emp2) obj;
		if (deptId == null) {
			if (other.deptId != null)
				return false;
		} else if (!deptId.equals(other.deptId))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
