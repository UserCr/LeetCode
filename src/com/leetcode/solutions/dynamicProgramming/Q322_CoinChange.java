package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

public class Q322_CoinChange implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 经典题目，必须熟练掌握。
     */
    public int coinChange(int[] coins, int amount) {
        if (0 >= amount) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; ++i) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] >= 0 && dp[i - coin] < min) {
                    min = dp[i - coin];
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min + 1;
        }
        return dp[amount];
    }
}
