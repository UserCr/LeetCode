package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q371_SumOfTwoIntegers implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int getSum(int a, int b) {
        int res = 0;
        final int BIT_WIDTH = 32;
        for (int c = 0, i = 0; i < BIT_WIDTH; ++i) {
            int aBit = (a & (1 << i)) >> i;
            int bBit = (b & (1 << i)) >> i;
            int x = aBit ^ bBit ^ c;
            c = aBit & bBit | aBit & c | bBit & c;
            res |= (x << i);
        }
        return res;
    }
}
