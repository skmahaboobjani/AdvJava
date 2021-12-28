package chariTest;

import java.util.Scanner;

public class Charya {

	public static void main(String args[]) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		n = reve(n);
		System.out.println("Reverse no "+n);
		System.out.println("Octal no "+toOctal(n));

	}

	static int reve(int number) {
		int reverse = 0;
		while (number != 0) {
			int remainder = number % 10;
			reverse = reverse * 10 + remainder;
			number = number / 10;
		}
		return reverse;

	}

	static String toOctal(int decimal) {
		int rem; // declaring variable to store remainder
		String octal = ""; // declareing variable to store octal
		// declaring array of octal numbers
		char octalchars[] = { '0', '1', '2', '3', '4', '5', '6', '7' };
		// writing logic of decimal to octal conversion
		while (decimal > 0) {
			rem = decimal % 8;
			octal = octalchars[rem] + octal;
			decimal = decimal / 8;
		}
		return octal;
	}
}
