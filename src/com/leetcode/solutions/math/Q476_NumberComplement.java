package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q476_NumberComplement implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int findComplement(int num) {
        int res = 0, bit = 0;
        while (num != 0) {
            res |= (1 - (num & 1) << bit);
            bit++;
            num >>>= 1;
        }
        return res;
    }
}
