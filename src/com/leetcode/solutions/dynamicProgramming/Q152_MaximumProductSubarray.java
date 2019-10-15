package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

public class Q152_MaximumProductSubarray implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 有难度的DP题。维护到当前位置的最大乘积和最小乘积，num[i] < 0 会导致小的乘积变大，大的乘积变小，所以要互换位置。
     * 当前位置的最大（小）值不是当前值就是累积乘积。
     * 这个算法比较难理解，需要多写几种情况的样例，挨个看一遍会容易理解一些。
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxProduct = nums[0], maxProductCur = nums[0], minProductCur = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < 0) {
                int temp = maxProductCur;
                maxProductCur = minProductCur;
                minProductCur = temp;
            }

            maxProductCur = Math.max(nums[i], maxProductCur * nums[i]);
            minProductCur = Math.min(nums[i], minProductCur * nums[i]);

            maxProduct = Math.max(maxProduct, maxProductCur);
        }
        return maxProduct;
    }
}
