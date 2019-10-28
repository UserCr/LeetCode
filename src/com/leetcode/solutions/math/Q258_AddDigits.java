package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q258_AddDigits implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。Math方法需要观察出结果是循环的。
    public int addDigits(int num) {
        if (0 == num) {
            return 0;
        } else if (0 == num % 9) {
            return 9;
        } else {
            return num % 9;
        }
    }
}
