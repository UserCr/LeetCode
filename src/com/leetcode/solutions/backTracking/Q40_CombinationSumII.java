package com.leetcode.solutions.backTracking;

import com.leetcode.solutions.SolutionInterface;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q40_CombinationSumII implements SolutionInterface {
    @Override
    public void run() {
    }

    //回溯水题。
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> curRes = new LinkedList<>();
        backTracking(candidates, target, 0, curRes, res);
        return res;
    }

    private void backTracking(int[] candidates, int target, int curPos, List<Integer> curRes,
                              List<List<Integer>> finalRes) {
        if (0 == target) {
            finalRes.add(new LinkedList<>(curRes));
        } else {
            for (int i = curPos; i < candidates.length; ++i) {
                if (target - candidates[i] >= 0) {
                    curRes.add(candidates[i]);
                    backTracking(candidates, target - candidates[i], i + 1, curRes, finalRes);
                    curRes.remove(curRes.size() - 1);
                    while (i < candidates.length - 1 && candidates[i + 1] == candidates[i]) {
                        i++;
                    }
                }
            }
        }
    }
}
