import java.util.*;
public class AllArthimaticOperations {
   public static void main(String[] args) {
        
	  

        int i=12345;
        int a=1;
        int b=5;
        //System.out.println();
        
        
    }
  
   public static boolean check(int i,int a,int b)
   {
	   String s=""+i;
       String s1=""+a;
       String s2=""+b;
       int f1=0;
       int f2=0;
       for(int j=0;j<s.length();j++)
       {
       	if(s.charAt(j)==s1.charAt(0))
       	{
       		f1=1;
       	}
       	if(s.charAt(j)==s2.charAt(0))
       	{
       		f2=1;
       	}
       }
       if(f1==1&&f2==1)
    	   return true;
       return false;
   }
}
