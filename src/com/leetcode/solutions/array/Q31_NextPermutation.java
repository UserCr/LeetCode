package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

public class Q31_NextPermutation implements SolutionInterface {
    @Override
    public void run() {
    }

    //稍有难度，需要注意swap后的后半部分数组是降序的，只需翻转数组，不用排序。
    public void nextPermutation(int[] nums) {
        int swapPos = nums.length - 2;
        while (swapPos >= 0) {
            if (nums[swapPos] < nums[swapPos + 1]) {
                break;
            }
            swapPos--;
        }
        if (swapPos >= 0) {
            for (int i = nums.length - 1; i > swapPos; --i) {
                if (nums[i] > nums[swapPos]) {
                    swap(nums, swapPos, i);
                    break;
                }
            }
        }
        reverse(nums, swapPos + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
