package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

public class Q26_RemoveDuplicatesFromSortedArray implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            while (fast < nums.length && nums[fast] == nums[slow]) {
                fast++;
            }
            if (fast < nums.length) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
