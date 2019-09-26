package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

public class Q70_ClimbingStairs implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int climbStairs(int n) {
        if (1 == n) return 1;
        if (2 == n) return 2;
        int small = 1, big = 2;//题目中返回int，因此不需要考虑溢出的问题。
        for (int i = 3; i <= n; ++i) {
            int cur = small + big;
            small = big;
            big = cur;
        }
        return big;
    }
}
