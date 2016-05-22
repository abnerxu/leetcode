package edu.fudan.string;

import java.util.Scanner;

/**
 * Write a function that takes a string as input and returns the string reversed.
 * Example:
 * Given s = "hello", return "olleh".
 * @author abner
 *
 */
public class No344 {
	
	
	public static String reverseString(String s) {
		char[] cArrays=s.toCharArray();
		
		for(int i=0;i<cArrays.length/2;i++){
			swap(cArrays,i,cArrays.length-1-i);
		}
		return new String(cArrays);
	}
	
	private static void swap(char[] cArrays,int fir,int sec){
		char tmp=cArrays[fir];
		cArrays[fir]=cArrays[sec];
		cArrays[sec]=tmp;
	}
	
	public static void main(String args[]){
		Scanner scanner =new Scanner(System.in);
		String str=null;
		while((str=scanner.next())!=null){
			System.out.println(reverseString(str));
		}
		scanner.close();
	}
	

}
