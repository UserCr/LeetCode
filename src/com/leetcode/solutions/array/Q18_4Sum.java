package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q18_4Sum implements SolutionInterface {
    @Override
    public void run() {
    }

    //3Sum变种，水题。
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; ++i) {
            for (int j = i + 1; j < nums.length - 2; ++j) {
                int m = j + 1, n = nums.length - 1;
                while (m < n) {
                    if (nums[i] + nums[j] + nums[m] + nums[n] == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        while (m < nums.length - 1 && nums[m + 1] == nums[m]) {
                            m++;
                        }
                        while (0 < n && nums[n - 1] == nums[n]) {
                            n--;
                        }
                        m++;
                        n--;
                    } else if (nums[i] + nums[j] + nums[m] + nums[n] > target) {
                        n--;
                    } else {
                        m++;
                    }
                }
                while (j < nums.length - 1 && nums[j + 1] == nums[j]) {
                    j++;
                }
            }
            while (i < nums.length - 1 && nums[i + 1] == nums[i]) {
                i++;
            }
        }
        return res;
    }
}
