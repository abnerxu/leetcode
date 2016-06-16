package edu.fudan.string;

import java.util.Scanner;

/**
 * Multiply Strings
 * 
 * 
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * 
 * Note:
 * 
 * The numbers can be arbitrarily large and are non-negative.
 * Converting the input string to integer is NOT allowed.
 * You should NOT use internal library such as BigInteger.
 * 
 * @author abner
 *
 */
public class No43 {
	
	private final static int size=4;
	
	public static String multiply(String num1, String num2) {
        int len =Math.max(num1.length(), num2.length());
        return bigIntMultiply(num1, num2, len);
    }
	
	public static String bigIntMultiply(String x,String y,int len){
		
		StringBuilder stringBuilder=new StringBuilder();
		
		//对齐x,y
		x=formatNum(len, x);
		y=formatNum(len,y);
		
		//小于等于4位的情况直接计算
		if(len<=size)
			return String.valueOf(Integer.parseInt(x)*Integer.parseInt(y));
		
		//大于的情况，划分计算
		int len1=len/2;
		int len2=len-len1;
		
		String A=x.substring(0, len1);
		String B=x.substring(len1);
		String C=y.substring(0, len1);
		String D=y.substring(len1);
		
		//分块计算
		int lenM=Math.max(len1, len2);
		String BD=bigIntMultiply(B, D,len2);
		String AD=bigIntMultiply(A, D, lenM);
		String BC=bigIntMultiply(B, C, lenM);
		String AC=bigIntMultiply(A, C, len1);
		
		//处理进位
		String[] sBD=dealCarry(BD, len2);
		
		String ADBC=strAddtion(AD, BC);
		
		if(!"0".equals(sBD[1]))
			ADBC=strAddtion(ADBC, sBD[1]);
		
		String[] sADBC=dealCarry(ADBC, lenM);
		
		AC=strAddtion(AC, sADBC[1]);		
		String tmp=stringBuilder.append(AC).append(sADBC[0]).append(sBD[0]).toString();
		int pos=tmp.length()-1;
		
		for (int i = 0; i < tmp.length(); i++) {
			if (tmp.charAt(i) != '0') {
				pos = i;
				break;
			}
		}
		return tmp.substring(pos);
	}
	
	/**
	 * 第1个为原位数字，第2个为进位
	 * @param tmpResult
	 * @param len
	 * @return
	 */
	private static String[] dealCarry(String tmpResult, int len) {
		// 初始化为，不进位
		String[] result = { tmpResult, "0" };
		
		if(tmpResult.length()>len){
			//大于需要进位
			int k=tmpResult.length()-len;
			result[0]=tmpResult.substring(k);
			result[1]=tmpResult.substring(0, k);
		}else if(tmpResult.length()<len){
			//小于需要对齐
			result[0]=formatNum(len, tmpResult);
		}
		
		return result;
	}
	
	/**
	 * solve the addition of two string
	 * @param x
	 * @param y
	 * @return
	 */
	private static String strAddtion(String x,String y){
		StringBuilder stringBuilder=new StringBuilder();
		
		int xLen=x.length();
		int yLen=y.length();
		
		//format two string to same length
		if(xLen>yLen){
			y=formatNum(xLen,y);
			yLen=xLen;
		}else{
			x=formatNum(yLen,x);
			xLen=yLen;
		}		
		//to store the carry
		int carry=0;
		for (int i = xLen-1; i >=0; i--) {
			int tmp=carry+Integer.parseInt(x.substring(i, i+1))+Integer.parseInt(y.substring(i, i+1));
			
			if(tmp>9){
				tmp-=10;
				carry=1;
			}else{
				carry=0;
			}
			
			stringBuilder.insert(0, tmp);
		}
		if (carry != 0)
			stringBuilder.insert(0, carry);

		return stringBuilder.toString();
	}
	
	
	/**
	 * format STR to LEN size by fill zero in front
	 * @param len
	 * @param str
	 * @return
	 */
	private static String formatNum(int len,String str){
		StringBuilder stringBuilder =new StringBuilder();
		int strLen=str.length();
		while(len>strLen){
			stringBuilder.append('0');
			strLen++;
		}		
		return stringBuilder.append(str).toString();
	}
	
	public static void main(String args[]) throws Exception{		
		Scanner scanner =new Scanner(System.in);		
		String x=scanner.next();
		String y=scanner.next();	
		scanner.close();		
		System.out.println(multiply(x, y));		
	}
	

}
