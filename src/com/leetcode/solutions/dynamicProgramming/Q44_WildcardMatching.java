package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

public class Q44_WildcardMatching implements SolutionInterface {
    interface Algorithm {
        boolean isMatch(String s, String p);
    }

    @Override
    public void run() {
    }

    static class DP implements Algorithm {
        //DP水题。
        @Override
        public boolean isMatch(String s, String p) {
            boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
            dp[0][0] = true;
            for (int i = 0; i < p.length(); ++i) {
                if ('*' == p.charAt(i)) {
                    int j = 0;
                    while (j <= s.length() && !dp[i][j]) {
                        j++;
                    }
                    while (j <= s.length()) {
                        dp[i + 1][j++] = true;
                    }
                } else {
                    for (int j = 0; j < s.length(); ++j) {
                        if ((p.charAt(i) == '?' || s.charAt(j) == p.charAt(i)) && dp[i][j]) {
                            dp[i + 1][j + 1] = true;
                        }
                    }
                }
            }
            return dp[p.length()][s.length()];
        }
    }

    static class Recursive implements Algorithm {
        //迭代方法有些难度，主要是在处理*匹配方面。
        @Override
        public boolean isMatch(String s, String p) {
            int sPos = 0, pPos = 0, starPos = -1, starMatchPos = 0;
            while (sPos < s.length()) {
                if (pPos < p.length() && (p.charAt(pPos) == '?' || s.charAt(sPos) == p.charAt(pPos))) {
                    sPos++;
                    pPos++;
                } else if (pPos < p.length() && p.charAt(pPos) == '*') {
                    // 碰到*，用starPos记录*的位置，starMatchPos是*匹配s子串的结尾，第一次遇到*认为*匹配一个空串
                    starPos = pPos;
                    starMatchPos = sPos;
                    pPos++;
                } else if (starPos != -1) {
                    // 字符不匹配也不是*，之前又遇到过*，这里需要回退。pPos重新回退到*的后一个位置，*匹配的子串加入一个字符。
                    pPos = starPos + 1;
                    starMatchPos++;
                    sPos = starMatchPos;
                } else {
                    return false;
                }
            }
            //将所有末尾的*全部匹配空串
            while (pPos < p.length() && p.charAt(pPos) == '*') {
                pPos++;
            }
            return pPos == p.length();
        }
    }
}
