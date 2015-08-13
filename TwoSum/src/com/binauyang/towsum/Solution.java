package com.binauyang.towsum;

public class Solution {
	
	public static int[] twoSum(int[] nums, int target) {
		int[] indexs = new int[2];
		int length = nums.length;
		int smallerIndex;
		for (smallerIndex = 0; smallerIndex < length; smallerIndex++) {
			indexs[0] = smallerIndex + 1;
			int biggerIndex;
			if ((biggerIndex = findNum(nums, smallerIndex + 1, length, target - nums[smallerIndex])) != -1) {
				indexs[1] = biggerIndex + 1;
				break;
			}
		}
		if (smallerIndex == length) {
			return null;
		}
		return indexs;
	}
	
	public static int findNum(int[] nums, int start, int end, int target) {
		int index = 0;
		int i;
		for (i = start; i < end; i++) {
			if (nums[i] == target) {
				index = i;
				break;
			}
		}
		if (i == end) {
			return -1;
		}
		return index;
	}
}
