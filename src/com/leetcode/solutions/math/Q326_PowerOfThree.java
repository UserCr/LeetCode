package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q326_PowerOfThree implements SolutionInterface {
    @Override
    public void run() {
    }

    //无聊的水题。1162261467是整型数中3的最大幂。
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
