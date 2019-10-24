package com.leetcode.solutions.hashmap;

import com.leetcode.solutions.SolutionInterface;

import java.util.HashMap;
import java.util.Map;

public class Q219_ContainsDuplicateII implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> lastPos = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            Integer pos = lastPos.get(nums[i]);
            if (null != pos && i - pos <= k) {
                return true;
            }
            lastPos.put(nums[i], i);
        }
        return false;
    }
}
