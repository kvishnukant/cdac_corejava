package org;
public class Mgr extends Emp
{
	//state
	private double perfBonus;
	public Mgr(int id,String name,double basic,double bonus)
	{
		super(id,name,basic);
		perfBonus=bonus;
	}
	@Override 
		public String toString()
	{
		return "Mgr "+super.toString()+" Bonus="+perfBonus;
	}
	@Override
		public double computeNetSalary()
	{
		return getBasic()+perfBonus;
	}
	public double getPerfBonus()
	{
		return perfBonus;
	}
	
}
