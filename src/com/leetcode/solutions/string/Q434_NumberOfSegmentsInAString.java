package com.leetcode.solutions.string;

import com.leetcode.solutions.SolutionInterface;

public class Q434_NumberOfSegmentsInAString implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int countSegments(String s) {
        s = s.trim();
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (!Character.isSpaceChar(s.charAt(i)) &&
                    (i == s.length() - 1 || Character.isSpaceChar(s.charAt(i + 1)))) {
                res++;
            }
        }
        return res;
    }
}
