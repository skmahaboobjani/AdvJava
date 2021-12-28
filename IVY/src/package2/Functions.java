package package2;
import java.util.*;
public class Functions {
    public int add(int first,int second) {
    	 return first + second;
    }
    public int difference(int first,int second) {
    	return first - second;
    }
    public int multiply(int first,int second) {
    	return first * second;
    }
    public int divide(int first,int second) {
   	 return first/second;
    }
    public int reverse(int n)
    {
    	int sum=0;
    	while(n>0)
    	{
    		sum=sum*10+n%10;
    		n=n/10;
    	}
    	return sum;
    }
   }
