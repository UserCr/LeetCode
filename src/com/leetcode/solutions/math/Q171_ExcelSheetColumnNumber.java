package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q171_ExcelSheetColumnNumber implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int titleToNumber(String s) {
        int res = 0;
        for (char c : s.toCharArray()) {
            res = res * 26 + (c - 'A' + 1);
        }
        return res;
    }
}
