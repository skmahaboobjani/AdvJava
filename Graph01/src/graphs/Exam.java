package graphs;

public class Exam {

	public Exam() {

	}

	public static void main(String[] args) {

		int number = 987400, reverse = 0;
		while (number != 0) {
			int remainder = number % 10;
			reverse = reverse * 10 + remainder;
			number = number / 10;
		}
		//System.out.println("The reverse of the given number is: " + rev("hello       i am  sai,"));

		/*
		 * int m1,m2; int res; m1=revNum(23); m2=revNum(451); res=m1+m2;
		 * res=revNum(res);
		 */
	}

	private static int revNum(int number) {
		int reverse = 0;
		while (number != 0) {
			int remainder = number % 10;
			reverse = reverse * 10 + remainder;
			number = number / 10;
		}
		return reverse;
	}

	 static void printResult(String strs) {
		String[] splited = strs.split(" ");
		
		for(int i=0;i<splited.length;i++)
		{
			splited[i]=splited[i].replaceAll("\\s", "");
		}
		String st = "";
		for (int i = splited.length - 1; i >= 0; i--) {
			if(!splited[i].equals(""))
			st = st + splited[i] + " ";
		}
		System.out.println(st);
	}
}
