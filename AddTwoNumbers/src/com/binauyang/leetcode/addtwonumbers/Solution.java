package com.binauyang.leetcode.addtwonumbers;

public class Solution {
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(8);
		ListNode l3 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;

		ListNode l4 = new ListNode(7);
		ListNode l5 = new ListNode(1);
//		ListNode l6 = new ListNode(4);
		l4.next = l5;
//		l5.next = l6;
		
		ListNode res = addTwoNumbers(l1, l4);
		ListNode l = res;
		while(null != l) {
			System.out.print(l.val);
			l = l.next;
			if (null != l) {
				System.out.print(" -> ");
			}
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (null == l1) {
			return l2;
		}
		if (null == l2) {
			return l1;
		}
		
		int length1 = getListLength(l1);
		int length2 = getListLength(l2);
		if (length1 != length2) {
			if (length1 > length2) {
				addExtraListNode(l2, length1 - length2);
			} else {
				addExtraListNode(l1, length2 - length1);
			}
		}
		
		int sum = l1.val + l2.val;
		int value = sum < 10 ? sum : sum - 10;
		int extra = sum < 10 ? 0 : 1;
		ListNode res = new ListNode(value);
		
		res.next = addTwoNumbers(l1.next, l2.next, extra);
		
		return res;
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2, int extra) {
		if (null == l1) {
			if (extra == 0) {
				return null;
			} else {
				return new ListNode(extra);
			}
		}
		
		int sum = l1.val + l2.val + extra;
		int value = sum < 10 ? sum : sum - 10;
		int extra2 = sum < 10 ? 0 : 1;
		ListNode res = new ListNode(value);
		res.next = addTwoNumbers(l1.next, l2.next, extra2);
		return res;
	}
	
	private static void addExtraListNode(ListNode node, int num) {
		ListNode p = node;
		while (p.next != null) {
			p = p.next;
		}
		for (int i = 0; i < num; i++) {
			p.next = new ListNode(0);
			p = p.next;
		}
	}
	
	private static int getListLength(ListNode node) {
		int length = 0;
		ListNode p = node;
		while (p != null) {
			length ++;
			p = p.next;
		}
		return length;
	}
}
