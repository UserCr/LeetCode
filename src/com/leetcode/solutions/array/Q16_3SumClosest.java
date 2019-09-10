package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

import java.util.Arrays;

public class Q16_3SumClosest implements SolutionInterface {
    @Override
    public void run() {
    }

    //3Sum变体。问题不在乎重复解，因此可以不必优化。
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; ++i) {
            int m = i + 1, n = nums.length - 1;
            while (m < n) {
                if (Math.abs(nums[i] + nums[m] + nums[n] - target) < Math.abs(sum - target)) {
                    sum = nums[i] + nums[m] + nums[n];
                }
                if (nums[i] + nums[m] + nums[n] < target) {
                    m++;
                } else if (nums[i] + nums[m] + nums[n] > target) {
                    n--;
                } else {
                    return target;
                }
            }
        }
        return sum;
    }
}
