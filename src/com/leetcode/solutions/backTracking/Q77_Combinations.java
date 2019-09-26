package com.leetcode.solutions.backTracking;

import com.leetcode.solutions.SolutionInterface;

import java.util.LinkedList;
import java.util.List;

public class Q77_Combinations implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题，注意剪枝，剪枝的地方非常容易想到。
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> curRes = new LinkedList<>();
        List<List<Integer>> finalRes = new LinkedList<>();
        backTracking(k, 0, n, curRes, finalRes);
        return finalRes;
    }

    private void backTracking(int k, int lastNumber, int n, List<Integer> curRes, List<List<Integer>> finalRes) {
        if (0 == k) {
            finalRes.add(new LinkedList<>(curRes));
        } else {
            for (int i = lastNumber + 1; i <= n - k + 1; ++i) {
                curRes.add(i);
                backTracking(k - 1, i, n, curRes, finalRes);
                curRes.remove(curRes.size() - 1);
            }
        }
    }
}
