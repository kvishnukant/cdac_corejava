package generics;

public class Mgr extends Emp {
	private double bonus;

	public Mgr(int id, String name, double bonus) {
		super(id, name);
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "Mgr "+super.toString()+"[bonus=" + bonus + "]";
	}
	

}
