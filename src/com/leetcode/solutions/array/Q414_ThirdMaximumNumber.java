package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

public class Q414_ThirdMaximumNumber implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int thirdMax(int[] nums) {
        int max1 = nums[0], max2 = nums[0], max3 = nums[0];
        for (int num : nums) {
            if (num < nums[0]) {
                max1 = num;
                max2 = num;
                max3 = num;
            }
        }
        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num < max1 && num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num < max2 && num > max3) {
                max3 = num;
            }
        }
        if (max1 > max2 && max2 > max3) {
            return max3;
        } else {
            return max1;
        }
    }
}
