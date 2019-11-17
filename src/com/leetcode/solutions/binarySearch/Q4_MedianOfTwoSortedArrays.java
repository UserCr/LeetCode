package com.leetcode.solutions.binarySearch;

import com.leetcode.solutions.SolutionInterface;

public class Q4_MedianOfTwoSortedArrays implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 难度不小。两个数组A，B分别从第i个位置和第j个位置切分成两半后分别记作A1,A2,B1,B2，关键要点是要保证:
     * 1.len(A1 + B1) = len(A2 + B2)
     * 2.A[i-1] < B[j] && B[j-1] < A[i]
     * 若保证第一点，则j = (A.length + B.length + 1) / 2 - i，因为A和B长度总和有为奇数的情况，所以要加一。
     * 若保证第二点，只需将i左右移动即可。
     * 最后求解时，只要找到Max(A[i-1], B[j-1])和Min(B[i], A[j])，就可以根据这两个元素求解。
     * 只不过i和j可能会在数组两端边界，A和B长度总和可能为奇数，这些特殊情况需要单独处理。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1.length <= nums2.length ? nums1 : nums2;
        int[] B = nums1.length <= nums2.length ? nums2 : nums1;

        for (int left = 0, right = A.length; left <= right; ) {
            int i = (left + right) / 2;
            int j = (A.length + B.length + 1) / 2 - i;
            if (i < A.length && j > 0 && B[j - 1] > A[i]) {
                left = i + 1;
            } else if (j < B.length && i > 0 && A[i - 1] > B[j]) {
                right = i - 1;
            } else {
                int leftMax = 0;
                if (0 == i) {
                    leftMax = B[j - 1];
                } else if (0 == j) {
                    leftMax = A[i - 1];
                } else {
                    leftMax = Math.max(A[i - 1], B[j - 1]);
                }
                if ((A.length + B.length) % 2 == 1) {
                    return leftMax;
                }

                int rightMin = 0;
                if (A.length == i) {
                    rightMin = B[j];
                } else if (B.length == j) {
                    rightMin = A[i];
                } else {
                    rightMin = Math.min(A[i], B[j]);
                }

                return (leftMax + rightMin) / 2.0;
            }
        }
        return 0;
    }
}
