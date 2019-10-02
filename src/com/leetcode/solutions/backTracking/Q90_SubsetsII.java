package com.leetcode.solutions.backTracking;

import com.leetcode.solutions.SolutionInterface;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q90_SubsetsII implements SolutionInterface {
    @Override
    public void run() {
    }

    //有点难度的回溯水题。
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> curRes = new LinkedList<>();
        List<List<Integer>> finalRes = new LinkedList<>();
        for (int i = 0; i <= nums.length; ++i) {
            backTracking(nums, 0, i, curRes, finalRes);
        }
        return finalRes;
    }

    private void backTracking(int[] nums, int startPos, int leftNumber, List<Integer> curRes, List<List<Integer>> finalRes) {
        if (0 == leftNumber) {
            finalRes.add(new LinkedList<>(curRes));
        } else {
            for (int curPos = startPos, firstPos = startPos; curPos < nums.length; ++curPos) {
                if (!(curPos != firstPos && nums[firstPos] == nums[curPos])) {
                    firstPos = curPos;
                    curRes.add(nums[curPos]);
                    backTracking(nums, curPos + 1, leftNumber - 1, curRes, finalRes);
                    curRes.remove(curRes.size() - 1);
                }
            }
        }
    }
}
