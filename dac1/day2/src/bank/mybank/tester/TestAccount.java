package bank.mybank.tester;
import bank.mybank.*;
/*
Create Tester class ---
Prompt user for a/c details & create a/c object
& show a/c summary.

*/
import java.util.Scanner;

class TestAccount 
{
	public static void main(String[] args) 
	{
		//attach scanner to console i/p stream
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter A/C details");
		Account a1=new Account(sc.nextInt(),sc.next(),sc.next(),sc.nextDouble());
		//display a/c summary
		System.out.println(a1.getSummary());
	}
}




