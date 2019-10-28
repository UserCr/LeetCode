package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q263_UglyNumber implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }

        while (0 == num % 2) {
            num /= 2;
        }
        while (0 == num % 3) {
            num /= 3;
        }
        while (0 == num % 5) {
            num /= 5;
        }
        return 1 == num;
    }
}
