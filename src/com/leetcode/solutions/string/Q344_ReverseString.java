package com.leetcode.solutions.string;

import com.leetcode.solutions.SolutionInterface;

public class Q344_ReverseString implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public void reverseString(char[] s) {
        for (int left = 0, right = s.length - 1; left < right; left++, right--) {
            swap(s, left, right);
        }
    }

    private void swap(char[] s, int i, int j) {
        s[i] ^= s[j];
        s[j] ^= s[i];
        s[i] ^= s[j];
    }
}
