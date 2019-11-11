package com.leetcode.solutions.binarySearch;

import com.leetcode.solutions.SolutionInterface;

public class Q275_H_IndexII implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。h的二分判别稍有麻烦。
    public int hIndex(int[] citations) {
        final int N = citations.length;
        for (int left = 0, right = citations.length - 1; left <= right; ) {
            int mid = (left + right) / 2;
            int h = N - mid;
            if (h <= citations[mid] && (mid == 0 || h >= citations[mid - 1])) {
                return h;
            } else if (h <= citations[mid]) {
                right = mid - 1;
            } else if (h > citations[mid]) {
                left = mid + 1;
            }
        }
        return 0;
    }
}
