package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q190_ReverseBits implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int reverseBits(int n) {
        final int BIT_SIZE = 32;
        int res = 0;
        for (int i = 0; i < BIT_SIZE; ++i) {
            res |= (((n >> i) & 1) << (BIT_SIZE - i - 1));
        }
        return res;
    }
}
