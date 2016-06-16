package edu.fudan.string;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Multiply Strings Given two numbers represented as strings, return
 * multiplication of the numbers as a string. Note:
 * 
 * The numbers can be arbitrarily large and are non-negative. Converting the
 * input string to integer is NOT allowed. You should NOT use internal library
 * such as BigInteger.
 * 
 * @author abner
 * 
 */
public class No43_2 {
	public String multiply(String num1, String num2) {
		char[] n1 = toI(num1.toCharArray());
		char[] n2 = toI(num2.toCharArray());
		char[] prod = new char[n1.length + n2.length];
		int carry = 0;
		int xp = 1;

		Arrays.fill(prod, (char) 0);
		for (int x1 = n1.length - 1; x1 >= 0; x1--) {
			if (n1[x1] > 0) {
				for (int x2 = n2.length - 1; x2 >= 0; x2--) {
					xp = x1 + x2 + 1;
					int val = (int) prod[xp];
					val = val + carry + (n1[x1] * n2[x2]);
					prod[xp] = (char) (val % 10);
					carry = val / 10;
				}

				if (carry != 0) {
					prod[xp - 1] = (char) carry;
					carry = 0;
				}
			}
		}

		String product = String.valueOf(toC(prod));
		while (product.charAt(0) == '0' && product.length() > 1) {
			product = product.substring(1);
		}

		return product;
	}

	char[] toI(char[] num) {
		for (int n = 0; n < num.length; n++) {
			num[n] -= '0';
		}

		return num;
	}

	char[] toC(char[] num) {
		for (int n = 0; n < num.length; n++) {
			num[n] += '0';
		}

		return num;
	}

	public static void main(String args[]) throws Exception {
		No43_2 t = new No43_2();
		Scanner scanner = new Scanner(System.in);
		String x = scanner.next();
		String y = scanner.next();
		scanner.close();
		System.out.println(t.multiply(x, y));
	}

}
