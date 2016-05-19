package edu.fudan.string;

import java.util.Scanner;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 * Given s = "hello", return "holle".
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * @author abner
 */
public class No345 {
	public static String reverseVowels(String str) {	
		char [] charArrays=str.toCharArray();
		
		
		for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            while (i < j && !isVowels(charArrays[i])) i++;
            while (i < j && !isVowels(charArrays[j])) j--;
            if (i <= j) swap(charArrays, i, j);
        }
		
		/*int low =0;
		int high=str.length()-1;
		while(low<=high){
			char fore=charArrays[low];
			char back=charArrays[high];			
			if(!isVowels(fore)){
				low++;
			}
			if(!isVowels(back)){
				high--;
				continue;
			}
			if(isVowels(fore)&&isVowels(back)){
				charArrays[low]=back;
				charArrays[high]=fore;
				low++;
				high--;
			}
		}*/
        return new String(charArrays);
    }
	
	/**
	 * judge the symbol is vowel or not
	 * @param c
	 * @return
	 */
	private static boolean isVowels(char c) {
		char ch = Character.toLowerCase(c);
		if (ch == 'a' || ch == 'e' || ch== 'i' || ch == 'o' || ch == 'u')
			return true;
		return false;
	}
	
	private static void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
	
	public static void main(String args[]){
		Scanner scanner=new Scanner(System.in);
		String str=null;
		while((str=scanner.next())!=null){
			System.out.println(reverseVowels(str));
		}
		scanner.close();
	}
}
