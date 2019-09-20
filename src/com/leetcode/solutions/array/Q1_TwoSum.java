package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

import java.util.HashMap;

public class Q1_TwoSum implements SolutionInterface {
    @Override
    public void run() {
    }

    //HashMap简单应用，水题。
    public int[] twoSum(int[] nums, int target) {
        int[] result = {0, 0};
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                result[0] = hashMap.get(target - nums[i]);
                result[1] = i;
                break;
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return result;
    }
}
