package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

public class Q53_MaximumSubarray implements SolutionInterface {
    @Override
    public void run() {
    }

    //DP基础水题。分治也可以做，思路非常简单，不过效率不如DP高。
    public int maxSubArray(int[] nums) {
        int sum = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(sum, max);
        }
        return max;
    }
}
