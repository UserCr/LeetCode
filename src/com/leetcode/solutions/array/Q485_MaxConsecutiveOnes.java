package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

public class Q485_MaxConsecutiveOnes implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, curLength = 0;
        boolean isOne = nums[0] == 1;
        for (int num : nums) {
            if (num == 1) {
                if (!isOne) {
                    curLength = 0;
                }
                curLength++;
                res = Math.max(res, curLength);
                isOne = true;
            } else {
                isOne = false;
            }
        }
        return res;
    }
}
