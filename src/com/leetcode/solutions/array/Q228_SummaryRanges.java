package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

import java.util.LinkedList;
import java.util.List;

public class Q228_SummaryRanges implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        if (null == nums || 0 == nums.length) {
            return res;
        }
        int min = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1] + 1) {
                addRange(res, min, nums[i - 1]);
                min = nums[i];
            }
        }
        addRange(res, min, nums[nums.length - 1]);
        return res;
    }

    private void addRange(List<String> res, int min, int max) {
        if (min == max) {
            res.add(String.valueOf(min));
        } else {
            res.add(min + "->" + max);
        }
    }
}
