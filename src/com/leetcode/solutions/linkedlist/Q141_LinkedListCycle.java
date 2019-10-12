package com.leetcode.solutions.linkedlist;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.ListNode;

public class Q141_LinkedListCycle implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 水题。注意fast不用每走一步就和slow比较一次，可以一次走两步，若有环一定会相遇，具体证明如下：
     * 设环长度为m，结点下标分别是0, 1, 2, ..., m-1，当slow刚进入环，也就是slow在0处时，fast在p处，不妨设 0 <= p < m。
     * 当slow在环内走了k步时，fast在环内走了p+2k步。
     * 设k = Nm + 0, Nm + 1, Nm + 2, ..., Nm + m-1 (k是正整数)， 则
     * p + 2k = 2Nm + 0 + p, 2Nm + 2 + p, 2Nm + 4 + p, ..., 2Nm + 2(m-1) + p。
     * 此时slow的位置在 0, 1, 2, ..., m-1，fast的位置在 p % m, (p + 2) % m, (p + 4) % m, ..., (p + 2(m-1)) % m。
     * p = 0时， p % m = 0,
     * p = m - 1时， (p + 2) % m = 1,
     * p = m - 2时， (p + 4) % m = 2,
     * ...,
     * p = 1时， (p + 2(m - 1)) % m = m - 1,
     * 所以无论p在哪里，在slow前进若干步后，都有slow和fast位置相同的解，所以一定相遇。
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (null != fast) {
            fast = fast.next;
            if (null == fast) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;

            if (null != fast && fast == slow) {
                return true;
            }
        }
        return false;
    }
}
