package com.leetcode.solutions.array;

import com.leetcode.CommonPrint;
import com.leetcode.solutions.SolutionInterface;

import java.util.HashMap;

public class Q1_TwoSum implements SolutionInterface {
    @Override
    public void run() {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        CommonPrint.PrintIntArray(solution.twoSum(nums, 9));
    }

    //HashMap简单应用，水题。

    class Solution {
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
}
