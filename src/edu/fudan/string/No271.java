package edu.fudan.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Encode and Decode Strings 
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
 * 
 * Machine 1 (sender) has the function:
 * string encode(vector<string> strs) {
 *   // ... your code
 *    return encoded_string;
 * }
 * 
 * Machine 2 (receiver) has the function:
 * vector<string> decode(string s) {
 *   //... your code
 *    return strs;
 * }
 *    
 * So Machine 1 does:
 * string encoded_string = encode(strs);
 * 
 * and Machine 2 does:
 * vector<string> strs2 = decode(encoded_string);
 * strs2 in Machine 2 should be the same as strs in Machine 1.
 * Implement the encode and decode methods.
 * Note:
 * The string may contain any possible characters out of 256 valid ascii characters. 
 * Your algorithm should be generalized enough to work on any possible characters.
 * Do not use class member/global/static variables to store states. 
 * Your encode and decode algorithms should be stateless.
 * Do not rely on any library method such as eval or serialize methods. 
 * You should implement your own encode/decode algorithm.
 * 
 * http://www.cnblogs.com/easonliu/p/4784912.html
 * 
 * {“abc”，“123”，“d"} -> 3#abc3#1231#d  ：res += to_string(str.length()) + "#" + str;
 * 
 * @author abner
 *
 */
public class No271 {
	
	//编码方式：长度#字符串
	 public static String encode(List<String> strs) {
		 StringBuilder stringBuilder=new StringBuilder();
		for (String str : strs)
			stringBuilder.append(str.length() + "#").append(str);
		 return stringBuilder.toString();
	 }
	 
	 public static List<String> decode(String s) {
		 List<String>result=new ArrayList<>();
		 int start=0;
		 while(start<s.length()){
			 int index=s.indexOf('#', start);
			 int size=Integer.parseInt(s.substring(start, index));
			 result.add(s.substring(index+1, index+size+1));
			 start=index+size+1;
		 }		 
		 return result;
	 }
	 
	
	public static void main(String args[]) throws Exception{
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		
		String str=null;
		List<String> input=new ArrayList<>();
		while((str=bufferedReader.readLine())!=null){
			input.add(str);
		}
		bufferedReader.close();
		
		List<String> result=decode(encode(input));
		for (int i = 0; i < result.size(); i++) {
			System.out.println(input.get(i).equals(result.get(i)));
		}
	}

}
