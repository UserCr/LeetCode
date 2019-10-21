package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q191_NumberOf1Bits implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n >>>= 1;
        }
        return count;
    }
}
