package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

public class Q80_RemoveDuplicatesFromSortedArrayII implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int slow = 2, fast = 2;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow - 1] || nums[fast] != nums[slow - 2]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}
