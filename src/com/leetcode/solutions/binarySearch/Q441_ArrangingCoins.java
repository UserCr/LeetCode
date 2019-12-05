package com.leetcode.solutions.binarySearch;

import com.leetcode.solutions.SolutionInterface;

public class Q441_ArrangingCoins implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。注意溢出问题和right的初始值要尽可能小。
    public int arrangeCoins(int n) {
        for (int left = 0, right = (int) Math.sqrt(2L * n); left <= right; ) {
            long mid = (left + right) / 2;
            long sum = (mid + 1) * mid / 2;
            if (sum <= n && sum + mid + 1 > n) {
                return (int) mid;
            } else if (sum + mid + 1 <= n) {
                left = (int) mid + 1;
            } else {
                right = (int) mid - 1;
            }
        }
        return -1;
    }
}
