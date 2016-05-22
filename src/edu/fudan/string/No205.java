package edu.fudan.string;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. 
 * No two characters may map to the same character but a character may map to itself.
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 * Note:
 * You may assume both s and t have the same length.
 * 
 * @author abner
 *
 * 出现字母之前出现的字母位置相同
 */
public class No205 {
	public static boolean isIsomorphic(String s, String t) {
		if(s.length()!=t.length())
			return false;
		HashMap<Character,Integer>map=new HashMap<>();
		HashMap<Character,Integer>diverseMap=new HashMap<>();
		//此处Integer改为int WA
		for (Integer i = 0; i < s.length(); i++) {
			if (map.put(s.charAt(i), i) != diverseMap.put(t.charAt(i), i))
				return false;
		}
        return true;
    }
	
	public static void main(String args[]){
		Scanner scanner =new Scanner(System.in);		
		String firstStr=scanner.next();
		String secondStr=scanner.next();
		scanner.close();
		System.out.println(isIsomorphic(firstStr, secondStr));
	}

}