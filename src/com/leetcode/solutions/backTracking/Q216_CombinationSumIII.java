package com.leetcode.solutions.backTracking;

import com.leetcode.solutions.SolutionInterface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q216_CombinationSumIII implements SolutionInterface {
    @Override
    public void run() {
    }

    private int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1};

    //水题。
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> finalRes = new LinkedList<>();
        List<Integer> curRes = new ArrayList<>();
        backTracking(k, n, 0, curRes, finalRes);
        return finalRes;
    }

    private void backTracking(int k, int n, int startPos, List<Integer> curRes, List<List<Integer>> finalRes) {
        if (0 == k && 0 == n) {
            finalRes.add(new ArrayList<>(curRes));
            return;
        }
        for (int i = startPos; i < nums.length; ++i) {
            if (nums[i] <= n) {
                curRes.add(nums[i]);
                backTracking(k - 1, n - nums[i], i + 1, curRes, finalRes);
                curRes.remove(curRes.size() - 1);
            }
        }
    }
}
