package edu.fudan.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters. * 
 * For example, Given s = ¡°eceba¡±, 
 * T is "ece" which its length is 3. 
 * 
 * @author abner 
 * reference:http://blog.csdn.net/whuwangyi/article/details/42451289
 *
 */
public class No340and159 {
	
	
	/**
	 * map<Character,Integer>  key£ºcharacter value:count
	 * @param s
	 * @param k
	 * @return
	 * 
	 * O(N)
	 */
	public static int lengthOfLongestSubstringKDistinct(String s, int k) { 
		int start=0;
		int maxLen=0;
		
		Map<Character,Integer> slidingWindow=new HashMap<>();
		
		for (int i = 0; i < s.length(); i++) {
			char c=s.charAt(i);
			// when c is already existed,just increment the count
			if(slidingWindow.containsKey(c)){
				slidingWindow.put(c, slidingWindow.get(c)+1);
			}else{
				slidingWindow.put(c, 1);
				
				//when the size of slidingWindow exceeds k,delete the c orderly one by one
				while(slidingWindow.size()>k){
					char tmp=s.charAt(start++);
					int count=slidingWindow.get(tmp);
					if(count<=1){
						slidingWindow.remove(tmp);
					}else{
						slidingWindow.put(tmp, count-1);
					}
				}
			}
			maxLen=Math.max(maxLen, i-start+1);
		}
		return maxLen;
	}
	
	/**
	 * sliding window : map<Character,Integer>  key£ºcharacter value:position
	 * delete the most left character which appeared last.
	 * should find the new start position every time.
	 * O(N*K)
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstringTwoDistinct(String s){
		int startPos=0;
		int maxLen=0;
		
		Map<Character,Integer> slidingWindow=new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char tmp=s.charAt(i);
			//when current slidingWindow at least has two different character and TMP is a new character
			if(slidingWindow.size()>=2&&!slidingWindow.containsKey(tmp)){
				//find the most left character in the slidingWindow
				char mostLeftChar=findMostLeftPos(slidingWindow,s);				
				//get the position of the most left character in the slidingWindow
				int mostLeftPos=slidingWindow.get(mostLeftChar);
				//remove the opposite character
				slidingWindow.remove(mostLeftChar);				
				//update startPos
				startPos=mostLeftPos+1;
			}
			//when there is less than two different character or TMP is not a new character
			//put a new character or update the last position of the existed character
			slidingWindow.put(tmp, i);
			//update the value of MAXLEN
			maxLen=Math.max(maxLen, i-startPos+1);
		}
		
		return maxLen;
	}
	
	private static char findMostLeftPos(Map<Character,Integer> map,String s){
		char result=' ';
		int pos=s.length();
		for (char c : map.keySet()) {
			if(map.get(c)<pos){
				result=c;
				pos=map.get(c);
			}
		}
		return result;
	}
	
	public static void main(String args[]) throws Exception{
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		String str=null;		
		while((str=bufferedReader.readLine())!=null){
			System.out.println(lengthOfLongestSubstringKDistinct(str, 2));
			//System.out.println(lengthOfLongestSubstringTwoDistinct(str));
		}
		bufferedReader.close();
	}
}
