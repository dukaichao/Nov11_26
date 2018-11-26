package cn.dkc.Nov_26;

import java.math.BigInteger;
import java.util.Scanner;

public class isPalindrome {
	public boolean ispalindrome(int x) {
       /* String s = x+"";
        char[] buff = s.toCharArray();
        int start = 0;
        int end = buff.length - 1;
        while(start<end){
            if(buff[end] == buff[start]){
                end--;
                start++;
            }else
                return false;
        }
        return true;   */
		if(x<0||x%10 == 0&&x!=0)
			return false;
		int sum = 0;
		while(x>sum) {
			sum = sum * 10 + x % 10;
			x = x / 10;
		}
		System.out.println(x);
		System.out.println(sum);
		return sum == x||x == sum/10;
    }
	public static void main(String[] args) {
		System.out.println("请输入:>");
		Scanner s = new Scanner(System.in);
		System.out.println(new isPalindrome().ispalindrome(s.nextInt()));
	}
}
