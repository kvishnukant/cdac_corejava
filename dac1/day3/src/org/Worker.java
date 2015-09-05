package org;
public class  Worker extends Emp
{
	//state
	private int noOfHours;
	private double rate;
	public Worker(int id,String nm123,double basic,int no,double rate)
	{
		super(id,nm123,basic);
		noOfHours=no;
		this.rate=rate;
	}
		@Override 
		public String toString()
	{
		return "Worker "+super.toString()+" No Of Hrs "+noOfHours;
	}
	@Override
		public double computeNetSalary()
	{
		return getBasic()+(rate*noOfHours);
	}
	public double getRate()
	{
		return rate;
	}

}
