package com.leetcode.solutions.backTracking;

import com.leetcode.solutions.SolutionInterface;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q46_Permutations implements SolutionInterface {
    @Override
    public void run() {
    }

    //回溯水题。
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> curResult = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        backTracking(nums, used, 0, curResult, res);
        return res;
    }

    private void backTracking(int[] nums, boolean[] used, int size, List<Integer> curRes, List<List<Integer>> finalRes) {
        if (size == nums.length) {
            finalRes.add(new LinkedList<>(curRes));
        } else {
            for (int i = 0; i < nums.length; ++i) {
                if (!used[i]) {
                    used[i] = true;
                    curRes.add(nums[i]);
                    backTracking(nums, used, size + 1, curRes, finalRes);
                    curRes.remove(curRes.size() - 1);
                    used[i] = false;
                }
            }
        }
    }
}
