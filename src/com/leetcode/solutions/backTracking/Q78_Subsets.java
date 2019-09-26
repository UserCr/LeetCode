package com.leetcode.solutions.backTracking;

import com.leetcode.solutions.SolutionInterface;

import java.util.LinkedList;
import java.util.List;

public class Q78_Subsets implements SolutionInterface {
    interface Algorithm {
        List<List<Integer>> subsets(int[] nums);
    }

    @Override
    public void run() {
    }

    static class BackTracking implements Algorithm {
        //回溯水题。
        @Override
        public List<List<Integer>> subsets(int[] nums) {
            List<Integer> curRes = new LinkedList<>();
            List<List<Integer>> finalRes = new LinkedList<>();
            for (int n = 0; n <= nums.length; ++n) {
                backTracking(nums, 0, n, curRes, finalRes);
            }
            return finalRes;
        }

        private void backTracking(int[] nums, int startPos, int n, List<Integer> curRes, List<List<Integer>> finalRes) {
            if (0 == n) {
                finalRes.add(new LinkedList<>(curRes));
            } else {
                for (int i = startPos; i < nums.length; ++i) {
                    curRes.add(nums[i]);
                    backTracking(nums, i + 1, n - 1, curRes, finalRes);
                    curRes.remove(curRes.size() - 1);
                }
            }
        }
    }

    static class BitMap implements Algorithm {
        //注意观察可发现解正好对应有限位数二进制数的遍历，所以此题可用bitMap的方法做。
        @Override
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> finalRes = new LinkedList<>();
            for (int i = 0; i < Math.pow(2, nums.length); ++i) {
                List<Integer> curRes = new LinkedList<>();
                for (int bit = i, pos = 0; bit > 0; bit >>= 1, pos++) {
                    if ((bit & 1) == 1) {
                        curRes.add(nums[pos]);
                    }
                }
                finalRes.add(curRes);
            }
            return finalRes;
        }
    }
}
