import java.util.*;
import package2.*;
public class CallinginDifferentPackage {
	public static void main(String[] args) {	
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter Two Numbers : ");
	    int first = scanner.nextInt();
	    int second = scanner.nextInt();
	    Functions f=new Functions();
		System.out.println("Sum = " + f.add(first,second));
		System.out.println("Difference = " + f.difference(first, second));
		System.out.println("Multiplication = " + f.multiply(first, second));
		System.out.println("Division = " + f.divide(first, second));
		System.out.println("Reverse of 12345 is = " + f.reverse(12345));
	}
}
