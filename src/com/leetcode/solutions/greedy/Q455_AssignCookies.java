package com.leetcode.solutions.greedy;

import com.leetcode.solutions.SolutionInterface;

import java.util.Arrays;

public class Q455_AssignCookies implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int sPos = 0, gPos = 0;
        while (sPos < s.length && gPos < g.length) {
            if (s[sPos] >= g[gPos]) {
                gPos++;
                res++;
            }
            sPos++;
        }
        return res;
    }
}
