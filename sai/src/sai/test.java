package sai;
import java.io.IOException;
import java.util.Arrays;
public class test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int N=6;
		String[] myArray = {"Rajiv", "Roy"};
		Arrays.sort(myArray);
		if(myArray[0].length()>myArray[1].length())
		{
			String t=myArray[0];
			myArray[0]=myArray[1];
			myArray[1]=t;
		}
	     int a=560037;
	     String ss=new String(a+"");
	     int l= ss.length();
	     System.out.println(ss.charAt(N-1));
	     System.out.println(ss.charAt(l-N));   
	     String fin=myArray[0].substring(myArray[0].length()-1,myArray[0].length());
	     fin+=myArray[1];
	     fin+=ss.charAt(N-1);
	     fin+=ss.charAt(l-N);
	     System.out.println(fin);  
	     char[] ch=fin.toCharArray();
	     for(int i=0;i<fin.length();i++) {
	    	 if(fin.charAt(i)>=65&&fin.charAt(i)<=90)
	    	 {
	    		 ch[i]=(char)(ch[i]+32);
	    	 }
	    	 
	    	 if(fin.charAt(i)>=97&&fin.charAt(i)<=122)
	    	 {
	    		 ch[i]=(char)(ch[i]-32);
	    	 }
	     }
	     System.out.println(ch);
	     System.out.println(myArray[0]);  
	     System.out.println(myArray[1]);  
	     ss=new String(ch);    
	}
}
