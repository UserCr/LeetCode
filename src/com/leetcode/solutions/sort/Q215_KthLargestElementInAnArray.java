package com.leetcode.solutions.sort;

import com.leetcode.solutions.SolutionInterface;

import java.util.Random;

public class Q215_KthLargestElementInAnArray implements SolutionInterface {
    @Override
    public void run() {
    }

    private Random random = new Random();

    /**
     * 快速选择算法和快速排序思路近似。
     * partition和快排一样。教材里一般都是将第一个元素视为pivot，若要用随机pivot，只需将随机挑选的pivot和第一个元素交换。
     * partition操作会将一个元素，也就是pivot排到正确的位置上，因此快速排序算法的关键是判断pivot是否在目标位置上，
     * 如果不是的话就要判断目标位置在pivot左边还是右边，然后对左边（右边）区间再次做partition操作直到找到正确解。
     * 这一过程思路有点类似于二分查找。
     */
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int pos = partition(nums, left, right);
            if (nums.length - k == pos) {
                return nums[pos];
            } else if (nums.length - k > pos) {
                left = pos + 1;
            } else {
                right = pos - 1;
            }
        }
        return 0;
    }

    private int partition(int[] nums, int left, int right) {
        int pivotPos = left + random.nextInt(right - left + 1);
        int pivot = nums[pivotPos];
        nums[pivotPos] = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}
