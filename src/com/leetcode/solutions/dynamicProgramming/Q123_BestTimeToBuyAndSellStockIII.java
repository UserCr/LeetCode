package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

public class Q123_BestTimeToBuyAndSellStockIII implements SolutionInterface {
    @Override
    public void run() {
    }

    //DP水题。
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        //notHold[i]为已经完成i次交易后不持有股票时的现金数,其中notHold[0]始终为0。hold[i]为已完成i次交易后持有股票时的现金数
        int[] notHold = new int[3], hold = new int[2];
        hold[0] = hold[1] = 0 - prices[0];
        for (int i = 1; i < prices.length; ++i) {
            hold[0] = Math.max(hold[0], notHold[0] - prices[i]);
            //若题目要求最多i次交易，中间若干次交易状态可以改成循环的形式，这也就是Best Time to Buy and Sell Stock IV的代码原型
            notHold[1] = Math.max(notHold[1], hold[0] + prices[i]);
            hold[1] = Math.max(hold[1], notHold[1] - prices[i]);
            notHold[2] = Math.max(notHold[2], hold[1] + prices[i]);
        }
        return notHold[2];
    }
}
