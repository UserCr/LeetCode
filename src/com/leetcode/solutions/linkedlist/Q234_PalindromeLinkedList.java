package com.leetcode.solutions.linkedlist;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.ListNode;

public class Q234_PalindromeLinkedList implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public boolean isPalindrome(ListNode head) {
        int length = lengthOfList(head);
        ListNode anotherHead = head;
        for (int i = 0; i < length / 2; ++i) {
            anotherHead = anotherHead.next;
        }
        anotherHead = reverseList(anotherHead);
        while (head != null && anotherHead != null) {
            if (head.val != anotherHead.val) {
                return false;
            }
            head = head.next;
            anotherHead = anotherHead.next;
        }
        return true;
    }

    private int lengthOfList(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        for (ListNode cur = head, next; cur != null; cur = next) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
        }
        return prev;
    }
}
