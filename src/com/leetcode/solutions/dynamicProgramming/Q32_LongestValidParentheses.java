package com.leetcode.solutions.dynamicProgramming;

import com.leetcode.solutions.SolutionInterface;

import java.util.Stack;

public class Q32_LongestValidParentheses implements SolutionInterface {
    interface Algorithm {
        int longestValidParentheses(String s);
    }

    @Override
    public void run() {
    }

    static class UseStack implements Algorithm {
        /***
         * 水题。dp含义是以目前字符作为结尾且合法的括号序列的最长长度，栈用来寻找与当前）匹配的（。
         */
        @Override
        public int longestValidParentheses(String s) {
            Stack<Integer> stack = new Stack<>();
            int[] dp = new int[s.length()];
            int maxLength = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if ('(' == c) {
                    stack.push(i);
                } else {
                    if (!stack.isEmpty()) {
                        int j = stack.pop();
                        int length = i - j + 1;
                        if (j > 0 && s.charAt(j - 1) == ')') {
                            length += dp[j - 1];
                        }
                        dp[i] = length;
                        maxLength = Math.max(maxLength, length);
                    }
                }
            }
            return maxLength;
        }
    }

    static class NotUseStack implements Algorithm {
        /***
         * 使用栈方式的改进版，实际上寻找与当前）匹配的（完全可以利用dp信息推算出来，这样就可以把栈消去，也就是不利用栈的DP算法。
         */
        @Override
        public int longestValidParentheses(String s) {
            int[] dp = new int[s.length()];
            int maxLength = 0;
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (')' == c) {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = 2;
                        if (i - 2 >= 0) {
                            dp[i] += dp[i - 2];
                        }
                    } else {
                        if (i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
                            dp[i] = dp[i - 1] + 2;
                            if (i - 1 - dp[i - 1] - 1 >= 0) {
                                dp[i] += dp[i - 1 - dp[i - 1] - 1];
                            }
                        }
                    }
                }
                maxLength = Math.max(maxLength, dp[i]);
            }
            return maxLength;
        }
    }
}
