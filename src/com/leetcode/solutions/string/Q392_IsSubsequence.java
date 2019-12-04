package com.leetcode.solutions.string;

import com.leetcode.solutions.SolutionInterface;

public class Q392_IsSubsequence implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public boolean isSubsequence(String s, String t) {
        int tPos = -1;
        for (char c : s.toCharArray()) {
            tPos = t.indexOf(c, tPos + 1);
            if (-1 == tPos) {
                return false;
            }
        }
        return true;
    }
}
