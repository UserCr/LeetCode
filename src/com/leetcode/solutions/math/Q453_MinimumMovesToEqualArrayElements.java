package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q453_MinimumMovesToEqualArrayElements implements SolutionInterface {
    @Override
    public void run() {
    }

    //无聊的数学题。记初始和为S0，求解后的和为S，元素个数为n，解为k步，最小元素为Min。
    //S = S0 + (n-1) * k = (k + Min) * n
    public int minMoves(int[] nums) {
        int min = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (min > num) {
                min = num;
            }
        }
        return sum - nums.length * min;
    }
}
