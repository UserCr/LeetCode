package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

public class Q188_BestTimeToBuyAndSellStockIV implements SolutionInterface {
    @Override
    public void run() {
    }

    //Best Time to Buy and Sell Stock III代码稍经修改后的版本，只需注意k过大时可能会导致MLE。
    public int maxProfit(int k, int[] prices) {
        if (k < 1 || prices.length < 2) return 0;
        if (k > prices.length / 2) {
            //一笔交易至少需要两天，所以x天至多只能完成x/2笔交易。
            //k的输入值可能远大于实际可交易笔数的上限，不修改的话会MLE
            k = prices.length / 2;
        }
        int[] notHold = new int[k + 1], hold = new int[k];
        for (int i = 0; i < hold.length; ++i) {
            hold[i] = 0 - prices[0];
        }
        for (int i = 1; i < prices.length; ++i) {
            hold[0] = Math.max(hold[0], notHold[0] - prices[i]);
            for (int j = 1; j < k; ++j) {
                notHold[j] = Math.max(notHold[j], hold[j - 1] + prices[i]);
                hold[j] = Math.max(hold[j], notHold[j] - prices[i]);
            }
            notHold[k] = Math.max(notHold[k], hold[k - 1] + prices[i]);
        }
        return notHold[k];
    }
}
