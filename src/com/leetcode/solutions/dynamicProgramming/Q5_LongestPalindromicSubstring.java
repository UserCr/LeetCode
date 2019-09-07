package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

public class Q5_LongestPalindromicSubstring implements SolutionInterface {
    @Override
    public void run() {
        System.out.println(longestPalindrome_2("ccc"));
    }

    public String longestPalindrome_1(String s) {
        //Manacher's Algorithm
        if (s.isEmpty()) return "";
        s = "#".concat(String.join("#", s.split(""))).concat("#");
        int[] RL = new int[s.length()];
        int pos = 0, maxRight = 0;
        RL[0] = 1;
        for (int i = 0; i < s.length(); ++i) {
            if (i > maxRight) {
                RL[i] = 1;
            } else {
                RL[i] = Math.min(RL[pos - (i - pos)], maxRight - i + 1);
            }
            while (i - RL[i] >= 0 && i + RL[i] < s.length() && s.charAt(i - RL[i]) == s.charAt(i + RL[i])) {
                RL[i]++;
            }
            if (i + RL[i] - 1 > maxRight) {
                pos = i;
                maxRight = i + RL[i] - 1;
            }
        }
        int max = 0;
        for (int i = 1; i < RL.length; ++i) {
            if (RL[max] < RL[i]) {
                max = i;
            }
        }
        int left = max - RL[max] + 1, right = max + RL[max] - 1;
        return s.substring(left, right).replaceAll("#", "");
    }

    public String longestPalindrome_2(String s) {
        //DP
        if (s.isEmpty()) return "";
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        int max_i = 0, max_j = 0;
        for (int j = 0; j < s.length(); ++j) {
            for (int i = j; i >= 0; --i) {
                isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || isPalindrome[i + 1][j - 1]);
                if (isPalindrome[i][j] && j - i > max_j - max_i) {
                    max_i = i;
                    max_j = j;
                }
            }
        }
        return s.substring(max_i, max_j + 1);
    }
}
