package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

public class Q122_BestTimeToBuyAndSellStockII implements SolutionInterface {
    private interface Algorithm {
        int maxProfit(int[] prices);
    }

    @Override
    public void run() {
    }

    static class Straightforward implements Algorithm {
        //直接法。每天的价格画在图表上就会形成一个上上下下的折线图，只要把所有比前一天价格高的差价都找出来求和就是解。
        @Override
        public int maxProfit(int[] prices) {
            int profit = 0;
            for (int i = 1; i < prices.length; ++i) {
                if (prices[i] >= prices[i - 1]) {
                    profit += (prices[i] - prices[i - 1]);
                }
            }
            return profit;
        }
    }

    static class DP implements Algorithm {
//        public int maxProfit(int[] prices) {
//            //DP。解法思路和BestTimeToBuyAndSellStock问题类似，不同的是这个题目允许多次买卖，所以finish状态可以去掉。
//            //最终结果是notHold，因为最后一天时股价要么比购买价高，可以卖出股票拿更多利润，要么比购买价低，干脆不要购买避免损失，
//            //最终都是不持有股票的状态。
//            if (prices.length < 2) return 0;
//            int notHold = 0, hold = 0 - prices[0];
//            for (int i = 1; i < prices.length; ++i) {
//                //这两个变量可以优化掉。
//                //hold的运算结果需要oldNotHold，而notHold的运算结果若为oldNotHold，自然可以进行优化，若结果为oldHold+prices[i]，
//                //那么hold的结果就是oldHold。这是因为两个最大值运算不可能同时取到右边或同时取到左边的结果，假如同时取到右边的结果，
//                //就说明oldNotHold < oldHold + prices[i]，oldHold < oldNotHold - prices[i]，两不等式相加得0 < 0，显然不成立，
//                //同理也不可能同时取到左边的结果。
//                int oldNotHold = notHold;
//                //hold是最后才发生变化的变量，所以old_hold是不必要的。
//                int oldHold = hold;
//                notHold = Math.max(oldNotHold, oldHold + prices[i]);
//                hold = Math.max(oldHold, oldNotHold - prices[i]);
//            }
//            return notHold;
//        }

        //DP。上述解法优化掉两个变量后的代码。
        @Override
        public int maxProfit(int[] prices) {
            if (prices.length < 2) {
                return 0;
            }

            int notHold = 0, hold = 0 - prices[0];
            for (int i = 1; i < prices.length; ++i) {
                notHold = Math.max(notHold, hold + prices[i]);
                hold = Math.max(hold, notHold - prices[i]);
            }
            return notHold;
        }
    }
}
