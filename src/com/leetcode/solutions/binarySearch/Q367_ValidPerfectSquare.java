package com.leetcode.solutions.binarySearch;

import com.leetcode.solutions.SolutionInterface;

public class Q367_ValidPerfectSquare implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题，注意溢出。
    public boolean isPerfectSquare(int num) {
        for (int left = 1, right = 65535; left <= right; ) {
            int mid = (left + right) / 2;
            long temp = (long) mid * mid;
            if (temp > num) {
                right = mid - 1;
            } else if (temp < num) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return 1 == num;
    }
}
