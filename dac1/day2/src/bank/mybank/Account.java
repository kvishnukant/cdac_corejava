package bank.mybank;
public class  Account
{
	//instance vars
	private int acctId;
	private String name,type;
	private double balance;
	public Account(int id,String name,String ty,double bal)
	{
		acctId=id;
		this.name=name;
		type=ty;
		balance=bal;
	}
	//Get summary --- rets string form of a/c summary
	public String getSummary()
	{
		return "A/C Details "+acctId+" "+name+" "+type+"  "+balance;
	}

}
