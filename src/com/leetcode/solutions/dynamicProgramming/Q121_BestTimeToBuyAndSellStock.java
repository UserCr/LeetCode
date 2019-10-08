package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

public class Q121_BestTimeToBuyAndSellStock implements SolutionInterface {
    private interface Algorithm {
        int maxProfit(int[] prices);
    }

    @Override
    public void run() {
    }

    static class Straightforward implements Algorithm {
        //直接法，第i天能得到的最大利润=第i天的价格-第i天之前的最低价，如果第i天最大利润大于已知最大利润就更新已知最大利润
        @Override
        public int maxProfit(int[] prices) {
            if (prices.length <= 1) {
                return 0;
            }

            int min = prices[0], profit = 0;
            for (int i = 1; i < prices.length; ++i) {
                if (min > prices[i]) {
                    min = prices[i];
                } else if (prices[i] - min > profit) {
                    profit = prices[i] - min;
                }
            }
            return profit;
        }
    }

    static class DP implements Algorithm {
//        public int maxProfitDPStraightForward(int[] prices) {
//            //DP。最直观的DP解法，该解法不断优化就会变成直接法。
//            //profit是三种状态下所持有的现金，第0天的初始持有现金是0元。
//            if (prices.length < 2) return 0;
//            final int NOT_HOLD = 0, HOLD = 1, FINISH = 2;
//            int[][] profit = new int[prices.length][3];
//            profit[0][NOT_HOLD] = 0;
//            profit[0][HOLD] = 0 - prices[0];
//            profit[0][FINISH] = 0;
//            for (int i = 1; i < prices.length; ++i) {
//                //结合之后寻找最大值的代码看，FINISH状态只需要保存一个最大值即可，其他都是不必保存的。
//                profit[i][FINISH] = profit[i - 1][HOLD] + prices[i];
//                //HOLD状态的改变只和前一天的状态有关，再之前的状态都不用再继续存储，所以可以将数组优化成常数个变量
//                profit[i][HOLD] = Math.max(profit[i - 1][HOLD], profit[i - 1][NOT_HOLD] - prices[i]);
//                //NOT_HOLD状态永远是0，所以它是没有必要的，可以优化掉。
//                profit[i][NOT_HOLD] = profit[i - 1][NOT_HOLD];
//            }
//            int max = 0;
//            for (int[] ints : profit) {
//                if (ints[FINISH] > max) {
//                    max = ints[FINISH];
//                }
//            }
//            return max;
//        }

        /***
         * DP。上述DP优化后的DP解法。
         * 可以发现，hold就是直接法中的min的相反数，finish则是直接法中的profit。
         */
        public int maxProfit(int[] prices) {
            if (prices.length < 2) {
                return 0;
            }

            int hold = 0 - prices[0], finish = 0;
            for (int i = 1; i < prices.length; ++i) {
                if (finish < hold + prices[i]) {
                    finish = hold + prices[i];
                }
                hold = Math.max(hold, 0 - prices[i]);
            }
            return finish;
        }
    }
}
