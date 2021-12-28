import java.util.Scanner;

abstract class Account
{
	public final double minBal;
	private long accountNumber;
	private String accountName;
	private double amount;
	public Account()
	{
		this.minBal=1000;
	}
	public Account(long accountNumber,String accountName, double amount,double minBal)
	{
		this.minBal=minBal;
		this.accountName= accountName;
		this.accountNumber=accountNumber;
		
		if (amount> 0.0)                    
			this.amount = amount; 
	}
	public void deposit(double depositAmount)                        
    {                                                                
		if (depositAmount > 0.0)      
			amount = amount + depositAmount; 
	}
	public double getBalance()           
	{                                    
		 return amount;                   
	} 
	public double setBalance(double amo)           
	{
		amount+=amo;
		 return amount;                   
	} 
	public void setName(String name)
    {
		this.accountName = name;
	}
	public double getMinBalence()
	{
		return minBal;
	}
}
final class Savings extends Account
{
	
	double bal=0;
	Savings(long accountNumber,String accountName, double amount)
	{
		
		super(accountNumber,accountName,amount,1000);
	}
	public void addInterest()
	{
		bal=getBalance();
		bal=(bal*12*4)/100;
		deposit(bal);
		//setBalance(bal);
	}
}
final class Current extends Account
{
	double bal=0;
	Current(long accountNumber,String accountName, double amount)
	{
		super(accountNumber,accountName,amount,5000);
	}
}
public class Bank {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println(" Enter type of Account 1.Savings 2.Current");
		String type=sc.next();
		if(type.equals("1")||type.equalsIgnoreCase("Savings"))
		{
			System.out.println(" Enter Account Holder Name");
			String name=sc.next();
			Savings sv=new Savings(123-456-789,name,1000);
			sv.addInterest();
			System.out.println("Total Balence "+sv.getBalance());
			System.out.println("Minimum Balence "+sv.getMinBalence());
		}
		else
		{
			System.out.println(" Enter Account Holder Name");
			String name=sc.next();
			Current cu=new Current(123-456-789,name,23000);
			System.out.println("Total Balence "+cu.getBalance());
			System.out.println("Minimum Balence "+cu.getMinBalence());
		}	
	}
}
