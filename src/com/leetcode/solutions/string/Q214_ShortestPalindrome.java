package com.leetcode.solutions.string;

import com.leetcode.solutions.SolutionInterface;

public class Q214_ShortestPalindrome implements SolutionInterface {
    interface Algorithm {
        String shortestPalindrome(String s);
    }

    @Override
    public void run() {
    }

    class KMP_Base implements Algorithm {
        @Override
        public String shortestPalindrome(String s) {
            //TODO: 复习完KMP算法后一起做
            return null;
        }
    }

    class BruteForce implements Algorithm {
        @Override
        public String shortestPalindrome(String s) {
            int insertLength = 0;
            StringBuilder stringBuilder = new StringBuilder();
            while (insertLength < s.length()) {
                String substring = s.substring(0, s.length() - insertLength);
                if (isPalindrome(substring)) {
                    String pre = s.substring(s.length() - insertLength);
                    stringBuilder.append(pre);
                    stringBuilder.reverse();
                    stringBuilder.append(s);
                    break;
                }
                insertLength++;
            }
            return stringBuilder.toString();
        }

        private boolean isPalindrome(String s) {
            char[] chars = s.toCharArray();
            for (int left = 0, right = s.length() - 1; left < right; left++, right--) {
                if (chars[left] != chars[right]) {
                    return false;
                }
            }
            return true;
        }
    }
}
