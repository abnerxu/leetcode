package edu.fudan.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Reverse Words in a String
 * @author abner
 * 
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * 
 * Update (2015-02-12):
 * For C programmers: Try to solve it in-place in O(1) space.
 *
 * thought:
 * 1. double-reverse O(N): reverse the whole string first and then reverse each subString separated by ' '.
 *    but this method can not solve the problem that subString are divided by several blank space('  ').
 *    e.g.:the sky is     blue
 *    http://www.cnblogs.com/EdwardLiu/p/4306561.html
 * 
 * 2. from the back and delete the repeat '' O(N) || trim the string and delete the repeat ' ' then reverse O(N)
 *    http://blog.csdn.net/zhangyuehuan/article/details/23588271
 * 
 *  
 * 3. use stack O(N)
 *    a stack to store the word
 *    a stack to store the result
 *    http://blog.csdn.net/lanxu_yy/article/details/38827845
 * 
 * 4. it is easy to solved by java. O(N) but the space complexity is O(N)
 *    (1)  str = str.trim();
 *    (2)  strArray=str.split(" +");
 *    (3)  reverse(strArray);
 *    
 *    
 */
public class No151and186 {
	
	/**
	 * No151
	 * time complexity is O(N),space complexity is O(N)
	 * @param s
	 * @return
	 */
	public static String reverseWords(String s) {
		if(s==null||s.length()==0)
			return "";
		s=s.trim();
		String []strArrays=s.split(" +");
		StringBuilder stringBuilder=new StringBuilder();
		for (int i = strArrays.length-1; i >=0; i--) {
			stringBuilder.append(strArrays[i]).append(" ");
		}
		return stringBuilder.substring(0, stringBuilder.length()-1);
		
    } 
	
	/**
	 * No186
	 * time complexity is O(N),space complexity is O(1)
	 * @param s
	 * @return
	 */
	public static String reverseWords2(String s) {
		int start=0,end=0;		
		StringBuilder stringBuilder=new StringBuilder();		
		int i=s.length()-1;
		while(i>=0){
			while(i>=0&&s.charAt(i)==' ')
				i--;
			if(i<0)
				break;
			end=i;
			while(i>=0&&s.charAt(i)!=' ')
				i--;
			start=i;
			stringBuilder.append(s.substring(start+1, end+1)).append(' ');
		}
		String result="";
		if (stringBuilder.length()>0)
			result=stringBuilder.substring(0,stringBuilder.length()-1);
		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		
		String str=null;
		while((str=bufferedReader.readLine())!=null){
			System.out.println(reverseWords2(str)+"-");
		}
		bufferedReader.close();

	}

}
