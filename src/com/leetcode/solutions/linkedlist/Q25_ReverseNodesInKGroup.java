package com.leetcode.solutions.linkedlist;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.ListNode;

public class Q25_ReverseNodesInKGroup implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (ListNode prev = dummy, end = head; prev.next != null; ) {
            int count = 0;
            while (count < k && end != null) {
                end = end.next;
                count++;
            }
            if (count < k) {
                break;
            } else {
                ListNode toReverseHead = prev.next;
                prev.next = reverseList(prev.next, end);
                toReverseHead.next = end;
                prev = toReverseHead;
            }
        }
        return dummy.next;
    }

    private ListNode reverseList(ListNode start, ListNode end) {
        ListNode prevNode = null;
        for (ListNode curNode = start, nextNode; curNode != end; curNode = curNode = nextNode) {
            nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
        }
        return prevNode;
    }
}
