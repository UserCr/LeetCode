package com.leetcode.solutions.backTracking;

import com.leetcode.solutions.SolutionInterface;

public class Q10_RegularExpressionMatching implements SolutionInterface {
    interface Algorithm {
        boolean isMatch(String s, String p);
    }

    @Override
    public void run() {
    }

    static class BackTracking implements Algorithm {
        //用回溯法做的话是个水题，需要特别注意的是*可以代表零个重复，所以模式串中只剩一堆*元素时也可以认为模式串匹配完成。
        @Override
        public boolean isMatch(String s, String p) {
            return isMatch(s, p, 0, 0);
        }

        private boolean isMatch(String s, String p, int sStart, int pStart) {
            if (sStart == s.length() && patternIsEnd(p, pStart)) {
                return true;
            } else if (sStart == s.length() || pStart == p.length()) {
                return false;
            }
            char curPatternChar = p.charAt(pStart);
            boolean isStar = pStart < p.length() - 1 && p.charAt(pStart + 1) == '*';
            if (isStar) {
                for (int curMatchPos = sStart - 1; curMatchPos < sStart || curMatchPos < s.length() &&
                        (curPatternChar == s.charAt(curMatchPos) || curPatternChar == '.'); curMatchPos++) {
                    boolean res = isMatch(s, p, curMatchPos + 1, pStart + 2);
                    if (res) {
                        return true;
                    }
                }
                return false;
            } else {
                return (s.charAt(sStart) == curPatternChar || '.' == curPatternChar) &&
                        isMatch(s, p, sStart + 1, pStart + 1);
            }
        }

        private boolean patternIsEnd(String p, int start) {
            if ((p.length() - start) % 2 == 1) {
                return false;
            }
            for (int i = start; i < p.length(); i += 2) {
                if (p.charAt(i) == '*' || p.charAt(i + 1) != '*') {
                    return false;
                }
            }
            return true;
        }
    }

    static class DP implements Algorithm {
        /***
         * 状态转移方程难度很大，需要仔细分析，专门记忆。
         * 如果 p.charAt(j) == s.charAt(i) or p.charAt(j) == '.'，那么dp[i][j] = dp[i-1][j-1]；
         * 如果 p.charAt(j) == '*'：
         *     如果 p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2] //in this case, a* only counts as empty
         *     如果 p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.'：
         *         dp[i][j] = dp[i-1][j] //in this case, a* counts as multiple a
         *         or dp[i][j] = dp[i][j-1] // in this case, a* counts as single a
         *         or dp[i][j] = dp[i][j-2] // in this case, a* counts as empty
         */
        @Override
        public boolean isMatch(String s, String p) {
            if (null == s || null == p) {
                return false;
            }

            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            //匹配串中前若干个连续的*元素通通为True，逻辑很好理解，空串可以和一组由*元素组成的模式串匹配。
            dp[0][0] = true;
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == '*' && dp[0][i - 1]) {
                    dp[0][i + 1] = true;
                }
            }
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < p.length(); j++) {
                    if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                        dp[i + 1][j + 1] = dp[i][j];
                    } else if (p.charAt(j) == '*') {
                        if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                            dp[i + 1][j + 1] = dp[i + 1][j - 1];
                        } else {
                            dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                        }
                    }
                }
            }
            return dp[s.length()][p.length()];
        }
    }
}
