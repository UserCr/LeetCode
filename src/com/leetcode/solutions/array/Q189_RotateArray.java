package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

public class Q189_RotateArray implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题，详见《编程珠玑》。
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}
