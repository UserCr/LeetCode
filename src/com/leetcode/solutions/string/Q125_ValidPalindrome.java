package com.leetcode.solutions.string;

import com.leetcode.solutions.SolutionInterface;

public class Q125_ValidPalindrome implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        for (int left = 0, right = s.length() - 1; left < right; left++, right--) {
            while (left < right && !Character.isLowerCase(s.charAt(left)) && !Character.isDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLowerCase(s.charAt(right)) && !Character.isDigit(s.charAt(right))) {
                right--;
            }
            if (left < right && s.charAt(left) != s.charAt(right)) {
                return false;
            }
        }
        return true;
    }
}
