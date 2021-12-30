import java.util.Arrays;

public class ChariTest {
	
	public static void main(String[] args) {
		int n = 5;
		int a[] = { 1, 2, 3, 4, 5 };
		System.out.println(maxsum(n, a));
	}
	private static int maxsum(int n, int[] a) {
		Arrays.sort(a);
		int sum=0;
		int j = 0;
	    for (int i=0; i < n-1; i++)
	        if (a[i] != a[i+1])
	            a[j++] = a[i];
	    a[j++] = a[n-1];
	    
	    while(j<n)
	    {
	    	a[j]=a[j-1]+1;
	    	j++;
	    }
	    for(int i=0;i<n;i++)
	    {
	    	sum+=a[i];
	    }
	    return sum;
	}
}