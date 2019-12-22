package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

public class Q115_DistinctSubsequences implements SolutionInterface {
    @Override
    public void run() {
    }

    //思路和Q97相近，水题。
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i <= t.length(); ++i) {
            for (int j = 0; j <= s.length(); ++j) {
                if (0 == i) {
                    dp[i][j] = 1;
                } else if (0 == j) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j - 1];
                    if (t.charAt(i - 1) == s.charAt(j - 1)) {
                        dp[i][j] += dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
