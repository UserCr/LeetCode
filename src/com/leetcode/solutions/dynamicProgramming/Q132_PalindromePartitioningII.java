package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

public class Q132_PalindromePartitioningII implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 有一定难度，主要是回文串判断不太容易和DP联系起来，算法易于理解，需要复习记忆。
     * DP[i]指的是长度为i的字符串的剪切数，注意DP[0]必须是-1,否则aba这种case会出错。
     */
    public int minCut(String s) {
        int[] dp = new int[s.length() + 1];
        for (int i = 0; i <= s.length(); ++i) {
            dp[i] = i - 1;
        }

        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; i - j >= 0 && i + j < s.length() && s.charAt(i - j) == s.charAt(i + j); ++j) {
                dp[i + j + 1] = Math.min(dp[i + j + 1], 1 + dp[i - j]);
            }
            for (int j = 1; i - j + 1 >= 0 && i + j < s.length() && s.charAt(i - j + 1) == s.charAt(i + j); ++j) {
                dp[i + j + 1] = Math.min(dp[i + j + 1], 1 + dp[i - j + 1]);
            }
        }

        return dp[s.length()];
    }
}
