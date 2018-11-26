package cn.dkc.Nov_26;
import java.math.BigInteger;
/*给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321


注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。
[-2147483648,2147483647]
请根据这个假设，如果反转后整数溢出那么就返回 0。

这个方法我们用的是BigInteger类和String类结合做的  个人觉得比较麻烦
*/
import java.util.Scanner;

public class reserveNum {
	
	public int reverse(int x) {
		String s = (String) (x+"");;
		if(x<0) {
			s = s.substring(1);
		}
        char[] buff = s.toCharArray();
        int start = 0;
        int end = buff.length - 1;
        while(start<end) {
        	char temp = buff[start];
        	buff[start] = buff[end];
        	buff[end] = temp;
        	start++;
        	end--;
        }
        BigInteger bi1 = new BigInteger("2147483647");
        BigInteger bi2 = new BigInteger("-2147483648");
        if(x>0){
        	BigInteger bi = new BigInteger(new String(buff));
        	if(bi.compareTo(bi1)==1)
        		return 0;
        	return bi.intValue();
        }
        else {
        	BigInteger bi = new BigInteger(new String("-")+new String(buff));
        	if(bi.compareTo(bi2)==-1)
        		return 0;
        	return bi.intValue();
        }	
    }
	public static void main(String[] args) {
		System.out.println("请输入:>");
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		System.out.println(new reserveNum().reverse(x));
		
	}
}
