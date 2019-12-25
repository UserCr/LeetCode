package com.leetcode.solutions.greedy;

import com.leetcode.solutions.SolutionInterface;

import java.util.Arrays;

public class Q135_Candy implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 最简单的方法是模拟出给糖过程，分为两次遍历，分别检查左右两边来确定是否追加糖的数量。
     */
    public int candy(int[] ratings) {
        int[] num = new int[ratings.length];
        Arrays.fill(num, 1);

        for (int i = 1; i < ratings.length; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                num[i] = num[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; --i) {
            if (ratings[i] < ratings[i - 1]) {
                num[i - 1] = Math.max(num[i - 1], num[i] + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < ratings.length; ++i) {
            res += num[i];
        }
        return res;
    }
}
