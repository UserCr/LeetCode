package com.leetcode.solutions.linkedlist;

import com.leetcode.CommonPrint;
import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.ListNode;

public class Q2_AddTwoNumbers implements SolutionInterface {
    @Override
    public void run() {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        ListNode l2 = new ListNode(1);
        Solution solution = new Solution();
        CommonPrint.PrintLinkedList(solution.addTwoNumbers(l1, l2));
    }

    //链表加法，水题。

    class Solution {
        private boolean hasCarry(ListNode node) {
            if (node.val >= 10) {
                node.val %= 10;
                return true;
            } else {
                return false;
            }
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            boolean carry = false;
            ListNode head = new ListNode(0);
            ListNode tail = head;
            while (l1 != null && l2 != null) {
                ListNode temp = new ListNode(l1.val + l2.val);
                if (carry) {
                    temp.val++;
                }
                carry = hasCarry(temp);
                tail.next = temp;
                tail = tail.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            while (l1 != null) {
                ListNode temp = new ListNode(l1.val);
                if (carry) {
                    temp.val++;
                }
                carry = hasCarry(temp);
                tail.next = temp;
                tail = tail.next;
                l1 = l1.next;
            }
            while (l2 != null) {
                ListNode temp = new ListNode(l2.val);
                if (carry) {
                    temp.val++;
                }
                carry = hasCarry(temp);
                tail.next = temp;
                tail = tail.next;
                l2 = l2.next;
            }
            if (carry) {
                tail.next = new ListNode(1);
            }
            return head.next;
        }
    }
}
