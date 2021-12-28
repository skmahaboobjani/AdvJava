import java.util.*;
public class ArrayIndexOutOfBoundException {
	public static void main(String[] args) {
		int arr[]=new int[5];
		Arrays.fill(arr, 3);
		for(int i=0;i<=5;i++)
		{
			System.out.println(arr[i]);
		}
	}
}
