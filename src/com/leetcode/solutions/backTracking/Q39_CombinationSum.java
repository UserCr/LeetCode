package com.leetcode.solutions.backTracking;

import com.leetcode.solutions.SolutionInterface;

import java.util.LinkedList;
import java.util.List;

public class Q39_CombinationSum implements SolutionInterface {
    @Override
    public void run() {
    }

    //回溯。DP也可以做，不过递归形式和非递归形式要生成大量的List对象，效率不高。
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> curResult = new LinkedList<>();
        backTracking(candidates, 0, target, curResult, res);
        return res;
    }

    private void backTracking(int[] candidates, int curPos, int target, List<Integer> curResult,
                              List<List<Integer>> finalResult) {
        if (0 == target) {
            finalResult.add(new LinkedList<>(curResult));
        } else {
            for (int i = curPos; i < candidates.length; ++i) {
                if (target - candidates[i] >= 0) {
                    curResult.add(candidates[i]);
                    backTracking(candidates, i, target - candidates[i], curResult, finalResult);
                    curResult.remove(curResult.size() - 1);
                }
            }
        }
    }
}
