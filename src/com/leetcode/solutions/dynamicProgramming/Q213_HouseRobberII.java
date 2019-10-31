package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

public class Q213_HouseRobberII implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int rob(int[] nums) {
        if (0 == nums.length) {
            return 0;
        }
        int firstDayRobMoney = nums[0] + rob(nums, 2, nums.length - 2);
        int firstDayNotRobMoney = rob(nums, 1, nums.length - 1);
        return Math.max(firstDayNotRobMoney, firstDayRobMoney);
    }

    private int rob(int[] nums, int startPos, int endPos) {
        if (startPos > endPos) {
            return 0;
        }
        int notRobMaxMoney = 0;
        int robMaxMoney = nums[startPos];
        for (int i = startPos + 1; i <= endPos; ++i) {
            int temp = robMaxMoney;
            robMaxMoney = Math.max(robMaxMoney, notRobMaxMoney + nums[i]);
            notRobMaxMoney = Math.max(notRobMaxMoney, temp);
        }
        return Math.max(notRobMaxMoney, robMaxMoney);
    }
}
