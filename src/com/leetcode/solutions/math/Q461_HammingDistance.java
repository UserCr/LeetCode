package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q461_HammingDistance implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int hammingDistance(int x, int y) {
        int res = 0;
        while ((x ^ y) != 0) {
            res += ((x ^ y) & 1);
            x >>>= 1;
            y >>>= 1;
        }
        return res;
    }
}
