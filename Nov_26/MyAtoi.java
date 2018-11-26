package cn.dkc.Nov_26;

import java.math.BigInteger;
/*你来实现一个 atoi 函数，使其能将字符串转换成整数。

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，
作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0。

说明：

假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。
如果数值超过这个范围，qing返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。

示例 1:
输入: "42"
输出: 42

示例 2:
输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。

 示例 3:
 输入: "4193 with words"
 输出: 4193
 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 
 示例 4:
 输入: "words and 987"
 输出: 0
 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。   因此无法执行有效的转换。
 
 示例 5:
 输入: "-91283472332"
 输出: -2147483648
 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。 因此返回 INT_MIN (−2^31) 。*/
import java.util.Scanner;

public class MyAtoi {
	public int myAtoi(String str) {
		BigInteger bi = null;
		//删除开头空格
		String s = GiveUpKongGe(str);
		if(s.length() == 0)
			return 0;
	    //判断第一个字符，如果不是数字或者正负号返回false
		if(!isNumOrSign(s))
			return 0;
		//找到开头是数字后面不是数字的下标
		int t = isChar(s);
		System.out.println("t = "+t);
		if(t == -1) {
			bi = new BigInteger(s);
		}
		else {
			s = s.substring(0, t);
			bi = new BigInteger(s);
		}
		BigInteger bi1 = new BigInteger("2147483647");
	    BigInteger bi2 = new BigInteger("-2147483648");
	    if(bi.compareTo(bi1) == 1)
	    	return Integer.MAX_VALUE;
	    if(bi.compareTo(bi2) == -1)
	    	return Integer.MIN_VALUE;
		return bi.intValue();
	}
	//返回开头是数字后面出现第一个非数字的下标
	public int isChar(String s) {
		char[] buff = s.toCharArray();
		int start = 0;
		while(start<buff.length) {
			if(isNum(buff[start])||(buff[start] == '-'||buff[start]=='+')&&(start == 0)) {
				start++;
			}else {
				
				return start;
			}
		}
		return -1;
	}
	//丢弃开头是空格
	public String GiveUpKongGe(String s) {
		char[] buff = s.toCharArray();
		int start = 0;
		while(start < buff.length) {
			if(buff[start] == ' ')
				start++;
			else
				break;
		}
		return s.substring(start);
	}
	//判断开头是否是正负号或者数字
	public boolean isNumOrSign(String s) {
		char[] buff = s.toCharArray();
		if((buff[0]=='-'||buff[0]=='+')&&(buff.length == 1)||(buff[0] == '-'||buff[0]=='+')&&(!isNum(buff[1])))
			return false;
		if(isNum(buff[0])||buff[0] == '-'||buff[0] == '+')
			return true;
		return false;
	}
	public boolean isNum(char c) {
		if(('0'<=c&&c<=9+'0'))
			return true;
		return false;
	}
	public static void main(String[] args) {
		System.out.println("请输入字符串:>");
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		System.out.println(new MyAtoi().myAtoi(str));
	}
	
}
