package com.leetcode.solutions.string;

import com.leetcode.solutions.SolutionInterface;

public class Q345_ReverseVowelsOfAString implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        for (int left = 0, right = s.length() - 1; left < right; ) {
            while (isVowel(chars[left]) && left < right) {
                left++;
            }
            while (isVowel(chars[right]) && left < right) {
                right--;
            }
            if (left < right) {
                swap(chars, left++, right--);
            }
        }
        return String.valueOf(chars);
    }

    private boolean isVowel(char c) {
        return 'a' != c && 'e' != c && 'i' != c && 'o' != c && 'u' != c &&
                'A' != c && 'E' != c && 'I' != c && 'O' != c && 'U' != c;
    }

    private void swap(char[] s, int i, int j) {
        s[i] ^= s[j];
        s[j] ^= s[i];
        s[i] ^= s[j];
    }
}
