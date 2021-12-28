import java.util.*;
public class EvenOdd {
	public static void main(String args[])
	{
		int num=0;
		for(int i=0;i<10;i++) {
			System.out.print(num+" ");
			num+=2;
		}
		num=1;
		System.out.println();
		for(int i=0;i<10;i++) {
			System.out.print(num+" ");
			num+=2;
		}
	}
}
