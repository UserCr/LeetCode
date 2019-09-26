package com.leetcode.solutions.binarySearch;

import com.leetcode.solutions.SolutionInterface;

public class Q69_Sqrt_x implements SolutionInterface {
    @Override
    public void run() {
    }

    //注意这个题可以用二分的办法求解，即在1^2,2^2,3^2,...,n^2中找到解。
    public int mySqrt(int x) {
        for (int left = 1, right = Integer.MAX_VALUE; left <= right; ) {
            int mid = left + (right - left) / 2;
            // 应该是mid * mid和x进行比较，但是乘积可能会导致溢出，所以改成除法的形式。
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return 0;
    }
}
