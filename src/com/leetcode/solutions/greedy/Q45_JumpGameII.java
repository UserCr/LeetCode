package com.leetcode.solutions.greedy;

import com.leetcode.solutions.SolutionInterface;

public class Q45_JumpGameII implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 贪心算法，有一定难度。代码易于理解，只是JumpGame思路的改造。
     * 注意最后一个位置要忽略掉，因为题目保证有解，所以考虑最后一个位置的话会多算一步。
     * 这种情况不能用res-1去解决，否则[2,1]这样case会算错。
     */
    public int jump(int[] nums) {
        int res = 0;
        for (int i = 0, curFarthest = 0, curEnd = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (curEnd == i) {
                res++;
                curEnd = curFarthest;
            }
        }
        return res;
    }
}
