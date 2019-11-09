package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

public class Q238_ProductOfArrayExceptSelf implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            res[i] = res[i - 1] * nums[i];
        }
        int product = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            res[i] = res[i - 1] * product;
            product *= nums[i];
        }
        res[0] = product;
        return res;
    }
}
