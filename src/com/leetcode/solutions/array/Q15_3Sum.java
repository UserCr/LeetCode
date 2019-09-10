package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q15_3Sum implements SolutionInterface {
    @Override
    public void run() {
    }

    //里循环不要写成两层循环的模式，那样是O(n^3)复杂度。因为已经排过序，所以可以用双指针法将里循环时间复杂度降至O(n)
    public List<List<Integer>> threeSum(int[] nums) {
        final int TARGET_SUM = 0;
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i) {
            int m = i + 1, n = nums.length - 1;
            while (m < n) {
                if (nums[i] + nums[m] + nums[n] == TARGET_SUM) {
                    res.add(Arrays.asList(nums[i], nums[m], nums[n]));
                    while (m < nums.length - 1 && nums[m + 1] == nums[m]) {
                        m++;
                    }
                    m++;
                    while (0 < n && nums[n - 1] == nums[n]) {
                        n--;
                    }
                    n--;
                } else if (nums[i] + nums[m] + nums[n] < TARGET_SUM) {
                    m++;
                } else {
                    n--;
                }
            }
            while (i < nums.length - 1 && nums[i + 1] == nums[i]) {
                i++;
            }
        }
        return res;
    }
}
