package com.leetcode.solutions.binarySearch;

import com.leetcode.solutions.SolutionInterface;

public class Q278_FirstBadVersion implements SolutionInterface {

    @Override
    public void run() {
    }

    /**
     * 题目难点在于优化iaBadVersion的调用次数。
     * 由题意可知题目一定有解，这是后续优化的基础。只要保证[left, right]中的都是坏版本且每次将区间范围折半的话，
     * 就可以保证left一定可以和right相等且为解。
     */
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left != right) {
            //注意溢出。
            int mid = left + (right - left) / 2;
            if (!isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private boolean isBadVersion(int version) {
        final int ANSWER = 1702766719;
        return version >= ANSWER;
    }
}
