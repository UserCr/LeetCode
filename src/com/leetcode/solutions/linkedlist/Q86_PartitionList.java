package com.leetcode.solutions.linkedlist;

import com.leetcode.solutions.SolutionInterface;
import com.leetcode.solutions.commonDataStructure.ListNode;

public class Q86_PartitionList implements SolutionInterface {
    @Override
    public void run() {
    }

    //不分链的话有些难度，不太容易想出结果，一旦分链就变得十分简单。这个题目意义再于链表题目可以用分链法做，不要拘泥于单链内部交换。
    public ListNode partition(ListNode head, int x) {
        ListNode dummySmall = new ListNode(0);
        ListNode dummyBig = new ListNode(0);

        ListNode tailSmall = dummySmall, tailBig = dummyBig;

        for (ListNode cur = head, next; cur != null; cur = next) {
            next = cur.next;
            if (cur.val >= x) {
                tailBig.next = cur;
                tailBig = cur;
            } else {
                tailSmall.next = cur;
                tailSmall = cur;
            }
            cur.next = null;
        }

        tailSmall.next = dummyBig.next;

        return dummySmall.next;
    }
}
