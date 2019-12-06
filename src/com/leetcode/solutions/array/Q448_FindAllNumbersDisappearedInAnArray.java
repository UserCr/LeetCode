package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

import java.util.ArrayList;
import java.util.List;

public class Q448_FindAllNumbersDisappearedInAnArray implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) {
                int toMove = nums[i];
                while (nums[toMove - 1] != toMove) {
                    int temp = nums[toMove - 1];
                    nums[toMove - 1] = toMove;
                    toMove = temp;
                }
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
