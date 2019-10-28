package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q268_MissingNumber implements SolutionInterface {
    @Override
    public void run() {
    }

    /**
     * 水题，总和减数列和方法容易想到，有一点难度的是异或方法。
     * 由异或运算性质可知:(0 XOR 1 XOR ... XOR n) XOR (0 XOR 1 XOR ... XOR j - 1 XOR j + 1 XOR ... XOR n) = j
     */
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }
}
