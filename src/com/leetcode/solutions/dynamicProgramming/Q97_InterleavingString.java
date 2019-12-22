package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

public class Q97_InterleavingString implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 状态转移方程有一定难度，但是易于理解。
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); ++i) {
            for (int j = 0; j <= s2.length(); ++j) {
                if (0 == i && 0 == j) {
                    dp[i][j] = true;
                } else {
                    char s3Char = s3.charAt(i + j - 1);
                    if (0 == i) {
                        dp[i][j] = dp[i][j - 1] && s3Char == s2.charAt(j - 1);
                    } else if (0 == j) {
                        dp[i][j] = dp[i - 1][j] && s3Char == s1.charAt(i - 1);
                    } else {
                        dp[i][j] = (dp[i - 1][j] && s3Char == s1.charAt(i - 1)) || (dp[i][j - 1] && s3Char == s2.charAt(j - 1));
                    }
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
