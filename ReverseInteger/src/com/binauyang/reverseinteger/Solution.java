package com.binauyang.reverseinteger;

public class Solution {
	public static void main(String[] args) {
		System.out.println(reverse(-2147483648));
	}
	
	public static int reverse(int x) {
		int res = 0;
		boolean isLessThanZero = (x >= 0) ? false : true;
		long absX = Math.abs((long) x);
		while(absX != 0) {
			long longRes = (long) res * 10 + absX % 10;
			if (longRes > Integer.MAX_VALUE) {
				res = 0;
				break;
			} else {
				res = (int) longRes;
			}
			absX = absX / 10;
		}
		if (isLessThanZero) {
			res = -res;
		}
		return res;
	}
}
