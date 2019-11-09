package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q264_UglyNumberII implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 用SortedSet是容易的，但是效率不高。使用数组实现的方法易于理解，但不太好想，需要专门复习。
     */
    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int uglyNumber = Math.min(uglyNumbers[i2] * 2, Math.min(uglyNumbers[i3] * 3, uglyNumbers[i5] * 5));
            uglyNumbers[i] = uglyNumber;
            if (uglyNumbers[i2] * 2 == uglyNumber) {
                i2++;
            }
            if (uglyNumbers[i3] * 3 == uglyNumber) {
                i3++;
            }
            if (uglyNumbers[i5] * 5 == uglyNumber) {
                i5++;
            }
        }
        return uglyNumbers[uglyNumbers.length - 1];
    }
}
