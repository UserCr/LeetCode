package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

public class Q72_EditDistance implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 转移方程比较难想，但是非常简单。
     * f(i, j)是长度为i的串s1和长度为j的串s2的编辑距离：
     * s1[i] == s2[j]时，显然f(i, j) = f(i - 1, j - 1)
     * s1[i] != s2[j]时，f(i, j) = 1 + min { f(i, j - 1), f(i - 1, j), f(i - 1, j - 1) }
     * 其中
     * f(i, j - 1) 代表需要插入一个字符
     * f(i - 1, j) 代表需要删除一个字符
     * f(i - 1, j - 1) 代表需要更新一个字符
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); ++i) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); ++i) {
            dp[0][i] = i;
        }

        for (int i = 0; i < word1.length(); ++i) {
            for (int j = 0; j < word2.length(); ++j) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i][j + 1], dp[i + 1][j])) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
