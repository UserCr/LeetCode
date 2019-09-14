package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

public class Q27_RemoveElement implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            while (fast < nums.length && nums[fast] == val) {
                fast++;
            }
            if (fast < nums.length) {
                nums[slow++] = nums[fast++];
            }
        }
        return slow;
    }
}
