package com.leetcode.solutions.linkedlist;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.ListNode;

public class Q142_LinkedListCycleII implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 难点在于证明算法正确性。
     * 假设非环部分长度是L，环部分长度是C。slow与fast相遇处相对于环起点长度是X，则slow走了L + X + N1 * C步，
     * fast走了2(L + X + N1 * C)步，且满足2(L + X + N1 * C) - (L + X + N1 * C) = N2 * C，其中N1，N2都是正整数。
     * 因此有 L + X = (N2 - N1) * C， 也就是说L + X等于整数倍的环长，现在slow和fast已经处在X处，
     * 当fast和head一起走L步后，两者就会在环起点处相遇。
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (null != fast) {
            fast = fast.next;
            if (null == fast) {
                return null;
            }
            fast = fast.next;
            slow = slow.next;

            if (null != fast && fast == slow) {
                break;
            }
        }
        while (null != fast && fast != head) {
            head = head.next;
            fast = fast.next;
        }
        return fast;
    }
}
