package org;
public class Emp 
{
	//state -- instance vars (non-staticData memebrs)
	private int id;
	private String name;
	private double basic;
	public Emp(int id,String nm,double basic)
	{
		this.id=id;
		name=nm;
		this.basic=basic;
	}
	public String toString()
	{
		return id+"  "+name+"  "+basic;

	}
	@Override
	public boolean equals(Object e)
	{
		System.out.println("in emp equals");
		if(e instanceof Emp)
		  return this.id==((Emp)e).id;
		return false;
	}
	public double computeNetSalary()
	{
		return -1;
	}
	public double getBasic()
	{
		return basic;
	}
}
