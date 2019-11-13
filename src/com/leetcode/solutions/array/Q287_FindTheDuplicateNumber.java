package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

public class Q287_FindTheDuplicateNumber implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 以下解法非常难想到，难点在于将问题和链表联系起来。
     * 可以将数组看成是数组链表，因为有重复的数，所以会有多个结点指向同一个结点，也就是说，数组链表中有环。
     * 问题至此转化为链表中确定环的起点问题。
     */
    public int findDuplicate(int[] nums) {
        int fast = nums[nums[0]], slow = nums[0];
        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }

        slow = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}
