package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

public class Q88_MergeSortedArray implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。注意nums1用尽而nums2还有剩余时的corner case。
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int writePos = m + n - 1, pos1 = m - 1, pos2 = n - 1; writePos >= 0; writePos--) {
            if (pos1 >= 0 && pos2 >= 0) {
                if (nums1[pos1] > nums2[pos2]) {
                    nums1[writePos] = nums1[pos1--];
                } else {
                    nums1[writePos] = nums2[pos2--];
                }
            } else if (pos2 >= 0) {
                nums1[writePos] = nums2[pos2--];
            } else {
                break;
            }
        }
    }
}
