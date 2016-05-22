package edu.fudan.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Problem:
 * Given a string, we can "shift" each of its letter to its successive , for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 * "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
 * Return:
 * [
 * ["abc","bcd","xyz"],
 * ["az","ba"],
 * ["acef"],
 * ["a","z"]
 * ]
 * @author abner
 * 
 * This problem is very easy.
 * The basic idea is to shift all words back into the form starting with 'a'. 
 * (all digits must shift the same distance). 
 * If the two words share the same shifted word, it means they actually come from the same shift group. 
 *
 * reference:http://www.cnblogs.com/airwindow/p/4806168.html
 */
public class NO249 {
	public static List<List<String>> groupStrings(String[] strings) {
		if(strings==null)
			throw new IllegalArgumentException("strings is null");
		
		List<List<String>> result=new ArrayList<>();
		
		if(strings.length == 0)
			return result;
		
		HashMap<String,List<String>> map =new HashMap<>();
		
		for (String str : strings) {
			String shiftStr=shiftStr(str);
			if(map.containsKey(shiftStr)){
				map.get(shiftStr).add(str);
			}else{
				ArrayList<String> item=new ArrayList<>();
				item.add(str);
				map.put(shiftStr, item);
				result.add(item);
			}
		}
		
		for (List<String> list : result) {
			Collections.sort(list);
		}
		return result;
	}
	
	public static void main(String args[]) throws Exception{
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		List<String> strings=new ArrayList<String>();
		String str=null;
		while((str=bufferedReader.readLine())!=null){
			strings.add(str);
		}
		bufferedReader.close();	
		
		List<List<String>> result=groupStrings(strings.toArray(new String[0]));
		for (List<String> list : result) {
			for (String string : list) {
				System.out.print(string+"\t");
			}
			System.out.println();
		}
	}
	
	public static String shiftStr(String str){
		StringBuilder stringBuilder=new StringBuilder();
		char[] charArrays=str.toCharArray();
		int dist=charArrays[0]-'a';
		for (char c : charArrays) {
			stringBuilder.append((c-'a'-dist+26)%26+'a');
		}		
		return stringBuilder.toString();
	}

}
