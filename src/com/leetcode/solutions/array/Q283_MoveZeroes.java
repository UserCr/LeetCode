package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

public class Q283_MoveZeroes implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public void moveZeroes(int[] nums) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            while (slow < nums.length && nums[slow] != 0) {
                slow++;
            }
            fast = slow + 1;
            while (fast < nums.length && nums[fast] == 0) {
                fast++;
            }
            if (fast < nums.length) {
                nums[slow] = nums[fast];
                nums[fast] = 0;
            }
        }
    }
}
