package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

public class Q198_HouseRobber implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int rob(int[] nums) {
        if (0 == nums.length) {
            return 0;
        }
        int robMaxMoney = nums[0], notRobMaxMoney = 0;
        for (int i = 1; i < nums.length; ++i) {
            int temp = robMaxMoney;
            robMaxMoney = Math.max(robMaxMoney, notRobMaxMoney + nums[i]);
            notRobMaxMoney = Math.max(notRobMaxMoney, temp);
        }
        return Math.max(robMaxMoney, notRobMaxMoney);
    }
}
