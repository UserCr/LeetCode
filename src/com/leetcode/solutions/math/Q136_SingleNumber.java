package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q136_SingleNumber implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 容易想到的做法是HashMap，算法非常简单，不做题解。
     * 异或算法用到了异或运算的性质。1) a xor 0 = a, 2) a xor a = 0 3) a xor b xor a = a xor a xor b = b
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
