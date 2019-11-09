package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q292_NimGame implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
