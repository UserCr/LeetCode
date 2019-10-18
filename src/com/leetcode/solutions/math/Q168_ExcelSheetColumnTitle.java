package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q168_ExcelSheetColumnTitle implements SolutionInterface {
    @Override
    public void run() {
    }

    //基于1的26进制水题。注意平时的十进制是基于0的，所以算法中要做一些修改，修正偏移。
    public String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            stringBuilder.append((char) ((n - 1) % 26 + 'A'));
            n = (n - 1) / 26;
        }
        return stringBuilder.reverse().toString();
    }
}
