package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q9_PalindromeNumber implements SolutionInterface {
    @Override
    public void run() {
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int reverseNumber = 0;
        for (int temp = x; temp > 0; temp /= 10) {
            int pre = reverseNumber;
            reverseNumber = reverseNumber * 10 + temp % 10;
            if (reverseNumber / 10 != pre) {
                return false;
            }
        }
        return reverseNumber == x;
    }
}
