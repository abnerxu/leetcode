package edu.fudan.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. 
 * If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
 * You are responsible to gather all the input requirements up front.
 * 
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned. 
 * If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 *
 * 
 * @author abner
 *
 */
public class No8 {
	
	/**
	 * 1.illegal("" or null or the first sequence of non-whitespace characters in str is not a valid integral number...) return 0
	 * 2.out of range return INT_MAX (2147483647) or INT_MIN (-2147483648)
	 * 3.string can contain additional characters after those that form the integral number ignored
	 * 
	 * - 123 	r=0
	 * -qwwe123 r=0
	 * -1 2 3   r=-1
	 * @param str
	 * @return
	 */
	public static int myAtoi(String str) {
		//存储返回的结果
		long result = 0;
		
		//传入的数的正负
		boolean isPositive=false;		
		//1.如果传入空串，返回0
		if (str == null)
			return 0;
		
		//判断正负
		char[] cArray = str.trim().toCharArray();
		//判断是否为空
		if(cArray.length<=0)
			return 0;
		if(cArray[0]=='-'){
			isPositive=false;
			cArray[0]='0';
		}else if(cArray[0]=='+'||Character.isDigit(cArray[0])){
			isPositive=true;
			if(cArray[0]=='+')
				cArray[0]='0';
		}else{
			return 0;
		}
		
		List<Character> list=new ArrayList<>();
		
		for (int i = 0; i < cArray.length; i++) {
			if (Character.isDigit(cArray[i])){
				list.add(cArray[i]);
			}else{
				break;
			}
		}
		
		int factor = 1;
		for (int i = list.size() - 1; i >= 0; i--) {
			result += (long) Math.pow(10, factor-1)* (list.get(i)- '0');
			if (isPositive) {
				if (result >= Integer.MAX_VALUE)
					return Integer.MAX_VALUE;
			} else {
				if (-1*result <=Integer.MIN_VALUE)
					return Integer.MIN_VALUE;
			}
			factor++;
		}
		if (!isPositive)
			result *= -1;
		return (int)result;
	}
	
	
	public static void main(String args[]) throws Exception{
		System.out.println(Long.MAX_VALUE);
		BufferedReader bufferReader=new BufferedReader(new InputStreamReader(System.in));		
		String str=null;
		while((str=bufferReader.readLine())!=null){
			System.out.println(myAtoi(str));
		}
		bufferReader.close();		
	}
}
