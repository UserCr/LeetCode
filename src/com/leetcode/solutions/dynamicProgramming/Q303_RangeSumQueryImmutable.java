package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

public class Q303_RangeSumQueryImmutable implements SolutionInterface {
    @Override
    public void run() {
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     * You may assume that the array does not change.
     * There are many calls to sumRange(i,j) function.
     */

    //水题。注意将所有结果存进二维数组后会超空间，即使压缩成三角数组后仍旧会超空间，所以存到目前元素的累积和，返回和之间的差值。
    class NumArray {

        private int[] sum;

        public NumArray(int[] nums) {
            sum = new int[nums.length + 1];
            sum[0] = 0;
            for (int i = 0; i < nums.length; ++i) {
                sum[i + 1] = sum[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }
    }
}
