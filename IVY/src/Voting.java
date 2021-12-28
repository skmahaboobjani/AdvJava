import java.util.*;
public class Voting{
	
public static void main(String args[]){

	Scanner scan=new Scanner (System.in);
	System.out.println("Enter the age of person");

	int user_age=scan.nextInt();

	System.out.println("The age of person is "+user_age);

	if(user_age>=18)
	{
		System.out.println("Eligible to Vote");
	}
	else{
		System.out.println("Not eligible to vote");

	}
	}
}