package com.leetcode.solutions.array;

import com.leetcode.solutions.SolutionInterface;

import java.util.Arrays;

public class Q350_IntersectionOfTwoArraysII implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] res = new int[Math.max(nums1.length, nums2.length)];
        int resSize = 0;
        for (int pos1 = 0, pos2 = 0; pos1 < nums1.length && pos2 < nums2.length; ) {
            while (pos1 < nums1.length && nums1[pos1] < nums2[pos2]) {
                pos1++;
            }
            if (pos1 >= nums1.length) {
                break;
            }
            while (pos2 < nums2.length && nums2[pos2] < nums1[pos1]) {
                pos2++;
            }
            if (pos2 >= nums2.length) {
                break;
            }
            if (nums1[pos1] == nums2[pos2]) {
                res[resSize++] = nums1[pos1];
                pos1++;
                pos2++;
            }
        }
        res = Arrays.copyOf(res, resSize);
        return res;
    }
}
