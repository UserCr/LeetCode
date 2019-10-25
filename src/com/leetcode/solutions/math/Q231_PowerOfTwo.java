package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q231_PowerOfTwo implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public boolean isPowerOfTwo(int n) {
        //不是32位，因为0x8000不是2的幂。
        final int BIT_SIZE = 31;
        for (int i = 0; i < BIT_SIZE; ++i) {
            if (n == 1 << i) {
                return true;
            }
        }
        return false;
    }
}
