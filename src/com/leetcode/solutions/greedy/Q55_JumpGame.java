package com.leetcode.solutions.greedy;

import com.leetcode.solutions.SolutionInterface;

public class Q55_JumpGame implements SolutionInterface {
    @Override
    public void run() {
    }

    //贪心基础题。局部最优解是找当前已走过的数组可到达的最远位置。
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (farthest < i) {
                return false;
            }
            farthest = Math.max(farthest, i + nums[i]);
        }
        return true;
    }
}
