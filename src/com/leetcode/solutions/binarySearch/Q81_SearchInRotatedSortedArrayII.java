package com.leetcode.solutions.binarySearch;

import com.leetcode.solutions.SolutionInterface;

public class Q81_SearchInRotatedSortedArrayII implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 二分好题，最好效率O(logN)，最差效率O(n)。
     * 题目难点主要在于重复值可能导致左右两个端点处的值相等，中间值要么都大于端点处的值，要么都小于端点处的值，
     * 从而无法分辨出target究竟在mid左边还是mid右边。
     * 解决这个问题的一个简单方法就是破坏端点处值相等的前置条件，一旦左右端点等值就让一边不断向中间移动直到两边值不再相同，
     * 这样左边值，右边值，中间值就有了相对大小关系（题解中将不等于target的左右值全部去除，结合target与中间值的判断，
     * 可以严格保证数组左边值，右边值和中间值三者互不相等），也就可以根据这组大小关系判断target的所在区间，将问题转化为普通的二分搜索。
     */
    public boolean search(int[] nums, int target) {
        for (int left = 0, right = nums.length - 1; left <= right; ) {
            if (nums[left] == target || nums[right] == target) {
                return true;
            }
            while (left < right && nums[left] == nums[left + 1]) {
                left++;
            }
            while (left < right && nums[right] == nums[right - 1]) {
                right--;
            }
            if (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] > target) {
                    if (nums[mid] > nums[right] && nums[right] >= target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else if (nums[mid] < target) {
                    if (nums[mid] < nums[left] && nums[left] <= target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
